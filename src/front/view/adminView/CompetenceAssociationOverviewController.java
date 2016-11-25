/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view.adminView;

import informations.Classe;
import informations.Competence;
import informations.Race;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import org.json.simple.JSONObject;
import parsing.ParsingFile;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class CompetenceAssociationOverviewController implements Initializable {

private String pathCompetence = "Competence/competences.json";
    private enum ASSOCIATIONWITH{
        classe,
        race
    };
    ASSOCIATIONWITH assoc;
    
    
    Classe classe;
    Race race;

    @FXML
    private Button ajouter = new Button();
    @FXML
    private Button modifier = new Button();
    @FXML
    private Button remove = new Button();
    @FXML
    private Button enregistrer = new Button();

    @FXML
    private Label resultButton;
    //Tableau de compétences
    @FXML
    private TableView<Competence> tableCompetence;
    @FXML
    private TableColumn<Competence, String> colName;
    @FXML
    private TableColumn<Competence, String> colType;
    @FXML
    private TableColumn<Competence, String> colNature;
    @FXML
    private TableColumn<Competence, String> colLevelMax;
    @FXML
    private TableColumn<Competence, String> colIncantationTime;
    @FXML
    private TextArea nom;
    @FXML
    private TextArea type;
    @FXML
    private TextArea nature;
    @FXML
    private TextArea levelMax;
    @FXML
    private TextArea incantationTime;
    @FXML
    private TextArea description;

    ObservableList<Competence> compList = FXCollections.observableArrayList();
    Competence compCurrent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        description.setWrapText(true);
        // tableau représentant toutes les compétences
        initTableau();
    }

    private void initTableau() {
        tableCompetence.setItems(compList);
        colName.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
        colNature.setCellValueFactory(cellData -> cellData.getValue().getNatureProperty());
        colLevelMax.setCellValueFactory(cellData -> cellData.getValue().getLevelMaxProperty());
        colIncantationTime.setCellValueFactory(cellData -> cellData.getValue().getTempsIncantationProperty());
        tableCompetence.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCompDesc(newValue));
    }

    private void setCompDesc(Competence comp) {
        if (comp != null) {
            System.out.println(comp.getNom());
            description.setText(comp.getDescription());
            compCurrent = comp;
            nom.setText(comp.getNom());
            type.setText(comp.getType());
            nature.setText(comp.getNature());
            levelMax.setText(String.valueOf(comp.getLevelMax()));
            incantationTime.setText(String.valueOf(comp.getTempsIncantation()));
        }

    }

    @FXML
    private void remove() throws IOException {
        if(compCurrent.getClasses() != null)
            for (String classe : compCurrent.getClasses()) {
                Classe newClasse = new Classe(classe);
                newClasse.remoceCompetenceWithName(compCurrent.getNom());
                ParsingFile.writeFileWithString(newClasse.getJSONObject().toJSONString(), "RaceJSON/" + classe + ".json");
            }
        if(compCurrent.getRaces() != null)
            for (String race : compCurrent.getRaces()) {
                Race newRace = new Race(race);
                newRace.remoceCompetenceWithName(compCurrent.getNom());
                ParsingFile.writeFileWithString(newRace.getJSONObject().toJSONString(), "RaceJSON/" + race + ".json");
            }
        
        
        compList.remove(compCurrent);
        enregistrer();
    }

    @FXML
    private void modifier() {
        if (compCurrent != null) {
            compCurrent.setNom(nom.getText());
            compCurrent.setDescription(description.getText());
            compCurrent.setLevelMax(Integer.valueOf(levelMax.getText()));
            compCurrent.setNature(nature.getText());
            compCurrent.setTempsIncantation(Integer.valueOf(incantationTime.getText()));
            compCurrent.setType(type.getText());
            resultButton.setText("Compétence modifier");
        }
        else
        {
            resultButton.setText("Aucune compétence sélectionner");
        }

    }

    @FXML
    private void ajouter() {
        if (nom.getText().length() == 0) {
            resultButton.setText("Vous n'avez pas mis de nom à la compétence");
        } else if (!haveCompetence()) {
            Competence newCompetence = new Competence();
            newCompetence.setNom(nom.getText());
            newCompetence.setDescription(description.getText());
            newCompetence.setLevelMax(Integer.valueOf(levelMax.getText()));
            newCompetence.setNature(nature.getText());
            newCompetence.setTempsIncantation(Double.valueOf(incantationTime.getText()));
            newCompetence.setType(type.getText());
            compList.add(newCompetence);
            resultButton.setText("Competence ajouter");
        } else {
            resultButton.setText("Une compétence avec le même nom existe déjà");
        }
    }

    @FXML
    private void enregistrer() {
        try {
            JSONObject objWrite = new JSONObject();

            for (Competence comp : compList) {
                objWrite.put(comp.getNom(), comp.getJSONObject());
            }

            ParsingFile.writeFileWithString(objWrite.toJSONString(), pathCompetence);

            resultButton.setText("Competence enregistrer");

        } catch (Exception e) {
            System.out.println("NoirorooApp.Main.<init>(), " + e.getMessage());
        }

    }

    private boolean haveCompetence() {
        int i = 0;

        String nom = this.nom.getText();

        System.out.println("front.view.adminView.CompetenceAdminOverviewController.haveCompetence(); nom.getText():" + nom.length());

        if (nom.length() == 0) {
            return false;
        }

        while (i < compList.size() && !compList.get(i).getNom().equals(nom)) {
            String nameTmp = compList.get(i).getNom();
            i++;
        }

        return i < compList.size();
    }

    public void setCompetenceList(Map<String, Competence> competences) {
        for (Map.Entry<String, Competence> entry : competences.entrySet()) {
            compList.add(entry.getValue());
        }
    }
    
    public void setRace(Race race){
        this.race = race;
        assoc = ASSOCIATIONWITH.race;
        
    }
    
    public void setClasse(Classe classe){
        this.classe = classe;
        assoc = ASSOCIATIONWITH.classe;
    }

    public ASSOCIATIONWITH getAssoc() {
        return assoc;
    }
    
    
    
    
   
}
