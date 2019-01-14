package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Championnat extends Tournoi
{
	private int ptsVictoire;
	private int ptsMatchNul;
	private int ptsDefaite;
	private boolean matchRetour;
	
	private int[] nbPtsParticipant;
	
	public Championnat()
	{
		this.nbPtsParticipant = new int[this.getNbParticipant()];
	}
	
	public Championnat(int id, String nom, String activite, Date date, ArrayList<Equipe> participants, ArrayList<Adresse> adresses, int nbMatchJour, boolean isPublic, boolean matchRetour)
	{
		super(id, nom, activite, date, participants, adresses, nbMatchJour, isPublic);
		this.nbPtsParticipant = new int[this.getNbParticipant()];
	}
	
	@Override
	public ArrayList<Match> initMatchs(ArrayList<Equipe> participants)
	{
		ArrayList<Match> matchs = new ArrayList<Match>();
		int nbMatch = 0;
		
		for(int i=0;i<(this.matchRetour ? 1:2);i++)
		{
			for(Equipe p : participants)
			{
				for(Equipe q : participants)
				{
					if(!p.equals(q))
					{
						nbMatch++;
						Equipe[] tab = {p, q};
						
						Calendar cal = Calendar.getInstance();
						cal.setTime(this.getDateDebut());
						cal.add(Calendar.DAY_OF_YEAR, nbMatch / this.nbMatchJour);
						
						matchs.add(new Match(this.genereMatchId(), tab, cal.getTime(), this.getMatchAdresse()));
					}
				}
			}
		}
		
		return matchs;
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
	protected int nbMatch()
	{
		int nbEquipe = 0;
		
		for(int i=0;i<this.getNbParticipant();i++)
		{
			nbEquipe += i;
		}
		
		return nbEquipe * (this.matchRetour ? 2 : 1);
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
	
	public int getEquipePts(Equipe equipe)
	{
		return this.nbPtsParticipant[equipe.getId()];
	}
}
