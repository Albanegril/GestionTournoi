package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;
import java.util.Calendar;

public class Coupe extends Tournoi {

	private ArrayList<Equipe> enLice;
	@Override
	protected ArrayList<Match> initMatchs(ArrayList<Equipe> participants) {
		int nbMatch = 0;
		ArrayList<Match> matchs = new ArrayList<Match>();
		for(int i=0; i<participants.size();i=i+2) {
			nbMatch++;
			Equipe[] tab = {participants.get(i), participants.get(i+1)};
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.getDateDebut());
			cal.add(Calendar.DAY_OF_YEAR, nbMatch / this.nbMatchJour);
			
			matchs.add(new Match(this.genereMatchId(), tab, cal.getTime(), this.getMatchAdresse()));
		}
		
		// TODO Auto-generated method stub
		return matchs;
	}

	@Override
	protected void gagneMatch(Equipe participant) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void perdMatch(Equipe participant) {
		// TODO Auto-generated method stub
		enLice.remove(participant);
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
