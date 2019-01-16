package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;

public class Equipe
{
	private String nom;
	private final int id;
	private int nbVictoire;
	private int nbDefaite;
	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

	public Equipe(int id, String nom, ArrayList<Joueur> joueurs)
	{
		this.nom = nom;
		this.id = id;
		this.setJoueurs(joueurs);
	}
	
	//XXX Méthodes
	
	public String toString()
	{
		return "Equipe {id=" + id + ", nom=" + nom + "}";
	}

	//XXX Getters & Setters
	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public int getId()
	{
		return id;
	}

	public int getNbVictoire()
	{
		return nbVictoire;
	}

	public void setNbVictoire(int nbVictoire)
	{
		this.nbVictoire = nbVictoire;
	}

	public int getNbDefaite()
	{
		return nbDefaite;
	}

	public void setNbDefaite(int nbDefaite)
	{
		this.nbDefaite = nbDefaite;
	}
	
	public void addVictoire()
	{
		this.nbVictoire++;
		
		for(Joueur j : this.joueurs)
		{
			j.addVictoire();
		}
	}
	
	public void addDefaite()
	{
		this.nbDefaite++;
		
		for(Joueur j : this.joueurs)
		{
			j.addDefaite();
		}
	}

	public ArrayList<Joueur> getJoueurs()
	{
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs)
	{
		this.joueurs = joueurs;
	}
}
