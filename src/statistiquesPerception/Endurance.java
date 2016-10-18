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
public class Endurance extends StatistiqueDE implements StatistiqueInterface {

	public Endurance(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Endurance(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}

	public Endurance(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Endurance(Endurance classe, Endurance race) {
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
