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
public class Esprit extends StatistiqueDE implements StatistiqueInterface {

	public Esprit(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}
	
	public Esprit(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Esprit(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Esprit(Esprit classe, Esprit race) {
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
