package com.ensim.GestionTournoi.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ville;
	private String rue;
	private int no;

	/// Constructeurs
	public Adresse()
	{
	}

	public Adresse(String ville, String rue, int no)
	{
		this.ville = ville;
		this.rue = rue;
		this.setNo(no);
	}

	/// Getters & Setters
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

	public int getNo()
	{
		return no;
	}

	public void setNo(int no)
	{
		this.no = no;
	}

}
