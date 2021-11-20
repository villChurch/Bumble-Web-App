package com.williamspires.bumblewebapp.controllers;

import com.williamspires.bumblewebapp.models.Goats;
import com.williamspires.bumblewebapp.repositories.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
public class GoatController {

    @Autowired
    GoatRepository goatRepository;

    @GetMapping("/goats/all")
    public String allGoats(Model model) {
        List<Goats> allGoats = goatRepository.findAll();
        model.addAttribute("goats", allGoats);
        return "allGoats";
    }

    @GetMapping("/goats/{farmerId}")
    public String getFarmersGoats(@PathVariable("farmerId") String farmerId, Model model) {
        List<Goats> farmersGoats = goatRepository.findGoatsByOwnerId(farmerId);
        model.addAttribute("goats", farmersGoats);
        return "farmerGoats";
    }

    @GetMapping("/goats/slideshow")
    public String getSlideshow(Model model) {
        List<Goats> allGoats = goatRepository.findAll();
        allGoats.sort(Comparator.comparing(Goats::getLevel).reversed());
        model.addAttribute("goat1", allGoats.get(0));
        model.addAttribute("goat2", allGoats.get(1));
        model.addAttribute("goat3", allGoats.get(2));
        return "goatCarousel";
    }

    @GetMapping("goats/id/{id}")
    public String getGoatById(@PathVariable("id") int id, Model model) throws Exception {
        Optional<Goats> oGoat = goatRepository.findById(id);
        if (oGoat.isEmpty()) {
            throw new Exception("goat not found");
        }
        Goats goat = oGoat.get();
        model.addAttribute("goat", goat);
        return "goatById";
    }

    @GetMapping("/goats/meet/{id}")
    public String meetGoatsByFarmerId(@PathVariable("id") String id, Model model) {
        List<Goats> farmersGoats = goatRepository.findGoatsByOwnerId(id);
        model.addAttribute("goats", farmersGoats);
        return "meetYourGoats";
    }
}
