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

		return matchs;
	}
	
	public int maxAddrUse()
	{
		float max = (float) nbMatch() / (float) this.getAdresses().size();
		int maxAddrUse = nbMatch() / this.getAdresses().size();

		return maxAddrUse + (max > maxAddrUse ? 1 : 0);
	}

	protected Adresse getMatchAdresse(int nbMatch)
	{
		if(this.adressesDispo.size() == 0)
		{
			return null;
		}
		
		int index = rand.nextInt(this.adressesDispo.size());
		
		Adresse addr = this.adressesDispo.get(index);

		if (!this.adressesJouees.containsKey(addr.getId()) || this.getAdressesJouees().get(addr.getId()) < this.maxAddrUse())
		{
			if (!this.adressesJouees.containsKey(addr.getId()))
			{
				this.adressesJouees.put(addr.getId(), 0);
			}

			this.adressesJouees.replace(addr.getId(), this.adressesJouees.get(addr.getId()) + 1);

			return addr;
		}
		
		else
		{
			this.adressesDispo.remove(index);
		}

		return this.getMatchAdresse(nbMatch);
	}

	@Override
	protected void gagneMatch(Equipe participant)
	{
		participant.addVictoire();
	}

	@Override
	protected void perdMatch(Equipe participant)
	{
		enLice.remove(participant);
		elimines.add(participant);
		participant.addDefaite();
	}

	@Override
	protected void nulMatch(Equipe participant)
	{
	}

	@Override
	protected int nbMatch()
	{
		return 0;
	}

	protected void runCoupe()
	{
		enLice = getParticipants();
		while (enLice.size() > 1)
		{
			initMatchs(enLice);
			while (enLice.size() > enLice.size() / 2 + 1)
			{

			}
		}
	}

}
