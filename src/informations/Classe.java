package informations;

import java.io.FileReader;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import parsing.*;
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
    private Vector<Vector<String>> competences;

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
            competences = ParsingString.split2time((String) jsonObject.get("Competence"), ";", ",");
            description = (String) jsonObject.get("Description");

        } catch (Exception e) {
            e.printStackTrace();
        }

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
    public Vector<Vector<String>> getCompetences() {
        return competences;
    }

    /**
     * Retourne la liste de noms de toutes les competences
     *
     * @return Vector of String
     */
    public Vector<String> getAllNameCompetences() {
        Vector<String> newVector = new Vector<String>();
        for (int i = 0; i < competences.size(); i++) {
            newVector.add(competences.get(i).get(0));
        }

        return newVector;
    }

    /**
     * Retourne la liste des points experiences necessaire pour chaques
     * competences
     *
     * @return vector of double
     */
    public Vector<Double> getAllXP() {
        Vector<Double> newVector = new Vector<Double>();
        for (int i = 0; i < competences.size(); i++) {
            newVector.add(Double.parseDouble(competences.get(i).get(1)));
        }

        return newVector;
    }

    /**
     * Retourne la liste des competences et le nombre de points d'experiences
     * associe
     *
     * @param i
     * @return Vector of String
     */
    public Vector<String> getCompetenceAndXpByNumber(int i) {
        return competences.get(i);
    }

    public void compute() {
        if (compute == false) {
            statBrute.compute();
            statPerception.compute();
            compute = true;
        }
    }

}
