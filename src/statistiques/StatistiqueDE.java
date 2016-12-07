package statistiques;

import java.util.Vector;

import complement.De;
import org.json.simple.JSONObject;

public abstract class StatistiqueDE extends Statistique {

    De de;

    /**
     *
     * @param value
     * @param de
     */
    public StatistiqueDE(String value, String de) {
        // TODO Auto-generated constructor stub
        super(value);
        if (de != null) {
            this.de = new De(de);
        } else {
            this.de = null;
        }
    }

    public StatistiqueDE(JSONObject stat) {
        // TODO Auto-generated constructor stub
        super(Integer.valueOf(((Long) stat.get("value")).intValue()));        

        if (stat.get("de") != null) {
            this.de = new De((String) stat.get("de"));
        } else {
            this.de = null;
        }
    }

    public StatistiqueDE(StatistiqueDE classe, StatistiqueDE race) {
        // TODO Auto-generated constructor stub
        super(classe.getValue() + race.getValue());
        if (race.getDe() != null) {
            de = race.getDe();
        }
    }

    /**
     *
     * @param value
     */
    public StatistiqueDE(Vector<String> stat) {
        // TODO Auto-generated constructor stub

        super(stat.get(0));
        if (stat.size() == 2) {
            de = new De(stat.get(1));
        } else {
            this.de = null;
        }
    }

    public StatistiqueDE(Integer value) {
        super(value);
    }

    /**
     * @return the de
     */
    public De getDe() {
        return de;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        if (de != null) {
            return super.toString() + " + " + de;
        }
        return super.toString();
    }

    public void compute() {

        if (de != null && compute == false) {
            de.compute();
            this.value += de.getResult();
            compute = true;
            System.out.println(value);
        }

    }

    /**
     * @return value
     */
    @Override
    public JSONObject getJsonObject() {

        JSONObject obj = new JSONObject();
        obj.put("value", value);
        if (de != null) {
            obj.put("de", de.toString());
        }
        return obj;
    }

}
