package com.ensim.GestionTournoi.Controller;


import com.ensim.GestionTournoi.Model.ModelDAO.CoupeRepository;
import com.ensim.GestionTournoi.Model.TournoiRepository;

import com.ensim.GestionTournoi.Model.Coupe;

import com.ensim.GestionTournoi.Model.Tournoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AffichageTournoiController
{
    @Autowired
    private CoupeRepository coupeRepository;

    @GetMapping("/affichageTournoi")
    public String arbre(@RequestParam(name = "id", defaultValue = "1") long id, Model model)
    {
        String coupe;
        Optional<Coupe> tour = coupeRepository.findById(id);
        if (tour.isPresent()) {
            coupe = tour.get().getJson();
        } else {
            coupe = "{}";
        }


        model.addAttribute("coupe", coupe);
        return "arbre";

    }

}
