/**
 * 
 */
package statistiques;

import statistiquesBrute.Deplacement;

/**
 * @author exopole
 *
 */
public class StatistiqueBruteRace extends StatistiqueBruteClasse 
{
	Deplacement deplacement;
	
	
	public StatistiqueBruteRace() {
		// TODO Auto-generated constructor stub
	}
	
	public StatistiqueBruteRace(String content) {
		super(content);
		// TODO Auto-generated constructor stub
		deplacement = new Deplacement(stat.get(6).get(0));

	}
	
	/**
	 * @return the deplacement
	 */
	public Deplacement getDeplacement() {
		return deplacement;
	}

	@Override
	public void compute() {
		// TODO Auto-generated method stub
		super.compute();
		deplacement.compute(rapidite);
	}

	
}
