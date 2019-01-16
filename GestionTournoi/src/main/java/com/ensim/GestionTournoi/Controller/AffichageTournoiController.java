package com.ensim.GestionTournoi.Controller;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AffichageTournoiController
{
    @GetMapping("/affichageTournoi")
    public String arbre(@RequestParam(name="id",defaultValue = "1") int id, Model model) {
        //String tournoi

        //model.addAttribute("tournoi",tournoi);
        return "arbre";

    }

}
