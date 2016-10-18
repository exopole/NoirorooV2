/**
 * 
 */
package statistiquesPerception;

import java.util.Vector;

import statistiques.StatistiqueDE;
import statistiques.StatistiqueInterface;

/**
 * @author exopole
 *
 */
public class Habilite extends StatistiqueDE implements StatistiqueInterface {

	public Habilite(String value, String de) {
		super(value, de);
	}
	
	public Habilite(Vector<String> value) {
		super(value);
	}
	
	public Habilite(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Habilite(Habilite classe, Habilite race) {
		super(classe,race);
	}

	/* (non-Javadoc)
	 * @see statistiques.StatistiqueInterface#description()
	 */
	@Override
	public String description() {
		return null;
	}

}
