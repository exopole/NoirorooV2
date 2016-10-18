package front.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.beans.value.ChangeListener;

import NoirorooApp.Main;
import informations.Classe;
import informations.Race;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class StatistiqueOverviewController {

    @FXML
    private Label type;
    @FXML
    private Label bestClasseLabel;
    @FXML
    private Label bestClasse;
    @FXML
    private Label lvlPlayer;
    @FXML
    private Label lvlPlayerLabel;

    @FXML
    private ChoiceBox cbox;
    //label des statistique de précision
    @FXML
    private Label chance;
    @FXML
    private Label charisme;
    @FXML
    private Label endurance;
    @FXML
    private Label esquive;
    @FXML
    private Label furtivite;
    @FXML
    private Label habilite;
    @FXML
    private Label intelligence;
    @FXML
    private Label precision;
    //label des statistique brute
    @FXML
    private Label dexterite;
    @FXML
    private Label esprit;
    @FXML
    private Label force;
    @FXML
    private Label rapidite;
    @FXML
    private Label resistance;
    @FXML
    private Label vie;
    @FXML
    private Label deplacement;
    @FXML
    private Label deplacementLabel;

    private Main main;
    DescriptionOverviewController controller;

    private Vector<Race> races = new Vector<Race>();
    private Vector<Classe> classes = new Vector<Classe>();

    private ObservableList<String> raceName;
    private ObservableList<String> classeName;
    
    // race et classe choisie
    int raceCurrent = 0;
    int classeCurrent = 0;

    //Permet de savoir si nous sommes entrain de choisir une race ou une classe
    private boolean isRace = true;

    public StatistiqueOverviewController() {

    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        /*
    	for (Race race : races) {
			cbox.getItems().add(race.getName());
		}
    	showStatistique(races.get(0));
         */

    }

    private void showStatistiqueRace(Race race) {
        chance.setText(race.getStatPerception().getChance().toString());
        charisme.setText(race.getStatPerception().getCharisme().toString());
        endurance.setText(race.getStatPerception().getEndurance().toString());
        esquive.setText(race.getStatPerception().getEsquive().toString());
        furtivite.setText(race.getStatPerception().getFurtivite().toString());
        habilite.setText(race.getStatPerception().getHabilite().toString());
        intelligence.setText(race.getStatPerception().getIntelligence().toString());
        precision.setText(race.getStatPerception().getPrecision().toString());
        //Initialisation des statistique brute
        dexterite.setText(race.getStatBrute().getDexterite().toString());
        esprit.setText(race.getStatBrute().getEsprit().toString());
        force.setText(race.getStatBrute().getForce().toString());
        rapidite.setText(race.getStatBrute().getRapidite().toString());
        resistance.setText(race.getStatBrute().getResistance().toString());
        vie.setText(race.getStatBrute().getVie().toString());
        deplacement.setText(race.getStatBrute().getDeplacement().toString());

    }

    private void showStatistiqueClasse(Classe classe) {
        chance.setText(classe.getStatPerception().getChance().toString());
        charisme.setText(classe.getStatPerception().getCharisme().toString());
        endurance.setText(classe.getStatPerception().getEndurance().toString());
        esquive.setText(classe.getStatPerception().getEsquive().toString());
        furtivite.setText(classe.getStatPerception().getFurtivite().toString());
        habilite.setText(classe.getStatPerception().getHabilite().toString());
        intelligence.setText(classe.getStatPerception().getIntelligence().toString());
        precision.setText(classe.getStatPerception().getPrecision().toString());
        //Initialisation des statistique brute
        dexterite.setText(classe.getStatBrute().getDexterite().toString());
        esprit.setText(classe.getStatBrute().getEsprit().toString());
        force.setText(classe.getStatBrute().getForce().toString());
        rapidite.setText(classe.getStatBrute().getRapidite().toString());
        resistance.setText(classe.getStatBrute().getResistance().toString());
        vie.setText(classe.getStatBrute().getVie().toString());
        deplacement.setText("");
        lvlPlayer.setText("");

    }

    public void showrace(Race race) {
        showStatistiqueRace(race);
        bestClasse.setText(race.getBestClass());
        lvlPlayer.setText(race.getAccess());
    }

    public void showclasse(Classe classe) {
        showStatistiqueClasse(classe);
    }

    private void initWithRace() {
        List<String> list = new ArrayList<String>();

        races = main.getRaces();
        for (Race race : races) {
            list.add(race.getName());
        }
        raceName = FXCollections.observableList(list);

    }

    private void initWithClasse() {
        List<String> list = new ArrayList<String>();

        classes = main.getClasses();
        for (Classe classe : classes) {
            list.add(classe.getName());
        }
        classeName = FXCollections.observableList(list);
    }

    public void setRaceOrClasse() {
        cbox.getItems().clear();
        if (!isRace) {
            type.setText("Race");
            deplacementLabel.setText("Déplacement");
            bestClasse.setText("Classe conseillé");
            lvlPlayerLabel.setText("Niveau du joueur conseillé");
            isRace = true;
        } else {
            type.setText("Classe");
            deplacementLabel.setText("");
            bestClasse.setText("");
            lvlPlayerLabel.setText("");
            //Ne fonctionne pas doit le rajouter dans showclasse
            //lvlPlayer.setText("");
            //deplacement.setText(""); 
            isRace = false;
        }
        setcbox();

    }

    private void setcbox() {

        if (isRace) {
            cbox.getItems().addAll(raceName);
            cbox.getSelectionModel().select(raceCurrent);
            cbox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                    Race race = races.get(newValue.intValue());
                    showrace(race);
                    main.setPage2Race(newValue.intValue());
                    raceCurrent = newValue.intValue();
                }
            });

            showrace(races.get(raceCurrent));
        } else {

            cbox.getItems().addAll(classeName);
            cbox.getSelectionModel().select(classeCurrent);
            cbox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                    Classe classe = classes.get(newValue.intValue());
                    showclasse(classe);
                    main.setPage2Classe(newValue.intValue());
                    classeCurrent = newValue.intValue();
                }
            });

            showclasse(classes.get(classeCurrent));
        }
    }

    public void setMainApp(Main main) {
        this.main = main;
        initWithRace();
        initWithClasse();
        type.setText("Race");
        setcbox();
    }

}
