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
public class Intelligence extends StatistiqueDE implements StatistiqueInterface{

	public Intelligence(Vector<String> value) {
		super(value);
		// TODO Auto-generated constructor stub
	}
	
	public Intelligence(String value, String de) {
		super(value, de);
		// TODO Auto-generated constructor stub
	}
	
	public Intelligence(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Intelligence(Intelligence classe, Intelligence race) {
		super(classe,race);
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
