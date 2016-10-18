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
public class Charisme extends StatistiqueDE implements StatistiqueInterface {

	
	public Charisme(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}

	public Charisme(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Charisme(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Charisme(Charisme classe, Charisme race) {
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
