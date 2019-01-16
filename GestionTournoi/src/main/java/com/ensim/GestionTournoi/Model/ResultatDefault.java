package com.ensim.GestionTournoi.Model;

public class ResultatDefault extends Resultat
{
	private int[] score;

	/// Constructeurs
	public ResultatDefault()
	{
	}

	public ResultatDefault(int[] score, Equipe vainqueur)
	{
		super(vainqueur);
		this.score = score;
	}


	/// Getters & Setters
	public int getScore(int index)
	{
		return score[index];
	}

	public void setscore1(int score, int index)
	{
		this.score[index] = score;
	}
}
