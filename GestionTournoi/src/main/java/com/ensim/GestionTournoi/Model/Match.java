package com.ensim.GestionTournoi.Model;

import java.util.Date;

public class Match {
	private Date date = new Date();
	private Adresse lieu = new Adresse();

	///Constructeurs
	public Match() {
	}

	public Match(Date date, Adresse lieu) {
		super();
		this.date = date;
		this.lieu = lieu;
	}

	///Getters & Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Adresse getLieu() {
		return lieu;
	}

	public void setLieu(Adresse lieu) {
		this.lieu = lieu;
	}
	
}
