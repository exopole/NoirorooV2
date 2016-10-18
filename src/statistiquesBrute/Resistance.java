/**
 * 
 */
package statistiquesBrute;

import java.util.Vector;

import statistiques.StatistiqueDE;
import statistiques.StatistiqueInterface;

/**
 * @author exopole
 *
 */
public class Resistance extends StatistiqueDE implements StatistiqueInterface {

	
	
	public Resistance(Vector<String> value) {
		super(value);
	}

	public Resistance( String value, String de) {
		super(value, de);
	}

	public Resistance(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Resistance(Resistance classe, Resistance race) {
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
