package com.ensim.GestionTournoi.Model;

import org.json.JSONObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public abstract class Tournoi {
	

    private Long id_tournoi;
	protected Random rand = new Random();
	private Calendar calendar = Calendar.getInstance();
	private boolean isPublic;
	private Equipe vainqueur;
	private int id;
	private ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	private ArrayList<Match> matchs;
	private ArrayList<Equipe> participants = new ArrayList<Equipe>();
	private String nomTournoi = "";
	private String activite = "";
	protected int matchID = 1;
	protected int nbMatchJour;
	private HashMap<Integer, Integer> adressesJouees = new HashMap<Integer, Integer>();

	private String json = "";

	public String getJson()
	{
		String result ="{\n\n" +
				"  \"teams\": [\n\n";

		for(Match m:matchs)
		{
			result+= "[\""+m.getEquipe(0).getNom()+"\",\""+m.getEquipe(1).getNom()+"\"]\n\n";
		}
		result+="],\n\n" +
				"  \"results\": [\r\n" +
				"      [";

		int nbParticipant = this.participants.size();
		int power = 0;
		while(nbParticipant>0)
		{
			nbParticipant/=2;
			power++;
		}
		int z =0;
		for(int i = 0;i<power;i++)
		{
			result+="[";
			for(int y = 0;y<participants.size();y++)
			{
				if(vainqueur==null)
				{
					result +="[null,null],";
				}
				else
				{
					result += "["+((ResultatDefault)matchs.get(z).getResultat()).getScore(0)
						+","+((ResultatDefault)matchs.get(z).getResultat()).getScore(1)+"],";
				}
				z++;
			}
			result+="],\n\n";
		}
		result+="]\n\n" +
				"  ]\n\n" +
				"};";
		return result;
	}

	public Tournoi() {}
	
	public Tournoi(int id, String nomTournoi, String activite, Date date, ArrayList<Equipe> participants, ArrayList<Adresse> adresses, int nbMatchJour, boolean isPublic)
	{
		this.nomTournoi = nomTournoi;
		this.activite = activite;
		this.isPublic = isPublic;
		this.id = id;
		this.adresses = adresses;
		this.setDateDebut(date);
		this.nbMatchJour = nbMatchJour;
		
		this.matchs = this.initMatchs(participants);
	}

	public ArrayList<Equipe> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Equipe> participants) {
		this.participants = participants;
	}

	//XXX Methodes
	protected abstract ArrayList<Match> initMatchs(ArrayList<Equipe> participant);
	
	protected abstract void gagneMatch(Equipe participant);

	protected abstract void perdMatch(Equipe participant);	

	protected abstract void nulMatch(Equipe participant);
	
	protected abstract int nbMatch();
	
	protected int genereMatchId()
	{
		return Integer.parseInt(Integer.toString(this.id) + Integer.toString(this.matchID));
	}
	
	private int maxAddrUse()
	{
		float max = (float)this.nbMatch() / (float)this.adresses.size();
		int maxAddrUse = this.nbMatch() / this.adresses.size();
		
		return maxAddrUse + (max > maxAddrUse ? 1 : 0);
	}
	
	protected Adresse getMatchAdresse()
	{
		 Adresse addr = this.adresses.get(rand.nextInt(this.adresses.size() - 1));
		
		if(!this.adressesJouees.containsKey(addr.getId()) || this.adressesJouees.get(addr.getId()) < this.maxAddrUse())
		{
			if(!this.adressesJouees.containsKey(addr.getId()))
			{
				this.adressesJouees.put(addr.getId(), 0);
			}
			
			this.adressesJouees.replace(addr.getId(), this.adressesJouees.get(addr.getId()) + 1);
			
			return addr;
		}
		
		return this.getMatchAdresse();
	}

	//XXX Getters & Setters
	public String getNomTournoi()
	{
		return nomTournoi;
	}

	public void setNom(String nomTournoi)
	{
		this.nomTournoi = nomTournoi;
	}

	public String getActivite()
	{
		return activite;
	}

	public void setActivite(String activite)
	{
		this.activite = activite;
	}

	public boolean isPublic()
	{
		return isPublic;
	}

	public void setPublic(boolean isPublic)
	{
		this.isPublic = isPublic;
	}

	public ArrayList<Match> getMatchs()
	{
		return matchs;
	}

	public void setMatchs(ArrayList<Match> matchs)
	{
		this.matchs = matchs;
	}

	public Equipe getVainqueur()
	{
		return vainqueur;
	}

	public void setVainqueur(Equipe vainqueur)
	{
		this.vainqueur = vainqueur;
	}

	public int getNbParticipant()
	{
		return this.participants.size();
	}

	public int getId()
	{
		return id;
	}

	public ArrayList<Adresse> getAdresses()
	{
		return adresses;
	}

	public void setAdresses(ArrayList<Adresse> adresses)
	{
		this.adresses = adresses;
	}

	public Date getDateDebut()
	{
		return this.calendar.getTime();
	}

	public void setDateDebut(Date date)
	{
		this.calendar.setTime(date);
	}

	public HashMap<Integer, Integer> getAdressesJouees()
	{
		return adressesJouees;
	}

	public void setAdressesJouees(HashMap<Integer, Integer> adressesJouees)
	{
		this.adressesJouees = adressesJouees;
	}

	public Calendar getCalendar()
	{
		return calendar;
	}

	public void setCalendar(Calendar calendar)
	{
		this.calendar = calendar;
	}
}
