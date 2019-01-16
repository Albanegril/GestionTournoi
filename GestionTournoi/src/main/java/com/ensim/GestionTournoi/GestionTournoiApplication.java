package com.ensim.GestionTournoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ensim.GestionTournoi.Model.Coupe;

@SpringBootApplication
public class GestionTournoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTournoiApplication.class, args);
		@SuppressWarnings("unused")
		Coupe coupe = new Coupe();

	}
}

