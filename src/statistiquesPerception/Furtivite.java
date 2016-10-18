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
public class Furtivite extends StatistiqueDE implements StatistiqueInterface {

	public Furtivite(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	
	public Furtivite(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}
	
	public Furtivite(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Furtivite(Furtivite classe, Furtivite race) {
		super(classe,race);
	}

	/* (non-Javadoc)
	 * @see statistiques.StatistiqueInterface#description()
	 */
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}

}
