/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view;

import informations.Race;
import informations.Classe;
import informations.Competence;
import informations.Personnage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import java.util.Vector;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class PersonnageOverviewController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private ScrollPane scrollRace;
    @FXML
    private AnchorPane racePane;
    @FXML
    private ScrollPane scrollClasse;
    ToggleGroup group;
    @FXML
    private RadioButton radioFemale;
    @FXML
    private RadioButton radioMale;
    @FXML
    private RadioButton radioUndefined;
    @FXML
    private Label labelRace;
    @FXML
    private Label labelClasse;

    //label des statistique de précision
    @FXML
    private Label raceChance;
    @FXML
    private Label raceCharisme;
    @FXML
    private Label raceEndurance;
    @FXML
    private Label raceEsquive;
    @FXML
    private Label raceFurtivite;
    @FXML
    private Label raceHabilite;
    @FXML
    private Label raceIntelligence;
    @FXML
    private Label racePrecision;

    @FXML
    private Label classeChance;
    @FXML
    private Label classeCharisme;
    @FXML
    private Label classeEndurance;
    @FXML
    private Label classeEsquive;
    @FXML
    private Label classeFurtivite;
    @FXML
    private Label classeHabilite;
    @FXML
    private Label classeIntelligence;
    @FXML
    private Label classePrecision;
    //label des statistique brute
    @FXML
    private Label raceDexterite;
    @FXML
    private Label raceEsprit;
    @FXML
    private Label raceForce;
    @FXML
    private Label raceRapidite;
    @FXML
    private Label raceResistance;
    @FXML
    private Label raceVie;
    @FXML
    private Label raceDeplacement;

    @FXML
    private Label classeDexterite;
    @FXML
    private Label classeEsprit;
    @FXML
    private Label classeForce;
    @FXML
    private Label classeRapidite;
    @FXML
    private Label classeResistance;
    @FXML
    private Label classeVie;

    //description de la race
    @FXML
    private Label descriptionRace;
    @FXML
    private Label descriptionClasse;
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

    Race race;
    Classe classe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrollRace.setContent(descriptionRace);
        scrollRace.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollClasse.setContent(descriptionClasse);

        scrollClasse.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        group = new ToggleGroup();
        radioFemale.setSelected(true);
        radioFemale.setToggleGroup(group);
        radioMale.setToggleGroup(group);
        radioUndefined.setToggleGroup(group);
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

    public String getSexe() {
        if (radioFemale.isSelected()) {
            return "feminin";
        }

        if (radioMale.isSelected()) {
            return "male";
        }

        return "Undefined";
    }

    public void setPersonnage(Race race, Classe classe, ObservableList<Competence> compList) {
        setClasse(classe);
        classe.toString();
        setRace(race);
        setCompetence(compList);
        

    }

    public void setClasse(Classe classe) {
        this.labelClasse.setText(classe.getName());
        this.classe = classe;
        classeChance.setText(classe.getStatPerception().getChance().toString());
        classeCharisme.setText(classe.getStatPerception().getCharisme().toString());
        classeEndurance.setText(classe.getStatPerception().getEndurance().toString());
        classeEsquive.setText(classe.getStatPerception().getEsquive().toString());
        classeFurtivite.setText(classe.getStatPerception().getFurtivite().toString());
        classeHabilite.setText(classe.getStatPerception().getHabilite().toString());
        classeIntelligence.setText(classe.getStatPerception().getIntelligence().toString());
        classePrecision.setText(classe.getStatPerception().getPrecision().toString());

        //Initialisation des statistique brute
        classeDexterite.setText(classe.getStatBrute().getDexterite().toString());
        classeEsprit.setText(classe.getStatBrute().getEsprit().toString());
        classeForce.setText(classe.getStatBrute().getForce().toString());
        classeRapidite.setText(classe.getStatBrute().getRapidite().toString());
        classeResistance.setText(classe.getStatBrute().getResistance().toString());
        classeVie.setText(classe.getStatBrute().getVie().toString());

        // initialisation des informations complémentaire
        descriptionClasse.setText(classe.getDescription());
    }

    public void setRace(Race race) {
        this.labelRace.setText(race.getName());
        this.race = race;

        raceChance.setText(race.getStatPerception().getChance().toString());
        raceCharisme.setText(race.getStatPerception().getCharisme().toString());
        raceEndurance.setText(race.getStatPerception().getEndurance().toString());
        raceEsquive.setText(race.getStatPerception().getEsquive().toString());
        raceFurtivite.setText(race.getStatPerception().getFurtivite().toString());
        raceHabilite.setText(race.getStatPerception().getHabilite().toString());
        raceIntelligence.setText(race.getStatPerception().getIntelligence().toString());
        racePrecision.setText(race.getStatPerception().getPrecision().toString());
        //Initialisation des statistique brute
        raceDexterite.setText(race.getStatBrute().getDexterite().toString());
        raceEsprit.setText(race.getStatBrute().getEsprit().toString());
        raceForce.setText(race.getStatBrute().getForce().toString());
        raceRapidite.setText(race.getStatBrute().getRapidite().toString());
        raceResistance.setText(race.getStatBrute().getResistance().toString());
        raceVie.setText(race.getStatBrute().getVie().toString());
        raceDeplacement.setText(race.getStatBrute().getDeplacement().toString());

        // initialisation des informations complémentaire
        descriptionRace.setText(race.getDescription());
        physique.setText(race.getApparence());

    }

    public void setCompetence(ObservableList<Competence> complist) {
        this.compList = complist;
        this.tableCompetence.setItems(complist);
    }

    public void setSize(double width, double height) {
        descriptionRace.setMaxWidth(width / 1.25);
        scrollRace.setPrefHeight(height/6);
        scrollClasse.setPrefHeight(height/6);
        descriptionClasse.setMaxWidth(width / 1.25);
        physique.setMaxWidth(width / 1.25);
        descriptionComp.setMaxWidth(width / 2.5);

    }
    
    public Vector<Competence> getCompetenceVector(){
        Vector<Competence> result = new Vector<Competence>() ;
        for (Competence competence : compList) {
            result.add(competence);
        }
        return result;
    }
    
    private Personnage getPersonnage(){
        return new Personnage(nameField.getText(), getSexe(), this.race, this.classe, getCompetenceVector());
    }

}
