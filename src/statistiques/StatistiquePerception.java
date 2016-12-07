package statistiques;

import statistiquesPerception.Habilite;
import statistiquesPerception.Chance;
import statistiquesPerception.Charisme;
import statistiquesPerception.Precision;
import statistiquesPerception.Endurance;
import statistiquesPerception.Intelligence;
import statistiquesPerception.Furtivite;
import statistiquesPerception.Esquive;
import java.util.Vector;
import org.json.simple.JSONObject;

import parsing.ParsingString;

public class StatistiquePerception {

    /**
     * Statistique de precision
     */
    private Precision precision;
    /**
     * Statistique de chance
     */
    private Chance chance;
    /**
     * Statistique d'esquive
     */
    private Esquive esquive;
    /**
     * Statistique d'habilite
     */
    private Habilite habilite;
    /**
     * Statistique d'intelligence
     */
    private Intelligence intelligence;
    /**
     * Statistique d'endurance
     */
    private Endurance endurance;
    /**
     * Statistique de furtivite
     */
    private Furtivite furtivite;
    /**
     * Staistique de charisme
     */
    private Charisme charisme;

    private boolean compute = false;

    public StatistiquePerception() {
    }

    
    
    public StatistiquePerception(String content) {
        Vector< Vector< String>> stat = ParsingString.split2time(content, ";", ",");
        precision = new Precision(stat.get(0));
        chance = new Chance(stat.get(1));
        esquive = new Esquive(stat.get(2));
        habilite = new Habilite(stat.get(3));
        intelligence = new Intelligence(stat.get(4));
        endurance = new Endurance(stat.get(5));
        furtivite = new Furtivite(stat.get(6));
        charisme = new Charisme(stat.get(7));

    }

    public StatistiquePerception(JSONObject content) {
        precision = new Precision((JSONObject) content.get("precision"));
        chance = new Chance((JSONObject) content.get("chance"));
        esquive = new Esquive((JSONObject) content.get("esquive"));
        habilite = new Habilite((JSONObject) content.get("habilite"));
        intelligence = new Intelligence((JSONObject) content.get("intelligence"));
        endurance = new Endurance((JSONObject) content.get("endurance"));
        furtivite = new Furtivite((JSONObject) content.get("furtivite"));
        charisme = new Charisme((JSONObject) content.get("charisme"));

    }

    public StatistiquePerception(Integer precision, Integer chance, Integer esquive, Integer habilite,
            Integer intelligence, Integer endurance, Integer furtivite, Integer charisme) {
        this.precision = new Precision(precision);
        this.chance = new Chance(chance);
        this.esquive = new Esquive(esquive);
        this.habilite = new Habilite(habilite);
        this.intelligence = new Intelligence(intelligence);
        this.endurance = new Endurance(endurance);
        this.furtivite = new Furtivite(furtivite);
        this.charisme = new Charisme(charisme);

    }

    public StatistiquePerception(StatistiquePerception classe, StatistiquePerception race) {

        this.precision = new Precision(classe.getPrecision(), race.getPrecision());
        this.chance = new Chance(classe.getChance(), race.getChance());
        this.esquive = new Esquive(classe.getEsquive(), race.getEsquive());
        this.habilite = new Habilite(classe.getHabilite(), race.getHabilite());
        this.intelligence = new Intelligence(classe.getIntelligence(), race.getIntelligence());
        this.endurance = new Endurance(classe.getEndurance(), race.getEndurance());
        this.furtivite = new Furtivite(classe.getFurtivite(), race.getFurtivite());
        this.charisme = new Charisme(classe.getCharisme(), race.getCharisme());
    }

    /**
     * @return the precision
     */
    public Precision getPrecision() {
        return precision;
    }

    /**
     * @return the chance
     */
    public Chance getChance() {
        return chance;
    }

    /**
     * @return the esquive
     */
    public Esquive getEsquive() {
        return esquive;
    }

    /**
     * @return the habilite
     */
    public Habilite getHabilite() {
        return habilite;
    }

    /**
     * @return the intelligence
     */
    public Intelligence getIntelligence() {
        return intelligence;
    }

    /**
     * @return the endurance
     */
    public Endurance getEndurance() {
        return endurance;
    }

    /**
     * @return the furtivite
     */
    public Furtivite getFurtivite() {
        return furtivite;
    }

    /**
     * @return the charisme
     */
    public Charisme getCharisme() {
        return charisme;
    }

    public void compute() {
        if (!compute) {
            chance.compute();
            charisme.compute();
            endurance.compute();
            esquive.compute();
            furtivite.compute();
            habilite.compute();
            intelligence.compute();
            precision.compute();
            compute = true;
        }

    }

    public void setChance(Chance chance) {
        this.chance = chance;
    }

    public void setCharisme(Charisme charisme) {
        this.charisme = charisme;
    }

    public void setEndurance(Endurance endurance) {
        this.endurance = endurance;
    }

    public void setEsquive(Esquive esquive) {
        this.esquive = esquive;
    }

    public void setFurtivite(Furtivite furtivite) {
        this.furtivite = furtivite;
    }

    public void setHabilite(Habilite habilite) {
        this.habilite = habilite;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public void setPrecision(Precision precision) {
        this.precision = precision;
    }
    
    
    /**
     * @return value
     */
    public JSONObject getJsonObject() {

        JSONObject obj = new JSONObject();
        obj.put("chance", chance.getJsonObject());
        obj.put("charisme", charisme.getJsonObject());
        obj.put("endurance", endurance.getJsonObject());
        obj.put("esquive", esquive.getJsonObject());
        obj.put("furtivite", furtivite.getJsonObject());
        obj.put("habilite", habilite.getJsonObject());
        obj.put("intelligence", intelligence.getJsonObject());
        obj.put("precision", precision.getJsonObject());
        return obj;
    }

    public static void main(String[] args) {
        System.out.println("statistiques.StatistiquePerception.main()");
        JSONObject chance = new JSONObject();
        chance.put("value", 15);
        JSONObject charisme = new JSONObject();
        charisme.put("value", 10);
        JSONObject esquive = new JSONObject();
        esquive.put("value", 10);
        JSONObject furtivite = new JSONObject();
        furtivite.put("value", 10);
        JSONObject habilite = new JSONObject();
        habilite.put("value", 15);
        JSONObject intelligence = new JSONObject();
        intelligence.put("value", 0);
        JSONObject precision = new JSONObject();
        precision.put("value", 10);
        JSONObject endurance = new JSONObject();
        endurance.put("value", 10);

        JSONObject statJson = new JSONObject();
        statJson.put("chance", chance);
        statJson.put("charisme", charisme);
        statJson.put("esquive", esquive);
        statJson.put("furtivite", furtivite);
        statJson.put("habilite", habilite);
        statJson.put("intelligence", intelligence);
        statJson.put("precision", precision);
        statJson.put("endurance", precision);

        StatistiquePerception stat = new StatistiquePerception(statJson);
        JSONObject obj = stat.getJsonObject();
        StatistiquePerception stat2 = new StatistiquePerception(obj);
        System.out.println("statistiques.StatistiquePerception.main() sya2=> " + stat2.getJsonObject().toString());

    }

}
