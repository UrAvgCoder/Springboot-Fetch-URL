package com.valorant.offsets.valorantoffsets.controller;

import com.valorant.offsets.valorantoffsets.models.Offsets;
import com.valorant.offsets.valorantoffsets.services.FetchURLData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class RenderController {

    @Autowired
    FetchURLData fetchURLData;

    @GetMapping("/")
    public String render(Model model) {
        ArrayList<Offsets> offsets = fetchURLData.getResultant();
        model.addAttribute("offsets", offsets);
        model.addAttribute("lastupdate", fetchURLData.getLastUpdate());
        return "render";
    }
}
