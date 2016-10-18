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
public class Dexterite extends StatistiqueDE implements StatistiqueInterface {

	
	
	public Dexterite(String value, String de) {
		super(value, de);
	}
	
	public Dexterite(Vector<String> value) {
		super(value);
	}
	
	public Dexterite(Integer value) {
		super(value);
	}
	
	public Dexterite(Dexterite classe, Dexterite race) {
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
