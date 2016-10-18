/**
 * 
 */
package statistiques;

import statistiquesBrute.Dexterite;
import statistiquesBrute.Esprit;
import statistiquesBrute.Force;
import statistiquesBrute.Rapidite;
import statistiquesBrute.Resistance;
import statistiquesBrute.Vie;

/**
 * @author exopole
 *
 */
public class StatistiqueBrutePersonnage extends StatistiqueBruteRace 
{

	public StatistiqueBrutePersonnage(StatistiqueBruteClasse classe, StatistiqueBruteRace race) {
		super();
		vie = new Vie(classe.getVie(), race.getVie());
		force = new Force(classe.getForce(), race.getForce());
		rapidite = new Rapidite(classe.getRapidite(), race.getRapidite());
		dexterite = new Dexterite(classe.getDexterite(), race.getDexterite());
		resistance = new Resistance(classe.getResistance(), race.getResistance());
		esprit = new Esprit(classe.getEsprit(), race.getEsprit());
		deplacement = race.getDeplacement();
		// TODO Auto-generated constructor stub
	}

}
