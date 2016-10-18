package front.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import informations.Classe;
import informations.Competence;
import informations.Race;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DescriptionOverviewController {

    @FXML
    private Label description;
    @FXML
    private Label descriptionComp;
    @FXML
    private Label physique;
    @FXML
    private Label physiqueLabel;
    @FXML
    private TableView<Competence> tableCompetence;
    @FXML
    private TableColumn<Competence, String> nameCol;

    ObservableList<Competence> compList = FXCollections.observableArrayList();
    double width;

    public DescriptionOverviewController() {
        // TODO Auto-generated constructor stub
    }

    @FXML
    private void initialize() {
        description.setWrapText(true);
        descriptionComp.setWrapText(true);
        physique.setWrapText(true);
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        tableCompetence.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setDescriptionCompLabel(newValue));

    }

    public void setDescript(Race race, Vector<Competence> competences) {
        this.description.setText(race.getDescription());
        this.physique.setText(race.getApparence());
        descriptionComp.setText("Desciption");
        physiqueLabel.setText("Physique");
        //compRaces.clear();
        List list = new ArrayList();

        Vector<Vector<String>> competenceRace = race.getCompetences();
        for (Vector<String> comp : competenceRace) {
            list.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compList = FXCollections.observableArrayList(list);
        tableCompetence.setItems(compList);
    }

    public void setDescript(Classe classe, Vector<Competence> competences) {
        this.description.setText(classe.getDescription());
        this.physique.setText("");
        descriptionComp.setText("");
        physiqueLabel.setText("");
        //compRaces.clear();
        List list = new ArrayList();

        // allow to extract only necessarie competence
        Vector<Vector<String>> competenceClasse = classe.getCompetences();
        for (Vector<String> comp : competenceClasse) {
            list.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compList = FXCollections.observableArrayList(list);
        tableCompetence.setItems(compList);
    }

    private void setDescriptionCompLabel(Competence comp) {
        if (comp != null) {
            System.out.println(comp.getNom());
            descriptionComp.setText(comp.getDescription());
        }

    }

    public void setWidthLabel(double width) {
        this.description.setMaxWidth(width / 2.5);
        this.physique.setMaxWidth(width / 2.5);
        this.descriptionComp.setPrefWidth(width / 4);
    }

    public void setHeightLabel(double heigh) {
        this.description.setMaxHeight(heigh / 4);
        this.physique.setMaxHeight(heigh / 4);
        this.tableCompetence.setMaxHeight(heigh / 4);
        this.descriptionComp.setMaxHeight(heigh / 4);
    }

    public void emptyPhysique() {
        physique.setText("");
        physiqueLabel.setText("");
    }
}
