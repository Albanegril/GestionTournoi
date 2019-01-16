package com.ensim.GestionTournoi.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Transient;


import org.json.JSONObject;

@Entity
public class Coupe extends Tournoi implements Serializable {
	
	//XXX Attributs
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long idCoupe;

	//XXX Constructors


	@Transient
	private List<Equipe> enLice;
	@Transient
	private List<Equipe> elimines;

	//XXX Constructors

	public Coupe() {	}

	
	//XXX Gettres & Settres
	public Long getIdCoupe() {
		return idCoupe;
	}

	public void setIdCoupe(Long idCoupe) {
		this.idCoupe = idCoupe;
	}

	public void setEnLice(List<Equipe> enLice) {
		this.enLice = enLice;
	}

	public void setElimines(List<Equipe> elimines) {
		this.elimines = elimines;
	}
	
	//XXX Méthodes
	
	@Override
	protected List<Match> initMatchs(List<Equipe> enLice2) {
		int nbMatch = 0;
		List<Match> matchs = new ArrayList<Match>();
		for(int i=0; i<enLice2.size();i=i+2) {
			nbMatch++;
			Equipe[] tab = {enLice2.get(i), enLice2.get(i+1)};
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(this.getDateDebut());
			cal.add(Calendar.DAY_OF_YEAR, nbMatch / this.nbMatchJour);
			


		//	matchs.add(new Match(this.genereMatchId(), tab, cal.getTime(), this.getMatchAdresse(0)));

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
