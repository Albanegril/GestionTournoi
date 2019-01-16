package com.ensim.GestionTournoi.Controller;


import com.ensim.GestionTournoi.Model.ModelDAO.TournoiRepository;
import com.ensim.GestionTournoi.Model.Tournoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AffichageTournoiController
{
    @Autowired
    TournoiRepository tournoiRepository;

    @GetMapping("/affichageTournoi")
    public String arbre(@RequestParam(name="id",defaultValue = "1") int id, Model model) {
        String tournoi;
        Optional<Tournoi> tour = tournoiRepository.findById(id);
        if(tour.isPresent())
        {
            tournoi = tour.get().getJson();
        }
        else
        {
            tournoi = "{}";
        }

        model.addAttribute("tournoi",tournoi);
        return "arbre";

    }

}
