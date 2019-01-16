package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

public class Coupe extends Tournoi {
	
	//XXX Attributs

	private ArrayList<Equipe> enLice;
	private ArrayList<Equipe> elimines;


	//XXX Constructeurs
	
	public Coupe() {	}

	public Coupe(int id, String nom, String activite, Date date, ArrayList<Equipe> participants, ArrayList<Adresse> adresses, int nbMatchJour, boolean isPublic, boolean matchRetour)
	{
		super(id, nom, activite, date, participants, adresses, nbMatchJour, isPublic);
	}
	
	//XXX Méthodes
	
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
		participant.addVictoire();

	}

	@Override
	protected void perdMatch(Equipe participant) {
		// TODO Auto-generated method stub
		enLice.remove(participant);
		elimines.add(participant);
		participant.addDefaite();
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
	
	protected void runCoupe() {
		enLice= getParticipants();
		while(enLice.size()>1) {
			initMatchs(enLice);
			while(enLice.size()>enLice.size()/2+1) {
				
			}
		}
	}
}
