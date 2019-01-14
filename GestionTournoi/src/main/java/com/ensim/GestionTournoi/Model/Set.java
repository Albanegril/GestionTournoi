package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;

public class Set extends Resultat {
	private ArrayList tabResult1 = new ArrayList();
	private ArrayList tabResult2 = new ArrayList();

	///Constructeurs
	public Set() {	}
	
	public Set(ArrayList tabResult1, ArrayList tabResult2, Equipe vainqueur) {
		super(vainqueur);
		this.tabResult1 = tabResult1;
		this.tabResult2 = tabResult2;
	}

	///Getters & Setters 
	public ArrayList getTabResult1() {
		return tabResult1;
	}

	public void setTabResult1(ArrayList tabResult1) {
		this.tabResult1 = tabResult1;
	}

	public ArrayList getTabResult2() {
		return tabResult2;
	}

	public void setTabResult2(ArrayList tabResult2) {
		this.tabResult2 = tabResult2;
	}
	
}
