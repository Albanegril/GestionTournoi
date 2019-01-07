package com.ensim.GestionTournoi.Model;

public class Adresse {
	private String ville = new String();
	private String rue = new String();
	private String salle = new String();
	private String terrain = new String();
	
	/// Constructeurs
	public Adresse() {}

	public Adresse(String ville, String rue, String salle, String terrain) {
		super();
		this.ville = ville;
		this.rue = rue;
		this.salle = salle;
		this.terrain = terrain;
	}

	/// Getters & Setters 
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

}
