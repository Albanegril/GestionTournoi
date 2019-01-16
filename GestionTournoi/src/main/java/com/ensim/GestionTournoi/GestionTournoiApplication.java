package com.ensim.GestionTournoi;

import com.ensim.GestionTournoi.Model.Coupe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionTournoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTournoiApplication.class, args);
		Coupe coupe = new Coupe();

	}

}

