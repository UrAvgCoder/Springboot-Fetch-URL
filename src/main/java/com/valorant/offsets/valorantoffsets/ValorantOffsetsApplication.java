package com.valorant.offsets.valorantoffsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ValorantOffsetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValorantOffsetsApplication.class, args);
	}

}
