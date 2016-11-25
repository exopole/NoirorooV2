package informations;

import parsing.ParsingString;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.simple.parser.ParseException;
import statistiques.StatistiqueBruteClasse;
import statistiques.StatistiqueBruteRace;
import statistiques.StatistiquePerception;

/**
 * Classe est la classe presentant les classes des personnages
 *
 * @author exopole
 *
 */
public class Classe {

    /**
     * nom de la classe, inchangeable
     */
    private String name;
    /**
     * description de la classe, inchangeable
     */
    private String description;

    /**
     * Toutes les statistique lie a la perception de la classe, inchangeable
     *
     * @see PerceptionClasse
     */
    private StatistiquePerception statPerception;

    /**
     * Toutes les statistique brute de la classe, inchangeable
     *
     * @see BruteClasse
     */
    private StatistiqueBruteClasse statBrute;

    /**
     * Toutes les competences et xp associe disponible pour la classe,
     * inchangeable
     *
     * @see BruteClasse
     */
    private Map<String, Integer> competences;

    private Boolean compute = false;

    /**
     * Constructeur permettant d'initie toutes les valeurs de la classe grace au
     * path du fichier
     *
     * @param nameFile
     */
    public Classe(String nameFile) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(nameFile));

            JSONObject jsonObject = (JSONObject) obj;
            name = (String) jsonObject.get("Name");
            statPerception = new StatistiquePerception((String) jsonObject.get("Perception"));
            statBrute = new StatistiqueBruteClasse((String) jsonObject.get("Brute"));
            initCompetence((JSONObject) jsonObject.get("Competence"));
            description = (String) jsonObject.get("Description");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initCompetence(JSONObject jsonObj) throws ParseException {
        for (Iterator iterator = jsonObj.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            competences.put(key, (Integer) jsonObj.get(key));
        }


    }

    // Competences
    public void remoceCompetenceWithName(String name) {
        competences.remove(name);
    }


    /*
	 * retourne le nom de la classe
	 * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * retourne la description de la classe
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the statPerception
     */
    public StatistiquePerception getStatPerception() {
        return statPerception;
    }

    /**
     * @return the statBrute
     */
    public StatistiqueBruteClasse getStatBrute() {
        return statBrute;
    }

    /**
     * Retourne les competences avec leur points experience recquis
     *
     * @return Vector of vector de string
     */
    public Map<String, Integer> getCompetences() {
        return competences;
    }

    /**
     * Retourne la liste de noms de toutes les competences
     *
     * @return Vector of String
     */
    public ArrayList<String> getAllNameCompetences() {

        return new ArrayList<>(competences.keySet());
    }
    
    
    public JSONObject getJSONCompetence(){
        JSONObject result = new JSONObject();

        for (Map.Entry<String, Integer> entry : competences.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result.put(key, value);
        }
        
        return result;
    }

    public JSONObject getJSONObject() {
        JSONObject result = new JSONObject();
        result.put("Name", name);
        result.put("Brute", statBrute.getJsonObject());
        result.put("Perception", statPerception.getJsonObject());
        result.put("Competence", getJSONCompetence());
        result.put("Description", this.description);
        return result;
    }

    public void compute() {
        if (compute == false) {
            statBrute.compute();
            statPerception.compute();
            compute = true;
        }
    }

}
