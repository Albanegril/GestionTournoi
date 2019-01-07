package com.ensim.GestionTournoi.Model;

public class Tournoi {
	private String nomTournoi = new String();
	private String activite = new String();
	private boolean publique = true;
	private Type type;
	
	///Constructeur
	public Tournoi() {
	}
	
	public Tournoi(String nomTournoi, String activite, boolean publique, Type type) {
		this.nomTournoi = nomTournoi;
		this.activite = activite;
		this.publique = publique;
		this.type = type;
	}
	
	///Getters & Setters
	public String getNomTournoi() {
		return nomTournoi;
	}

	public void setNomTournoi(String nomTournoi) {
		this.nomTournoi = nomTournoi;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public boolean isPublique() {
		return publique;
	}

	public void setPublique(boolean publique) {
		this.publique = publique;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
