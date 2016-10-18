package informations;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import parsing.*;
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
	private Vector<Vector<String>> competences;

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
    		statPerception = new StatistiquePerception((String) jsonObject.get("Perception"));	
    		statBrute = new StatistiqueBruteRace((String) jsonObject.get("Brute"));
    		competences =ParsingString.split2time((String) jsonObject.get("Competence"), ";", ",");
    		description = (String) jsonObject.get("Description");
    		apparence = (String) jsonObject.get("Description physique");
    		bestClass = (String) jsonObject.get("Classe conseille");
    		access = (String) jsonObject.get("Niveau de joueur");

 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
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
	public Vector<Vector<String>> getCompetences() {
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
	
	public void compute() {
		if (compute == false)
		{
			statBrute.compute();
			statPerception.compute();
			compute = true;
		}
	}
	
	
	
	////////////// parsing des fichiers ///////////////
	
}
