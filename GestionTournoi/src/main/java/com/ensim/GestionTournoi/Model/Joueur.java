package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;

public class Joueur
{
	private String nom;
	private final int id;
	private int nbVictoire;
	private int nbDefaite;
	private ArrayList<String> palmares = new ArrayList<String>();
	
	public Joueur(int id, String nom)
	{
		this.id = id;
		this.setNom(nom);
	}
	
	//XXX Méthodes
	
	public String toString()
	{
		return "Joueur {id=" + id + ", nom=" + nom + "}";
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
	}
	
	public void addDefaite()
	{
		this.nbDefaite++;
	}

	public ArrayList<String> getPalmares()
	{
		return palmares;
	}

	public void setPalmares(ArrayList<String> palmares)
	{
		this.palmares = palmares;
	}
}
