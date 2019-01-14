package com.ensim.GestionTournoi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public abstract class Participant {


	private Long id_participant;
	private String nomParticipant = new String();
	private Adresse adresse = new Adresse();
	
	/// Constructeurs
	public Participant() {}

	public Participant(String nomParticipant, Adresse adresse) {
		super();
		this.nomParticipant = nomParticipant;
		this.adresse = adresse;
	}

	///Getters & Setters
	public String getNomParticipant() {
		return nomParticipant;
	}

	public void setNomParticipant(String nomParticipant) {
		this.nomParticipant = nomParticipant;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
