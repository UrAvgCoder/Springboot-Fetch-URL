package com.valorant.offsets.valorantoffsets.services;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.valorant.offsets.valorantoffsets.models.Offsets;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
public class FetchURLData {

    private static String OFFSET_URL = "https://raw.githubusercontent.com/apekros/valorant_offsets/master/valorant.hpp";

    public ArrayList<Offsets> getResultant() {
        return resultant;
    }

    private ArrayList<Offsets> resultant = new ArrayList<>();

    public String getLastUpdate() {
        return lastUpdate;
    }

    private String lastUpdate = "";

    @PostConstruct
    @Scheduled(cron = "0 0 5 * * *")
    @Scheduled(cron = "0 0 17 * * *")
    public void fetchData() throws IOException, InterruptedException {
        ArrayList<Offsets> temp = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                        .uri(URI.create(OFFSET_URL))
                        .build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        //System.out.println(res.body());
        String[] lines = res.body().split(System.lineSeparator());
        lastUpdate = lines[5].substring(11, lines[5].length());
        for(int i=12; i<lines.length; i++) {
            Offsets obj = new Offsets();
            obj.setName(lines[i].split(" ")[1]);
            obj.setValue(lines[i].split(" ")[3].replace(";", ""));
            temp.add(obj);
        }

        System.out.println(temp);
        resultant = temp;
    }

}
