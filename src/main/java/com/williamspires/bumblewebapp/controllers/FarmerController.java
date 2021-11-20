package com.williamspires.bumblewebapp.controllers;

import com.williamspires.bumblewebapp.models.Farmer;
import com.williamspires.bumblewebapp.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FarmerController {

    @Autowired
    FarmerRepository farmerRepository;

    @GetMapping("/")
    public String getAllFarmers(Model model) {
        List<Farmer> allFarmers = farmerRepository.findAll();
        model.addAttribute("farmers", allFarmers);
        return "allFarmers";
    }

    @GetMapping("/farmers/{id}")
    public String getFarmerById(@PathVariable("id") String id, Model model) {
        Farmer farmer = farmerRepository.getById(id);
        model.addAttribute("farmer", farmer);
        return "farmerById";
    }
}
