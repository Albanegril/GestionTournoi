package com.ensim.GestionTournoi.Tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ensim.GestionTournoi.Model.Adresse;
import com.ensim.GestionTournoi.Model.Championnat;
import com.ensim.GestionTournoi.Model.Equipe;
import com.ensim.GestionTournoi.Model.Joueur;
import com.ensim.GestionTournoi.Model.Match;

public class ChampionnatTest
{
	private static ArrayList<Joueur> je1  = new ArrayList<Joueur>(), je2 = new ArrayList<Joueur>(), je3 = new ArrayList<Joueur>();
	private static ArrayList<Equipe> equipes = new ArrayList<Equipe>();
	private static ArrayList<Adresse> adresses = new ArrayList<Adresse>();
	private static Championnat chp;
	private static int idJoueur = 0, idEquipe = 0, idAdresse = 0;

	@BeforeClass
	public static void initTests()
	{
		Adresse a1 = new Adresse(idAdresse++, "Marseille", "102 Rue de la Boustifaille");
		Adresse a2 = new Adresse(idAdresse++, "Marseille", "13 Boulevard du Prado");
		Adresse a3 = new Adresse(idAdresse++, "La Ciotat", "99 Chemin de la Cagole");
		Adresse a4 = new Adresse(idAdresse++, "Ajaccio", "2 Rue de la Sieste");

		adresses.add(a1);
		adresses.add(a2);
		adresses.add(a3);
		adresses.add(a4);

		Joueur j1 = new Joueur(idJoueur++, "César");
		Joueur j2 = new Joueur(idJoueur++, "Louis-Ulysse Loco");
		Joueur j3 = new Joueur(idJoueur++, "Jean-Mi");
		Joueur j4 = new Joueur(idJoueur++, "Ange");
		Joueur j5 = new Joueur(idJoueur++, "Michel");
		Joueur j6 = new Joueur(idJoueur++, "Gégé Anvidcrevais");

		je1.add(j1);
		je1.add(j2);

		je2.add(j3);
		je2.add(j4);
		
		je3.add(j5);
		je3.add(j6);

		Equipe e1 = new Equipe(idEquipe++, "La bonne mère", je1);
		Equipe e2 = new Equipe(idEquipe++, "Fond dans la bouche pas dans la main", je2);
		Equipe e3 = new Equipe(idEquipe++, "Les gilets jaunes", je3);

		equipes.add(e1);
		equipes.add(e2);
		equipes.add(e3);
		
//		chp = new Championnat(1, "Une pétanque, un litre de jaune.", "Pétanque", new Date(), equipes, adresses, 2, false, true);
	}
	
	//@Test
	public void afficherMatchsChamionnatSimple()
	{
		chp = new Championnat(1, "Une pétanque, un litre de jaune.", "Pétanque", new Date(), equipes, adresses, 2, false, false);

		Assert.assertEquals(3, chp.nbMatch());
		Assert.assertEquals(3/4, chp.nbMatch()/chp.getAdresses().size());
		Assert.assertEquals(3.0/4, (float)chp.nbMatch()/chp.getAdresses().size(), 0);
		Assert.assertEquals(1, chp.maxAddrUse(), 0);
		
		for (Match m : chp.getMatchs())
		{
			System.out.println(m);
		}
		
		try
		{
			FileWriter fileWriter = new FileWriter("test.json");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write(chp.getJson());		
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void afficherMatchsChamionnatRetour()
	{
		chp = new Championnat(1, "Une pétanque, un litre de jaune.", "Pétanque", new Date(), equipes, adresses, 2, false, true);

		Assert.assertEquals(6, chp.nbMatch());
		Assert.assertEquals(6/4, chp.nbMatch()/chp.getAdresses().size());
		Assert.assertEquals(6.0/4, (float)chp.nbMatch()/chp.getAdresses().size(), 0);
		Assert.assertEquals(2, chp.maxAddrUse(), 0);
		
		for (Match m : chp.getMatchs())
		{
			System.out.println(m);
		}
		
		try
		{
			FileWriter fileWriter = new FileWriter("test.json");
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write(chp.getJson());		
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}	
}