/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view.adminView;

import NoirorooApp.Main;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import informations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import statistiquesBrute.Deplacement;
import statistiquesBrute.Dexterite;
import statistiquesBrute.Esprit;
import statistiquesBrute.Force;
import statistiquesBrute.Rapidite;
import statistiquesBrute.Resistance;
import statistiquesBrute.Vie;
import statistiquesPerception.Chance;
import statistiquesPerception.Charisme;
import statistiquesPerception.Endurance;
import statistiquesPerception.Esquive;
import statistiquesPerception.Furtivite;
import statistiquesPerception.Habilite;
import statistiquesPerception.Intelligence;
import statistiquesPerception.Precision;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class RaceAdminOverviewController implements Initializable {

    ObservableList<String> Dee = FXCollections.observableArrayList("2", "3", "4", "6", "8", "10", "100", "12", "20", "30");
    Main main;
    ObservableList<String> racesList;
    ObservableList<String> classeList;
    ObservableList<String> lvlPlayerList = FXCollections.observableArrayList("debutant", "normal", "bon", "expérimenté");
    /////////// 
    @FXML
    ComboBox<String> raceBox;
    
    @FXML
    TextArea description;
    @FXML
    TextArea descriptionPhysique;

    @FXML
    ChoiceBox classeConseiller;
    
    @FXML
    ChoiceBox lvlPlayer;
    ////// Statistique Brute ////
    /// Value
    @FXML
    Spinner spinnerDexValue;
    @FXML
    Spinner spinnerEspritValue;
    @FXML
    Spinner spinnerForceValue;
    @FXML
    Spinner spinnerRapiditeValue;
    @FXML
    Spinner spinnerResValue;
    @FXML
    Spinner spinnerVieValue;
    @FXML
    Spinner spinnerDeplacementValue;
    /// Number De
    @FXML
    Spinner spinnerDexNumberDe;
    @FXML
    Spinner spinnerEspritNumberDe;
    @FXML
    Spinner spinnerForceNumberDe;
    @FXML
    Spinner spinnerRapiditeNumberDe;
    @FXML
    Spinner spinnerResNumberDe;
    @FXML
    Spinner spinnerVieNumberDe;
    /// Value de
    @FXML
    Spinner spinnerDexValueDe;
    @FXML
    Spinner spinnerEspritValueDe;
    @FXML
    Spinner spinnerForceValueDe;
    @FXML
    Spinner spinnerRapiditeValueDe;
    @FXML
    Spinner spinnerResValueDe;
    @FXML
    Spinner spinnerVieValueDe;
    ////// Statistique perception ////
    /// value
    @FXML
    Spinner spinnerChanceValue;
    @FXML
    Spinner spinnerCharismeValue;
    @FXML
    Spinner spinnerEnduranceValue;
    @FXML
    Spinner spinnerEsquiveValue;
    @FXML
    Spinner spinnerFurtiviteValue;
    @FXML
    Spinner spinnerHabiliteValue;
    @FXML
    Spinner spinnerIntelligenceValue;
    @FXML
    Spinner spinnerPrecisionValue;
    /// Number De
    @FXML
    Spinner spinnerChanceNumberDe;
    @FXML
    Spinner spinnerCharismeNumberDe;
    @FXML
    Spinner spinnerEnduranceNumberDe;
    @FXML
    Spinner spinnerEsquiveNumberDe;
    @FXML
    Spinner spinnerFurtiviteNumberDe;
    @FXML
    Spinner spinnerHabiliteNumberDe;
    @FXML
    Spinner spinnerIntelligenceNumberDe;
    @FXML
    Spinner spinnerPrecisionNumberDe;
    /// Value de
    @FXML
    Spinner spinnerChanceValueDe;
    @FXML
    Spinner spinnerCharismeValueDe;
    @FXML
    Spinner spinnerEnduranceValueDe;
    @FXML
    Spinner spinnerEsquiveValueDe;
    @FXML
    Spinner spinnerFurtiviteValueDe;
    @FXML
    Spinner spinnerHabiliteValueDe;
    @FXML
    Spinner spinnerIntelligenceValueDe;
    @FXML
    Spinner spinnerPrecisionValueDe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerDexNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerDexValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerDexValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0));
        spinnerEspritNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEspritValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerEspritValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerForceNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerForceValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerForceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerRapiditeNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerRapiditeValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerRapiditeValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerResNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerResValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerResValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerVieNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerVieValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerVieValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerDeplacementValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));

        spinnerChanceNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerChanceValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerChanceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerCharismeNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerCharismeValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerCharismeValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEnduranceNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerEnduranceValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerEnduranceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEsquiveNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerEsquiveValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerEsquiveValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerFurtiviteNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerFurtiviteValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerFurtiviteValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerHabiliteNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerHabiliteValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerHabiliteValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerIntelligenceNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerIntelligenceValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerIntelligenceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerPrecisionNumberDe.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5, 0));
        spinnerPrecisionValueDe.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(Dee));
        spinnerPrecisionValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));

        System.out.println("front.view.adminView.RaceAdminOverviewController.initialize(), raceBox.getvalue(): " + raceBox.getValue());

        raceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                Race race = main.getRaces().get(newValue.intValue());
                setAllSpinner(race);
                setDescription(race);
                setDescriptionPhysique(race);
                classeConseiller.setValue(race.getBestClass());
                lvlPlayer.setValue(race.getAccess());
            }
        });
        lvlPlayer.getItems().addAll(lvlPlayerList);

        

    }
    
    
    
    private void setDescription(Race race){
        description.setText(race.getDescription());
    }

    private void setDescriptionPhysique(Race race){
        descriptionPhysique.setText(race.getApparence());
    }
    
    private void setAllSpinner(Race race) {
        setDexteriteSpinner(race.getStatBrute().getDexterite());
        setEspritSpinner(race.getStatBrute().getEsprit());
        setForceSpinner(race.getStatBrute().getForce());
        setRapiditeSpinner(race.getStatBrute().getRapidite());
        setResistanceSpinner(race.getStatBrute().getResistance());
        setVieSpinner(race.getStatBrute().getVie());
        setDeplacementSpinner(race.getStatBrute().getDeplacement());

        setChanceSpinner(race.getStatPerception().getChance());
        setCharismeSpinner(race.getStatPerception().getCharisme());
        setEnduranceSpinner(race.getStatPerception().getEndurance());
        setEsquiveSpinner(race.getStatPerception().getEsquive());
        setFurtiviteSpinner(race.getStatPerception().getFurtivite());
        setHabiliteSpinner(race.getStatPerception().getHabilite());
        setIntelligenceSpinner(race.getStatPerception().getIntelligence());
        setPrecisionSpinner(race.getStatPerception().getPrecision());
    }

    private void setDexteriteSpinner(Dexterite dex) {
        spinnerDexValue.getValueFactory().setValue(dex.getValue());
        if (dex.getDe() != null) {
            spinnerDexValueDe.getValueFactory().setValue(dex.getDe().getType());
            spinnerDexNumberDe.getValueFactory().setValue(dex.getDe().getNumber());
        }
    }

    private void setEspritSpinner(Esprit esprit) {
        spinnerEspritValue.getValueFactory().setValue(esprit.getValue());
        if (esprit.getDe() != null) {
            spinnerEspritValue.getValueFactory().setValue(esprit.getDe().getType());
            spinnerEspritValue.getValueFactory().setValue(esprit.getDe().getNumber());
        }
    }

    private void setForceSpinner(Force force) {
        spinnerForceValue.getValueFactory().setValue(force.getValue());
        if (force.getDe() != null) {
            spinnerForceValueDe.getValueFactory().setValue(force.getDe().getType());
            spinnerForceNumberDe.getValueFactory().setValue(force.getDe().getNumber());
        }
    }
    

    private void setRapiditeSpinner(Rapidite rapidite) {
        spinnerRapiditeValue.getValueFactory().setValue(rapidite.getValue());
        if (rapidite.getDe() != null) {

            spinnerRapiditeValueDe.getValueFactory().setValue(rapidite.getDe().getType());
            spinnerRapiditeNumberDe.getValueFactory().setValue(rapidite.getDe().getNumber());
        }
    }

    private void setResistanceSpinner(Resistance res) {
        spinnerResValue.getValueFactory().setValue(res.getValue());
        if (res.getDe() != null) {

            spinnerResValueDe.getValueFactory().setValue(res.getDe().getType());
            spinnerResNumberDe.getValueFactory().setValue(res.getDe().getNumber());
        }
    }

    private void setVieSpinner(Vie vie) {
        spinnerVieValue.getValueFactory().setValue(vie.getValue());
        if (vie.getDe() != null) {

            spinnerVieValueDe.getValueFactory().setValue(vie.getDe().getType());
            spinnerVieNumberDe.getValueFactory().setValue(vie.getDe().getNumber());
        }
    }

    private void setDeplacementSpinner(Deplacement dep) {
        spinnerDeplacementValue.getValueFactory().setValue(dep.getValue());
    }

    private void setChanceSpinner(Chance chance) {
        spinnerChanceValue.getValueFactory().setValue(chance.getValue());
        if (chance.getDe() != null) {
            spinnerChanceValueDe.getValueFactory().setValue(chance.getDe().getType());
            spinnerChanceNumberDe.getValueFactory().setValue(chance.getDe().getNumber());
        }
    }

    private void setCharismeSpinner(Charisme charisme) {
        spinnerCharismeValue.getValueFactory().setValue(charisme.getValue());
        if (charisme.getDe() != null) {

            spinnerCharismeValueDe.getValueFactory().setValue(charisme.getDe().getType());
            spinnerCharismeNumberDe.getValueFactory().setValue(charisme.getDe().getNumber());
        }
    }

    private void setEnduranceSpinner(Endurance endurance) {
        spinnerEnduranceValue.getValueFactory().setValue(endurance.getValue());
        if (endurance.getDe() != null) {

            spinnerEnduranceValueDe.getValueFactory().setValue(endurance.getDe().getType());
            spinnerEnduranceNumberDe.getValueFactory().setValue(endurance.getDe().getNumber());
        }
    }

    private void setEsquiveSpinner(Esquive esq) {
        spinnerEsquiveValue.getValueFactory().setValue(esq.getValue());
        if (esq.getDe() != null) {

            spinnerEsquiveValueDe.getValueFactory().setValue(esq.getDe().getType());
            spinnerEsquiveNumberDe.getValueFactory().setValue(esq.getDe().getNumber());
        }
    }

    private void setFurtiviteSpinner(Furtivite furtivite) {
        spinnerFurtiviteValue.getValueFactory().setValue(furtivite.getValue());
        if (furtivite.getDe() != null) {

            spinnerFurtiviteValueDe.getValueFactory().setValue(furtivite.getDe().getType());
            spinnerFurtiviteNumberDe.getValueFactory().setValue(furtivite.getDe().getNumber());
        }
    }

    private void setHabiliteSpinner(Habilite hab) {
        spinnerHabiliteValue.getValueFactory().setValue(hab.getValue());
        if (hab.getDe() != null) {

            spinnerHabiliteValueDe.getValueFactory().setValue(hab.getDe().getType());
            spinnerHabiliteNumberDe.getValueFactory().setValue(hab.getDe().getNumber());
        }
    }

    private void setIntelligenceSpinner(Intelligence intelligence) {
        spinnerIntelligenceValue.getValueFactory().setValue(intelligence.getValue());
        if (intelligence.getDe() != null) {

            spinnerIntelligenceValueDe.getValueFactory().setValue(intelligence.getDe().getType());
            spinnerIntelligenceNumberDe.getValueFactory().setValue(intelligence.getDe().getNumber());
        }
    }

    private void setPrecisionSpinner(Precision prec) {
        spinnerPrecisionValue.getValueFactory().setValue(prec.getValue());
        if (prec.getDe() != null) {

            spinnerPrecisionValueDe.getValueFactory().setValue(prec.getDe().getType());
            spinnerPrecisionNumberDe.getValueFactory().setValue(prec.getDe().getNumber());
        }
    }

    public void setRacesList(Map<String, Race> races) {
        List<String> list = new ArrayList<>(races.keySet());
        racesList = FXCollections.observableList(list);
    }
    public void setClassesList(Map<String, Classe> classes) {
        List<String> list = new ArrayList<>(classes.keySet());
        classeList = FXCollections.observableList(list);

    }

    public void setMainApp(Main main) {
        this.main = main;
        setRacesList(main.getRaces());
        setClassesList(main.getClasses());
        raceBox.getItems().addAll(racesList);
        classeConseiller.getItems().addAll(classeList);

    }

}
