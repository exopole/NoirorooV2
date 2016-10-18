package statistiquesBrute;

import java.util.Vector;

import statistiques.StatistiqueDE;
import statistiques.StatistiqueInterface;

public class Vie extends StatistiqueDE implements StatistiqueInterface{

	public Vie(String value, String de) {
		// TODO Auto-generated constructor stub
		super(value, de);
	}
	
	public Vie(Vector<String> vector) {
		// TODO Auto-generated method stub
		super(vector);
	}
	
	public Vie(Integer value) {
		// TODO Auto-generated constructor stub
		super(value);
	}
	
	public Vie(Vie classe, Vie race) {
		super(classe,race);
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
