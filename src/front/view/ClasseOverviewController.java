/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view;

import NoirorooApp.Main;
import informations.Competence;
import informations.Classe;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class ClasseOverviewController implements Initializable {

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

    //description de la race
    @FXML
    private Label description;
    @FXML
    private Label descriptionComp;
    @FXML
    private Label compName;
    @FXML
    private TableView<Competence> tableCompetence;
    @FXML
    private TableColumn<Competence, String> nameCol;

    ObservableList<Competence> compList = FXCollections.observableArrayList();
    double width;

    private Main main;

    private Vector<Classe> classes = new Vector<Classe>();
    private Vector<Competence> competences;
    private ObservableList<String> raceName;
   

    // race et classe choisie
    int classeCurrent = 0;

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

    public void setCompClasse(Classe classe) {

        List list = new ArrayList();

        Vector<Vector<String>> competenceClasse = classe.getCompetences();
        for (Vector<String> comp : competenceClasse) {
            list.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compList = FXCollections.observableArrayList(list);
        tableCompetence.setItems(compList);
    }

    private void showClasse(Classe classe) {
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
        // initialisation des informations complémentaire
        description.setText(classe.getDescription());

    }

    private void initWithClasse() {
        List<String> list = new ArrayList<>();

        classes = main.getClasses();

        for (Classe classe : classes) {
            list.add(classe.getName());
        }
        raceName = FXCollections.observableList(list);

    }

    private void initCbox() {

        cbox.getItems().addAll(raceName);
        cbox.getSelectionModel().select(classeCurrent);
        cbox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                Classe classe = classes.get(newValue.intValue());
                showClasse(classe);
                classeCurrent = newValue.intValue();
                if (main.getLastStep() == 4){
                    main.setLastStep(main.getLastStep() -1);
                    main.setSceneShow(main.getPanClasse());
                }
            }
        });
    }

    public void setMainApp(Main main) {
        this.main = main;
        initWithClasse();
        initCbox();
        showClasse(classes.get(classeCurrent));
        competences = main.getCompetences();
        setCompClasse(classes.get(classeCurrent));
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
    public int getClasseCurrent() {
        return classeCurrent;
    }
    
    public Classe getClasse(){
        return classes.get(classeCurrent);
    }

}
