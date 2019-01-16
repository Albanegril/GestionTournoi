package com.ensim.GestionTournoi.Model;

public abstract class Resultat
{
	private Equipe vainqueur;

	/// Constructeurs
	public Resultat()
	{
	}

	public Resultat(Equipe vainqueur)
	{
		super();
		this.vainqueur = vainqueur;
	}

	/// Getters & Setters
	public Equipe getVainqueur()
	{
		return vainqueur;
	}

	public void setVainqueur(Equipe vainqueur)
	{
		this.vainqueur = vainqueur;
	}
}
