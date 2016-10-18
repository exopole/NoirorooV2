package front.view;

import informations.Classe;
import informations.Competence;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CompetenceOverviewController {

    @FXML
    private Label description;
    @FXML
    private Label expDispo;
    @FXML
    private Button compButton = new Button();

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
    private TableColumn<Competence, String> colExp;

    @FXML
    private TableView<Competence> tableCompetenceChoisie;
    @FXML
    private TableColumn<Competence, String> colNameChoix;

    ObservableList<Competence> compList = FXCollections.observableArrayList();
    ObservableList<Competence> compTook = FXCollections.observableArrayList();
    ObservableList<Competence> compListRace = FXCollections.observableArrayList();
    ObservableList<Competence> compListClasse = FXCollections.observableArrayList();

    boolean[] compChoisie;
    int exp = 100;
    Competence compCurrent;

    ArrayList<Integer> indexTableCompChoix = new ArrayList<>();

    public CompetenceOverviewController() {
        // TODO Auto-generated constructor stub
    }

    @FXML
    private void initialize() {
        compButton.setVisible(true);
        description.setWrapText(true);
        expDispo.setText(String.valueOf(exp));
        // tableau représentant toutes les compétences
        colName.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
        colNature.setCellValueFactory(cellData -> cellData.getValue().getNatureProperty());
        colLevelMax.setCellValueFactory(cellData -> cellData.getValue().getLevelMaxProperty());
        colIncantationTime.setCellValueFactory(cellData -> cellData.getValue().getTempsIncantationProperty());
        colExp.setCellValueFactory(cellData -> cellData.getValue().getExpProperty());
        tableCompetence.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCompDesc(newValue));

        // tableau représentant les noms des compétences choisie ou acquise
        colNameChoix.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        tableCompetenceChoisie.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setCompDesc(newValue));

        //init the button add
        compButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (compTook.contains(compCurrent)) {
                    removeComp();
                } else {
                    addComp();
                }
                compButton.setText((compTook.contains(compCurrent)) ? "Remove" : "Add");

            }
        });
    }

    private void setCompDesc(Competence comp) {
        if (comp != null) {
            System.out.println(comp.getNom());
            description.setText(comp.getDescription());
            compCurrent = comp;
            compButton.setText((compTook.contains(comp)) ? "Remove" : "Add");
        }

    }

    public void setCompetence(ObservableList<Competence> compListRace, ObservableList<Competence> compListClasse) {
        ObservableList<Competence> tmp = FXCollections.observableArrayList();
        tmp.addAll(compListRace);
        tmp.addAll(compListClasse);
        if (!compare(tmp,this.compList) ) {
            this.exp = 100;
            expDispo.setText(String.valueOf(exp));
            
            this.compListRace = compListRace;
            this.compListClasse = compListClasse;
            
            compList.clear();
            tableCompetence.getItems().clear();
            tableCompetenceChoisie.getItems().clear();
            compList = FXCollections.observableArrayList();
            compList.addAll(compListRace);
            compList.addAll(compListClasse);
            
            tableCompetence.setItems(compList);
            tableCompetence.getSelectionModel().select(0);

            compTook = FXCollections.observableArrayList();
            compTook.addAll(addCompetenceInnee(compListRace));
            
            compTook.addAll(addCompetenceInnee(compListClasse));
            tableCompetenceChoisie.setItems(compTook);

            compChoisie = new boolean[compList.size()];
            for (int i = 0; i < compChoisie.length; i++) {
                compChoisie[i] = (compList.get(i).getExp() == 0);
            }

            compButton.setText((compChoisie[0]) ? "Remove" : "Add");        
           
        }
            
       

    }

    public void setSizeWidth(double with) {
        tableCompetence.setMaxWidth(with);
        description.setMaxWidth(with);
    }

    private ObservableList<Competence> addCompetenceInnee(ObservableList<Competence> compList) {
        ObservableList<Competence> result = FXCollections.observableArrayList();
        
        for (int i = 0; i < compList.size(); i++) {
            if (compList.get(i).getExp() == 0) {
                result.add(compList.get(i));
                indexTableCompChoix.add(i);
            }
        }

        return result;
    }

    public void removeComp() {
        compTook.remove(compCurrent);
        exp += compCurrent.getExp();
        expDispo.setText(String.valueOf(exp));
    }

    public void addComp() {
        if (exp - compCurrent.getExp() >= 0) {
            compTook.add(compCurrent);
            exp -= compCurrent.getExp();
            expDispo.setText(String.valueOf(exp));
        }
    }

    public ObservableList<Competence> getCompetenceAll() {
        return compList;
    }

    public ObservableList<Competence> getCompetenceChoisies() {
        return compTook;
    }

    public boolean compare(ObservableList<Competence> compList1, ObservableList<Competence> compList2){
        if (compList1.size() != compList2.size())
            return false;
        else {
            for (int i = 0; i < compList2.size(); i++) {
                if (! compList1.get(i).equals(compList2.get(i)))
                    return false;   
            }
            return true;
        }
        
                    
    }
    
    public ObservableList<Competence> getCompetenceList(){
        return compTook;
    }
}
