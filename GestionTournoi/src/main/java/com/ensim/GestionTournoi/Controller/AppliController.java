package com.ensim.GestionTournoi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping("/resultatMatch")
    public String resultatMatch(Model model) {
        return "resultatMatch";
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public String messages(Model model) {
        return "";
    }
}
