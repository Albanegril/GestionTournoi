package com.ensim.GestionTournoi.Model;

import java.util.ArrayList;

public class ResultatSet extends Resultat
{
	private ArrayList<Integer> tabResult1 = new ArrayList<Integer>();
	private ArrayList<Integer> tabResult2 = new ArrayList<Integer>();

	/// Constructeurs
	public ResultatSet()
	{
	}

	public ResultatSet(ArrayList<Integer> tabResult1, ArrayList<Integer> tabResult2, Equipe vainqueur)
	{
		super(vainqueur);
		this.tabResult1 = tabResult1;
		this.tabResult2 = tabResult2;
	}

	/// Getters & Setters
	public ArrayList<Integer> getTabResult1()
	{
		return tabResult1;
	}

	public void setTabResult1(ArrayList<Integer> tabResult1)
	{
		this.tabResult1 = tabResult1;
	}

	public ArrayList<Integer> getTabResult2()
	{
		return tabResult2;
	}

	public void setTabResult2(ArrayList<Integer> tabResult2)
	{
		this.tabResult2 = tabResult2;
	}
}
