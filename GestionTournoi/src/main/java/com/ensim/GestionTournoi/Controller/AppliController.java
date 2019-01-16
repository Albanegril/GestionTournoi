package com.ensim.GestionTournoi.Controller;

import com.ensim.GestionTournoi.Model.Adresse;
import com.ensim.GestionTournoi.Model.ModelDAO.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppliController
{
    @Autowired
    AdresseRepository adrDAO;

	@GetMapping("/index")
	public String index(Model model){
        Adresse test1 = new Adresse("Peymeinade","Av des Jaisous",156);
        adrDAO.save(test1);
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
