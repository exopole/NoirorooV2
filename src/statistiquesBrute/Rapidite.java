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
public class Rapidite extends StatistiqueDE implements StatistiqueInterface {

	public Rapidite(Vector<String> vector) {
		super(vector);
		// TODO Auto-generated constructor stub
	}
	
	public Rapidite(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}
	
	public Rapidite(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}

	public Rapidite(Rapidite classe, Rapidite race) {
		super(classe,race);
	}
	
	/* 
	 * @see statistiques.StatistiqueInterface#description()
	 */
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}

}
