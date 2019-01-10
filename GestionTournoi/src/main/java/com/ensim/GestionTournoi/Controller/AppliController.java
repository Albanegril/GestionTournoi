package com.ensim.GestionTournoi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppliController {
    
    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
    
    @GetMapping("/navbar")
    public String navbar(Model model) {
        return "navbar";
    }

}