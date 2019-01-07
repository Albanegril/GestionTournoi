package com.ensim.GestionTournoi.Model;
public abstract class Resultat {
	private Participant vainqueur;

	///Constructeurs
	public Resultat() { }

	public Resultat(Participant vainqueur) {
		super();
		this.vainqueur = vainqueur;
	}
	
	///Getters & Setters
	public Participant getVainqueur() {
		return vainqueur;
	}

	public void setVainqueur(Participant vainqueur) {
		this.vainqueur = vainqueur;
	}

}
