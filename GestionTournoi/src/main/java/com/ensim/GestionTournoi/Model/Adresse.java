package com.ensim.GestionTournoi.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Adresse implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ville;
	private String rue;

	/// Constructeurs
	public Adresse()
	{
	}

	public Adresse(int id, String ville, String rue)
	{
		this.ville = ville;
		this.rue = rue;
		this.setId(id);
	}

	//XXX Méthodes
	
	public String toString()
	{
		//return "Adresse {id=" + id + ", Adresse : " + rue + ", " + ville + "}";
		return rue + ", " + ville;
	}

	//XXX Getters & Setters
	public String getVille()
	{
		return ville;
	}

	public void setVille(String ville)
	{
		this.ville = ville;
	}

	public String getRue()
	{
		return rue;
	}

	public void setRue(String rue)
	{
		this.rue = rue;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
