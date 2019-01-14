package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;

public class Coupe extends Tournoi {

	@Override
	protected ArrayList<Match> initMatchs(ArrayList<Equipe> participant) {
		ArrayList<Match> matchs = new ArrayList<Match>();
		ArrayList<Equipe> gauche = new ArrayList<Equipe>();
		ArrayList<Equipe> droite = new ArrayList<Equipe>();
		boolean cote=true;
		for (Equipe equipe : participant) {
			if(cote) {
				gauche.add(equipe);
				cote=false;
			}else {
				droite.add(equipe);
				cote=true;
			}
		}
		for(int i=0; i<)
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void gagneMatch(Equipe participant) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void perdMatch(Equipe participant) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void nulMatch(Equipe participant) {
		// TODO Auto-generated method stub

	}

	@Override
	protected int nbMatch() {
		// TODO Auto-generated method stub
		return 0;
	}

}
