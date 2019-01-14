package com.ensim.GestionTournoi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppliController
{
	@GetMapping("/index")
	public String index(Model model){
		return "index";
	}

    @GetMapping("/connexion")
    public String connexion(Model model) {
        return "connexion";
    }

	@GetMapping("/inscription")
	public String inscription(Model model){
		return "inscription";
	}

    @GetMapping("/creationTournoi")
    public String creationTournoi(Model model) {
        return "creationTournoi";
    }

    @GetMapping("/tournoi")
    public String tournoi(Model model) {
        return "tournoi";
    }
}
