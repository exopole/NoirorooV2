/**
 * 
 */
package statistiquesBrute;

import statistiques.Statistique;
import statistiques.StatistiqueInterface;

/**
 * @author exopole
 *
 */
public class Deplacement extends Statistique implements StatistiqueInterface {

	public Deplacement(String value) {
		super(value);
	}

	
	public Deplacement(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	
	
	public void compute(Rapidite rapide)
	{
		if (compute == false)
		{
			value += (rapide.getValue()/5);
			compute = true;
		}
	}
	
	
	/* 
	 * @see statistiques.StatistiqueInterface#description()
	 */
	@Override
	public String description() {
		return null;
	}

}
