package statistiques;

import java.util.Vector;

import parsing.ParsingString;
import statistiquesBrute.Deplacement;
import statistiquesBrute.Dexterite;
import statistiquesBrute.Esprit;
import statistiquesBrute.Force;
import statistiquesBrute.Rapidite;
import statistiquesBrute.Resistance;
import statistiquesBrute.Vie;

public class StatistiqueBruteClasse {
	protected Vie  vie;
	protected Force  force;
	protected Rapidite  rapidite;
	protected Resistance  resistance;
	protected Esprit  esprit;
	protected Dexterite  dexterite;
	protected Boolean compute = false;
	protected Vector< Vector< String>> stat;
	
	
	public StatistiqueBruteClasse() {
		// TODO Auto-generated constructor stub
	}
	
	public StatistiqueBruteClasse(String content) 
	{
		stat = ParsingString.split2time(content, ";", ",");
		vie = new Vie(stat.get(0));
		force = new Force(stat.get(1));
		rapidite = new Rapidite(stat.get(2));
		dexterite = new Dexterite(stat.get(3));
		resistance = new Resistance(stat.get(4));
		esprit = new Esprit(stat.get(5));
	}

	/**
	 * @return the vie
	 */
	public Vie getVie() {
		return vie;
	}

	/**
	 * @return the force
	 */
	public Force getForce() {
		return force;
	}

	/**
	 * @return the rapidite
	 */
	public Rapidite getRapidite() {
		return rapidite;
	}

	/**
	 * @return the resistance
	 */
	public Resistance getResistance() {
		return resistance;
	}

	/**
	 * @return the esprit
	 */
	public Esprit getEsprit() {
		return esprit;
	}


	/**
	 * @return the dexterite
	 */
	public Dexterite getDexterite() {
		return dexterite;
	}
	
	public void compute()
	{
		if (compute == false)
		{
			dexterite.compute();
			esprit.compute();
			force.compute();
			rapidite.compute();
			resistance.compute();
			vie.compute();
			compute = true;			
		}
	}
}
