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
public class Chance extends StatistiqueDE implements StatistiqueInterface {

	public Chance(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Chance(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}
	
	public Chance(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	
	public Chance(Chance classe, Chance race) {
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
