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
public class Precision extends StatistiqueDE implements StatistiqueInterface {
	
	public Precision(Vector<String> value) {
		super(value);
	}

	public Precision(String value, String de) {
		super(value, de);
	}
	
	public Precision(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Precision(Precision classe, Precision race) {
		super(classe,race);
	}
	
	/* 
	 * @see statistiques.StatistiqueInterface#description()
	 */
	@Override
	public String description() {
		return null;
	}

}
