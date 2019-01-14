package com.ensim.GestionTournoi.Model;

import java.util.Date;

public class Match
{
	private Date date;
	private Adresse lieu;
	private Equipe[] equipe;
	private Resultat resultat;
	private int id;
	
	/// Constructeurs
	public Match() {}
	
	public Match(int id, Equipe[] equipe, Date date, Adresse lieu)
	{
		super();
		this.date = date;
		this.lieu = lieu;
		this.id = id;
		this.equipe = equipe;
	}

	/// Getters & Setters
	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Adresse getLieu()
	{
		return lieu;
	}

	public void setLieu(Adresse lieu)
	{
		this.lieu = lieu;
	}

	public Equipe getEquipe(int index)
	{
		return equipe[index];
	}

	public void setEquipe(Equipe equipe, int index)
	{
		this.equipe[index] = equipe;
	}

	public Resultat getResultat()
	{
		return resultat;
	}

	public void setResultat(Resultat resultat)
	{
		this.resultat = resultat;
	}

	public int getId()
	{
		return id;
	}
}
