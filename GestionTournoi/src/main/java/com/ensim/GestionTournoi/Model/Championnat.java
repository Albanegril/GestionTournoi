package com.ensim.GestionTournoi.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Championnat extends Tournoi implements Serializable
{
	@Id
	private int idChampionat;
	private int ptsVictoire;
	private int ptsMatchNul;
	private int ptsDefaite;
	private boolean matchRetour;

	private int[] nbPtsParticipant;

	public Championnat()
	{
	}

	public Championnat(int id, String nom, String activite, Date date, ArrayList<Equipe> participants, ArrayList<Adresse> adresses, int nbMatchJour, boolean isPublic, boolean matchRetour)
	{
		super(id, nom, activite, date, participants, adresses, nbMatchJour, isPublic);
		this.matchRetour = matchRetour;
		this.nbPtsParticipant = new int[this.getNbParticipant()];
		this.matchs = this.initMatchs(participants);
	}

	public ArrayList<Match> initMatchs(List<Equipe> participants)
	{
		ArrayList<Match> matchs = new ArrayList<Match>();
		int nbMatch = 0;

		for (int i = 0; i < (this.matchRetour ? 2 : 1); i++)
		{
			for (int j=0;j<participants.size();j++)
			{
				for (int k=j+1;k<participants.size();k++)
				{
					Equipe[] tab = { participants.get(j), participants.get(k) };

					Calendar cal = Calendar.getInstance();
					cal.setTime(this.getDateDebut());
					cal.add(Calendar.DAY_OF_YEAR, nbMatch++ / this.nbMatchJour);

					matchs.add(new Match(this.genereMatchId(), tab, cal.getTime(), this.getMatchAdresse(this.nbMatch())));
				}
			}
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
	public void gagneMatch(Equipe equipe)
	{
		this.nbPtsParticipant[equipe.getId()] += this.ptsVictoire;
		equipe.addVictoire();
	}

	@Override
	public void perdMatch(Equipe equipe)
	{
		this.nbPtsParticipant[equipe.getId()] += this.ptsDefaite;
		equipe.addDefaite();
	}

	@Override
	public void nulMatch(Equipe equipe)
	{
		this.nbPtsParticipant[equipe.getId()] += this.ptsMatchNul;
	}

	@Override
	public int nbMatch()
	{
		int nbEquipe = 0;

		for (int i = 0; i < this.getNbParticipant(); i++)
		{
			nbEquipe += i;
		}

		return nbEquipe * (this.matchRetour ? 2 : 1);
	}

	public int getEquipePts(Equipe equipe)
	{
		return this.nbPtsParticipant[equipe.getId()];
	}
	
	public Equipe vainqueur()
	{
		int index = 0;
		int maxPts = 0;
		
		for(int i=0;i<this.getParticipants().size();i++)
		{
			if(this.nbPtsParticipant[this.getParticipants().get(i).getId()] > maxPts)
			{
				maxPts = this.nbPtsParticipant[this.getParticipants().get(i).getId()];
				index = i;
			}
		}
		
		return this.getParticipants().get(index);
	}
	
	/// Getters & Setters
	public int getIdChampionat()
	{
		return idChampionat;
	}

	public void setIdChampionat(int idChampionat)
	{
		this.idChampionat = idChampionat;
	}

	public int[] getNbPtsParticipant()
	{
		return nbPtsParticipant;
	}

	public void setNbPtsParticipant(int[] nbPtsParticipant)
	{
		this.nbPtsParticipant = nbPtsParticipant;
	}

	public int getPtsVictoire()
	{
		return ptsVictoire;
	}

	public void setPtsVictoire(int ptsVictoire)
	{
		this.ptsVictoire = ptsVictoire;
	}

	public int getPtsMatchNul()
	{
		return ptsMatchNul;
	}

	public void setPtsMatchNul(int ptsMatchNul)
	{
		this.ptsMatchNul = ptsMatchNul;
	}

	public int getPtsDefaite()
	{
		return ptsDefaite;
	}

	public void setPtsDefaite(int ptsDefaite)
	{
		this.ptsDefaite = ptsDefaite;
	}

	public boolean isMatchRetour()
	{
		return matchRetour;
	}

	public void setMatchRetour(boolean matchRetour)
	{
		this.matchRetour = matchRetour;
	}
}
