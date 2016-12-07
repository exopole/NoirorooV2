package statistiques;

import java.util.Vector;
import org.json.simple.JSONObject;

import parsing.ParsingString;
import statistiquesBrute.Deplacement;
import statistiquesBrute.Dexterite;
import statistiquesBrute.Esprit;
import statistiquesBrute.Force;
import statistiquesBrute.Rapidite;
import statistiquesBrute.Resistance;
import statistiquesBrute.Vie;
import statistiquesPerception.Chance;
import statistiquesPerception.Charisme;
import statistiquesPerception.Endurance;
import statistiquesPerception.Esquive;
import statistiquesPerception.Furtivite;
import statistiquesPerception.Habilite;
import statistiquesPerception.Intelligence;
import statistiquesPerception.Precision;

public class StatistiqueBruteClasse {

    protected Vie vie;
    protected Force force;
    protected Rapidite rapidite;
    protected Resistance resistance;
    protected Esprit esprit;
    protected Dexterite dexterite;
    protected Boolean compute = false;
    protected Vector< Vector< String>> stat;

    public StatistiqueBruteClasse() {
        // TODO Auto-generated constructor stub
    }

    public StatistiqueBruteClasse(String content) {
        stat = ParsingString.split2time(content, ";", ",");
        vie = new Vie(stat.get(0));
        force = new Force(stat.get(1));
        rapidite = new Rapidite(stat.get(2));
        dexterite = new Dexterite(stat.get(3));
        resistance = new Resistance(stat.get(4));
        esprit = new Esprit(stat.get(5));
    }

    public StatistiqueBruteClasse(JSONObject content) {
        vie = new Vie((JSONObject) content.get("vie"));
        force = new Force((JSONObject) content.get("force"));
        rapidite = new Rapidite((JSONObject) content.get("rapidite"));
        dexterite = new Dexterite((JSONObject) content.get("dexterite"));
        resistance = new Resistance((JSONObject) content.get("resistance"));
        esprit = new Esprit((JSONObject) content.get("esprit"));

    }

    /**
     * @return the vie
     */
    public Vie getVie() {
        return vie;
    }

    /**
     * @return the force
     */
    public Force getForce() {
        return force;
    }

    /**
     * @return the rapidite
     */
    public Rapidite getRapidite() {
        return rapidite;
    }

    /**
     * @return the resistance
     */
    public Resistance getResistance() {
        return resistance;
    }

    /**
     * @return the esprit
     */
    public Esprit getEsprit() {
        return esprit;
    }

    /**
     * @return the dexterite
     */
    public Dexterite getDexterite() {
        return dexterite;
    }

    public void setDexterite(Dexterite dexterite) {
        this.dexterite = dexterite;
    }

    public void setEsprit(Esprit esprit) {
        this.esprit = esprit;
    }

    public void setForce(Force force) {
        this.force = force;
    }

    public void setRapidite(Rapidite rapidite) {
        this.rapidite = rapidite;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public void setVie(Vie vie) {
        this.vie = vie;
    }
    
    
    

    public void compute() {
        if (compute == false) {
            dexterite.compute();
            esprit.compute();
            force.compute();
            rapidite.compute();
            resistance.compute();
            vie.compute();
            compute = true;
        }
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
        return obj;
    }

    public static void main(String[] args) {
        System.out.println("statistiques.StatistiqueBruteClasse.main()");
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

        JSONObject statJson = new JSONObject();
        statJson.put("vie", vie);
        statJson.put("force", force);
        statJson.put("rapidite", rapidite);
        statJson.put("dexterite", dexterite);
        statJson.put("resistance", resistance);
        statJson.put("esprit", esprit);

        StatistiqueBruteClasse stat = new StatistiqueBruteClasse(statJson);
        JSONObject obj = stat.getJsonObject();
        StatistiqueBruteClasse stat2 = new StatistiqueBruteClasse(obj);
        System.out.println("statistiques.StatistiqueBruteClasse.main() sya2=> " + stat2.getJsonObject().toString());

    }

}
