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
public class Force extends StatistiqueDE implements StatistiqueInterface{

	public Force(String value, String de) {
		super(value, de);
	}
	
	public Force(Vector<String> vector) {
		super(vector);
	}

	public Force(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Force(Force classe, Force race) {
		super(classe,race);
	}
	
	@Override
	public String description() {
		return null;
	}
	

}
