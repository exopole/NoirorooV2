package statistiques;

import java.util.Vector;

import parsing.ParsingString;

import statistiquesPerception.*;

public class StatistiquePerception {
	/**
	 * Statistique de precision
	 */
	private Precision precision;
	/**
	 * Statistique de chance
	 */
	private Chance chance;
	/**
	 * Statistique d'esquive
	 */
	private Esquive esquive;
	/**
	 * Statistique d'habilite
	 */
	private Habilite habilite;
	/**
	 * Statistique d'intelligence
	 */
	private Intelligence intelligence;
	/**
	 * Statistique d'endurance
	 */
	private Endurance endurance;
	/**
	 * Statistique de furtivite
	 */
	private Furtivite furtivite;
	/**
	 * Staistique de charisme
	 */
	private Charisme charisme;
	
	private boolean compute = false;
	
	public StatistiquePerception(String content) 
	{
		Vector< Vector< String>> stat = ParsingString.split2time(content, ";", ",");
		precision = new Precision(stat.get(0));			
		chance = new Chance(stat.get(1));
		esquive = new Esquive(stat.get(2));
		habilite = new Habilite(stat.get(3));
		intelligence = new Intelligence(stat.get(4));
		endurance = new Endurance(stat.get(5));
		furtivite = new Furtivite(stat.get(6));
		charisme = new Charisme(stat.get(7));
		
	}
	
	
	public StatistiquePerception(Integer precision, Integer chance, Integer esquive, Integer habilite, 
			Integer intelligence, Integer endurance, Integer furtivite, Integer charisme) 
	{
		this.precision = new Precision(precision);			
		this.chance = new Chance(chance);
		this.esquive = new Esquive(esquive);
		this.habilite = new Habilite(habilite);
		this.intelligence = new Intelligence(intelligence);
		this.endurance = new Endurance(endurance);
		this.furtivite = new Furtivite(furtivite);
		this.charisme = new Charisme(charisme);
		
	}
	public StatistiquePerception(StatistiquePerception classe, StatistiquePerception race) 
	{
		
		this.precision = new Precision(classe.getPrecision(), race.getPrecision());			
		this.chance = new Chance(classe.getChance(), race.getChance());
		this.esquive = new Esquive(classe.getEsquive(), race.getEsquive());
		this.habilite = new Habilite(classe.getHabilite(), race.getHabilite());
		this.intelligence = new Intelligence(classe.getIntelligence(), race.getIntelligence());
		this.endurance = new Endurance(classe.getEndurance(), race.getEndurance());
		this.furtivite = new Furtivite(classe.getFurtivite(), race.getFurtivite());
		this.charisme = new Charisme(classe.getCharisme(), race.getCharisme());
	}

	/**
	 * @return the precision
	 */
	public Precision getPrecision() {
		return precision;
	}

	/**
	 * @return the chance
	 */
	public Chance getChance() {
		return chance;
	}

	/**
	 * @return the esquive
	 */
	public Esquive getEsquive() {
		return esquive;
	}

	/**
	 * @return the habilite
	 */
	public Habilite getHabilite() {
		return habilite;
	}

	/**
	 * @return the intelligence
	 */
	public Intelligence getIntelligence() {
		return intelligence;
	}

	/**
	 * @return the endurance
	 */
	public Endurance getEndurance() {
		return endurance;
	}

	/**
	 * @return the furtivite
	 */
	public Furtivite getFurtivite() {
		return furtivite;
	}

	/**
	 * @return the charisme
	 */
	public Charisme getCharisme() {
		return charisme;
	}
	
	public void compute() 
	{
		if (! compute)
		{
			chance.compute();
			charisme.compute();
			endurance.compute();
			esquive.compute();
			furtivite.compute();
			habilite.compute();
			intelligence.compute();
			precision.compute();
			compute = true;
		}
		
	}

}
