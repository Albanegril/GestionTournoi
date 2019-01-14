package com.ensim.GestionTournoi.Model;

public class Default extends Resultat {
	private int resultat1;
	private int resultat2;

	///Constructeurs
	public Default() {	}

	public Default(int resultat1, int resultat2, Equipe vainqueur) {
		super(vainqueur);
		this.resultat1 = resultat1;
		this.resultat2 = resultat2;
	}
	
	///Getters & Setters
	public int getResultat1() {
		return resultat1;
	}

	public void setResultat1(int resultat1) {
		this.resultat1 = resultat1;
	}

	public int getResultat2() {
		return resultat2;
	}

	public void setResultat2(int resultat2) {
		this.resultat2 = resultat2;
	}

}
