/**
 * 
 */
package statistiques;

import org.json.simple.JSONObject;
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
        
        public StatistiqueBruteRace(JSONObject content) {
		super(content);
		// TODO Auto-generated constructor stub
		deplacement = new Deplacement((Integer) ((JSONObject) content.get("deplacement")).get("value"));

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
        
        
     /**
     * @return value
     */
    public JSONObject getJsonObject() {
        
        JSONObject obj = new JSONObject();
        obj.put("dexterite", dexterite.getJsonObject());
        obj.put("esprit", esprit.getJsonObject());
        obj.put("force", force.getJsonObject());
        obj.put("rapidite", rapidite.getJsonObject());
        obj.put("resistance", resistance.getJsonObject());
        obj.put("vie", vie.getJsonObject());
        obj.put("deplacement", deplacement.getJsonObject());
        return obj;
    }

    public static void main(String[] args) {
        JSONObject dexterite = new JSONObject();
        dexterite.put("value", 2);
        dexterite.put("de", "3D6");
        JSONObject esprit = new JSONObject();
        esprit.put("value", 2);
        esprit.put("de", "3D6");
        JSONObject force = new JSONObject();
        force.put("value", 2);
        force.put("de", "3D6");
        JSONObject rapidite = new JSONObject();
        rapidite.put("value", 2);
        rapidite.put("de", "3D6");
        JSONObject resistance = new JSONObject();
        resistance.put("value", 2);
        resistance.put("de", "3D6");
        JSONObject vie = new JSONObject();
        vie.put("value", 2);
        vie.put("de", "3D6");
        JSONObject deplacement = new JSONObject();
        deplacement.put("value", 2);
        
        
        JSONObject statJson = new JSONObject();
        statJson.put("vie", vie);
        statJson.put("force", force);
        statJson.put("rapidite", rapidite);
        statJson.put("dexterite", dexterite);
        statJson.put("resistance", resistance);
        statJson.put("esprit", esprit);
        statJson.put("deplacement", deplacement);
        
        StatistiqueBruteRace stat = new StatistiqueBruteRace(statJson);
        JSONObject obj = stat.getJsonObject();
        StatistiqueBruteRace stat2 = new StatistiqueBruteRace(obj);
        System.out.println("statistiques.StatistiqueBruteRace.main() sya2=> " + stat2.getJsonObject().toString());

        //System.out.println("statistiques.StatistiqueBruteRace.main() => " + stat.getJsonObject().toString());
        
        
    }
    
	
}
