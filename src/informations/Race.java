package informations;

import parsing.ParsingString;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import statistiques.StatistiqueBruteClasse;
import statistiques.StatistiqueBruteRace;
import statistiques.StatistiquePerception;

public class Race {

    Vector<String> fileContenant;
    private String name;
    private String description;
    // vecteur regroupant toute les statistique de perception : Precision, Chance, Esquive, Habilite, Inteligence, Furtivite, Charisme
    private StatistiquePerception statPerception;
    // Vecteur regroupant toutes les statistiques Brute : Vie, Force, Rapidite, Dexterite, Resistance, Esprit, Deplacement
    private StatistiqueBruteRace statBrute;
    // Vecteur regroupant toutes les competences possibles avec le nombre de point d'exp besoin
    private Map<String, Integer> competences;

    private String apparence;
    // classe conseille par le maitre de jeu avec cette classe
    private String bestClass;
    // niveau de joueur conseille (ex : experimente)
    private String access;

    private Boolean compute = false;

    /*
	public Race(String nameFile) {
		Vector<String> fileContenant = ParsingFile.readFile(nameFile);
		name = fileContenant.get(0);
		statPerception = new StatistiquePerception(fileContenant.get(1));	
		statBrute = new StatistiqueBruteRace(fileContenant.get(2));
		competences =ParsingString.split2time(fileContenant.get(3), ";", ",");
		description = fileContenant.get(4);
		apparence = fileContenant.get(5);
		bestClass = fileContenant.get(6);
		access = fileContenant.get(7);
	}

     */
    public Race(String nameFile) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(nameFile));

            JSONObject jsonObject = (JSONObject) obj;
            name = (String) jsonObject.get("Name");
            statPerception = new StatistiquePerception((JSONObject) jsonObject.get("Perception"));
            statBrute = new StatistiqueBruteRace((String) jsonObject.get("Brute"));
            initCompetence((JSONObject) jsonObject.get("Competence"));
            description = (String) jsonObject.get("Description");
            apparence = (String) jsonObject.get("Description physique");
            bestClass = (String) jsonObject.get("Classe conseille");
            access = (String) jsonObject.get("Niveau de joueur");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initCompetence(JSONObject jsonObj) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonObj.toString());
        String name = (String) jsonObj.get("name");
        Integer exp = (Integer) jsonObj.get("exp");
        competences.put(name, exp);

    }

    /////////////  getter //////////
    public String getName() {
        return name;
    }

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
    public StatistiqueBruteRace getStatBrute() {
        return statBrute;
    }

    // getter pour les competences
    public Map<String, Integer> getCompetences() {
        return competences;
    }

    // getter pour les notes du maitre de jeu
    public String getAccess() {
        return access;
    }

    public String getApparence() {
        return apparence;
    }

    public String getBestClass() {
        return bestClass;
    }

    // Competences
    public void remoceCompetenceWithName(String name) {
        competences.remove(name);
    }

    public void addCompetence(String name, String identifiant) {
        Vector<String> comp = new Vector<>();
        comp.add(name);
        comp.add(identifiant);

    }

    public JSONObject getJSONCompetence() {
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

    ////////////// parsing des fichiers ///////////////
}
