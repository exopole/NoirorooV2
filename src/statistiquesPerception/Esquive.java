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
public class Esquive extends StatistiqueDE implements StatistiqueInterface {

	
	public Esquive(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}

	public Esquive(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Esquive(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Esquive(Esquive classe, Esquive race) {
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
