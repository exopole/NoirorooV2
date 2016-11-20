/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view;

import NoirorooApp.Main;
import informations.Classe;
import informations.Competence;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import informations.Race;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class RaceOverviewController implements Initializable {

    @FXML
    private Label bestClasse;
    @FXML
    private Label lvlPlayer;
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

    //description de la race
    @FXML
    private Label description;
    @FXML
    private Label descriptionComp;
    @FXML
    private Label compName;
    @FXML
    private Label physique;
    @FXML
    private TableView<Competence> tableCompetence;
    @FXML
    private TableColumn<Competence, String> nameCol;

    ObservableList<Competence> compList = FXCollections.observableArrayList();
    double width;

    private Main main;

    private Map<String, Race> races;
    private Map<String, Competence> competences;
    private ObservableList<String> raceName;

    // race et classe choisie
    int raceCurrent = 0;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initialisation de la taille des différents label
        description.setWrapText(true);
        descriptionComp.setWrapText(true);
        physique.setWrapText(true);
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        tableCompetence.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setDescriptionCompLabel(newValue));
    }

    private void setDescriptionCompLabel(Competence comp) {
        if (comp != null) {
            System.out.println(comp.getNom());
            descriptionComp.setText(comp.getDescription());
            compName.setText(comp.getNom());
        }

    }

    public void setCompRace(Race race) {

        List list = new ArrayList();

        Map<String, Integer> competenceRace = race.getCompetences();
        for (Map.Entry<String, Integer> entry : competenceRace.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            list.add(new Competence(competences.get(key),value));
        }

        compList = FXCollections.observableArrayList(list);
        tableCompetence.setItems(compList);
    }

    private void showRace(Race race) {
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
        // initialisation des informations complémentaire
        bestClasse.setText(race.getBestClass());
        lvlPlayer.setText(race.getAccess());
        description.setText(race.getDescription());
        physique.setText(race.getApparence());

    }

    private void initWithRace() {

        races = main.getRaces();
        List<String> list = new ArrayList<>(races.keySet());
        raceName = FXCollections.observableList(list);

    }

    private void initCbox() {

        cbox.getItems().addAll(raceName);
        cbox.getSelectionModel().select(raceCurrent);
        cbox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                Race race = races.get(newValue.intValue());
                showRace(race);
                raceCurrent = newValue.intValue();
                if (main.getLastStep() == 4) {
                    main.setLastStep(main.getLastStep() - 1);
                    main.setSceneShow(main.getPanRace());
                }
            }
        });
    }

    public void setMainApp(Main main) {
        this.main = main;
        initWithRace();
        initCbox();
        if (races.size() > 0) {
            showRace(races.get(raceCurrent));
            competences = main.getCompetences();
            setCompRace(races.get(raceCurrent));
        }
        else
            System.out.println("front.view.RaceOverviewController.setMainApp() => pas de races initialisé pour le moment");
    }

//    public void setMainApp(Main main, int raceCurrent) {
//        this.main = main;
//        this.raceCurrent = raceCurrent;
//        initWithRace();
//        initCbox();
//        showRace(races.get(raceCurrent));
//        competences = main.getCompetences();
//        setCompRace(races.get(raceCurrent));
//
//    }
    public int getRaceCurrent() {
        return raceCurrent;
    }

    public Race getRace() {
        return races.get(raceCurrent);
    }

}
