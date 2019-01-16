package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class Tournoi
{
	/**
	 * Attributs ci-dessous à sérialiser
	 */
	private boolean isPublic;
	private Equipe vainqueur;
	private int id;
	private List<Adresse> adresses = new ArrayList<Adresse>();
	protected List<Match> matchs;
	private List<Equipe> participants = new ArrayList<Equipe>();
	private String nomTournoi;
	private String activite;
	protected int nbMatchJour;
	
	/**
	 * Attributs ci-dessous à NE PAS sérialiser !!!
	 */
	protected Random rand = new Random();
	private Calendar calendar = Calendar.getInstance();
	protected int matchID = 1;
	protected HashMap<Integer, Integer> adressesJouees = new HashMap<Integer, Integer>();
	protected ArrayList<Adresse> adressesDispo = new ArrayList<Adresse>();

	public String getJson()
	{
		String result ="{\n\t\"matchs\": [\n";

		for(int i=0;i<matchs.size();i++)
		{
			result+= "\t\t[\""+matchs.get(i).getEquipe(0).getNom()+"\",\""+matchs.get(i).getEquipe(1).getNom()+"\"]" + (i==this.matchs.size()-1 ? "" : ", ") + "\n";
		}
		result+="\t],\n\n\t\"results\": [\r\n\t\t[\n";

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
			result+="\t\t\t[\n";
			for(int y = 0;y<participants.size();y++)
			{
				//if(vainqueur==null)
				if(matchs.get(power).getResultat() == null)
				{
					result +="\t\t\t\t[null,null]" + (y==participants.size()-1 ? "" : ",") + "\n";
				}
				else
				{
					result += "\t\t\t\t["+((ResultatDefault)matchs.get(z).getResultat()).getScore(0)
						+","+((ResultatDefault)matchs.get(z).getResultat()).getScore(1)+"]" + (y==participants.size()-1 ? "" : ",") + "\n";
				}
				z++;
			}
			result+="\t\t\t]" + (i==power-1 ? "" : ",") + "\n";
		}
		result+="\t\t]\n\t]\n}";
		return result;
	}

	public Tournoi() {}
	
	@SuppressWarnings("unchecked")
	public Tournoi(int id, String nomTournoi, String activite, Date date, List<Equipe> participants, List<Adresse> adresses, int nbMatchJour, boolean isPublic)
	{
		this.nomTournoi = nomTournoi;
		this.activite = activite;
		this.isPublic = isPublic;
		this.id = id;
		this.participants = participants;
		this.adresses = adresses;
		this.setDateDebut(date);
		this.nbMatchJour = nbMatchJour;

		this.adressesDispo = (ArrayList<Adresse>) ((ArrayList<Adresse>) this.adresses).clone();
		//this.matchs = this.initMatchs(participants);
	}

	//XXX Methodes
	protected abstract List<Match> initMatchs(List<Equipe> participant);

	protected abstract void gagneMatch(Equipe participant);

	protected abstract void perdMatch(Equipe participant);

	protected abstract void nulMatch(Equipe participant);

	protected abstract int nbMatch();

	protected int genereMatchId()
	{
		return Integer.parseInt(Integer.toString(this.id) + Integer.toString(this.matchID++));
	}
/*
	public int maxAddrUse()
	{
		float max = (float) nbMatch() / (float) this.adresses.size();
		int maxAddrUse = nbMatch() / this.adresses.size();

		return maxAddrUse + (max > maxAddrUse ? 1 : 0);
	}

	protected Adresse getMatchAdresse(int nbMatch)
	{
		if(this.adressesDispo.size() == 0)
		{
			return null;
		}
		
		//System.out.println(this.maxAddrUse(nbMatch));
		
		int index = rand.nextInt(this.adressesDispo.size());
		
		Adresse addr = this.adressesDispo.get(index);

		if (!this.adressesJouees.containsKey(addr.getId()) || this.adressesJouees.get(addr.getId()) < this.maxAddrUse())
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
*/
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

	public List<Match> getMatchs()
	{
		return matchs;
	}

	public void setMatchs(List<Match> matchs)
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

	public List<Adresse> getAdresses()
	{
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses)
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

	public List<Equipe> getParticipants()
	{
		return participants;
	}

	public void setParticipants(List<Equipe> participants)
	{
		this.participants = participants;
	}
}
