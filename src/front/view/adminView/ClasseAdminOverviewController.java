/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view.adminView;

import NoirorooApp.Main;
import informations.Classe;
import informations.Race;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.control.TextArea;
import statistiques.StatistiqueBruteClasse;
import statistiques.StatistiquePerception;
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
public class ClasseAdminOverviewController implements Initializable {

    Main main;
    ObservableList<String> classeList;
    CompetenceAssociationOverviewController competenceController ;
    Classe classe;

    @FXML
    ComboBox<String> classeBox;

    @FXML
    TextArea description;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerDexValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEspritValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerForceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerRapiditeValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerResValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerVieValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerChanceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerCharismeValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEnduranceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerEsquiveValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerFurtiviteValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerHabiliteValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerIntelligenceValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));
        spinnerPrecisionValue.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(-50, 50, 0));

        classeBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                classe = main.getClasses().get(newValue);
                if (classe != null) 
                {
                    setAllSpinner(classe);
                    setDescription(classe);
                }
            }
        });

    }

    @FXML
    private void goToAccueil() {
        main.setScene(main.getPanAccueil());

    }

    @FXML
    private void goToAdmin() {
        main.setScene(main.getPanAdmin());
    }

    @FXML
    private void goToRace() {
        main.setScene(main.getPanAdminRace());
    }

    @FXML
    private void goToCompetences() {
        classe = newClasse();
        System.out.println("front.view.adminView.ClasseAdminOverviewController.goToCompetences(),  classe => " + classe.toString());
        competenceController.setClasse(classe);
        main.setScene(main.getPanAdminCompetenceAssociation());
    }
    
    public String getNom(){
        return classeBox.getValue();
    }
    
    public String getDescription(){
        return description.getText();
    }

    private void setDescription(Classe classe) {
        description.setText(classe.getDescription());
    }

    private void setAllSpinner(Classe classe) {
        setDexteriteSpinner(classe.getStatBrute().getDexterite());
        setEspritSpinner(classe.getStatBrute().getEsprit());
        setForceSpinner(classe.getStatBrute().getForce());
        setRapiditeSpinner(classe.getStatBrute().getRapidite());
        setResistanceSpinner(classe.getStatBrute().getResistance());
        setVieSpinner(classe.getStatBrute().getVie());

        setChanceSpinner(classe.getStatPerception().getChance());
        setCharismeSpinner(classe.getStatPerception().getCharisme());
        setEnduranceSpinner(classe.getStatPerception().getEndurance());
        setEsquiveSpinner(classe.getStatPerception().getEsquive());
        setFurtiviteSpinner(classe.getStatPerception().getFurtivite());
        setHabiliteSpinner(classe.getStatPerception().getHabilite());
        setIntelligenceSpinner(classe.getStatPerception().getIntelligence());
        setPrecisionSpinner(classe.getStatPerception().getPrecision());
    }

    private void setDexteriteSpinner(Dexterite dex) {
        spinnerDexValue.getValueFactory().setValue(dex.getValue());
    }
    
    public Dexterite getDexterite(){
        return new Dexterite((Integer) spinnerDexValue.getValueFactory().getValue());
    }

    private void setEspritSpinner(Esprit esprit) {
        spinnerEspritValue.getValueFactory().setValue(esprit.getValue());
    }
    
    public Esprit getEsprit(){
        return new Esprit((Integer) spinnerEspritValue.getValueFactory().getValue());
    }

    private void setForceSpinner(Force force) {
        spinnerForceValue.getValueFactory().setValue(force.getValue());
    }

    public Force getForce(){
        return new Force((Integer) spinnerForceValue.getValueFactory().getValue());
    }
    
    private void setRapiditeSpinner(Rapidite rapidite) {
        spinnerRapiditeValue.getValueFactory().setValue(rapidite.getValue());
    }

    public Rapidite getRapidite(){
        return new Rapidite((Integer) spinnerRapiditeValue.getValueFactory().getValue());
    }
    
    private void setResistanceSpinner(Resistance res) {
        spinnerResValue.getValueFactory().setValue(res.getValue());
    }

    public Resistance getResistance(){
        return new Resistance((Integer) spinnerResValue.getValueFactory().getValue());
    }
    
    private void setVieSpinner(Vie vie) {
        spinnerVieValue.getValueFactory().setValue(vie.getValue());
    }

    public Vie getVie(){
        return new Vie((Integer) spinnerVieValue.getValueFactory().getValue());
    }
    
    private void setChanceSpinner(Chance chance) {
        spinnerChanceValue.getValueFactory().setValue(chance.getValue());
    }

    public Chance getChance(){
        return new Chance((Integer) spinnerChanceValue.getValueFactory().getValue());
    }
    
    private void setCharismeSpinner(Charisme charisme) {
        spinnerCharismeValue.getValueFactory().setValue(charisme.getValue());
    }

    public Charisme getCharisme(){
        return new Charisme((Integer) spinnerCharismeValue.getValueFactory().getValue());
    }
    
    private void setEnduranceSpinner(Endurance endurance) {
        spinnerEnduranceValue.getValueFactory().setValue(endurance.getValue());
    }

    public Endurance getEndurance(){
        return new Endurance((Integer) spinnerEnduranceValue.getValueFactory().getValue());
    }
    
    private void setEsquiveSpinner(Esquive esq) {
        spinnerEsquiveValue.getValueFactory().setValue(esq.getValue());
    }

    public Esquive getEsquive(){
        return new Esquive((Integer) spinnerEsquiveValue.getValueFactory().getValue());
    }
    
    private void setFurtiviteSpinner(Furtivite furtivite) {
        spinnerFurtiviteValue.getValueFactory().setValue(furtivite.getValue());
    }
    
    public Furtivite getFurtivite(){
        return new Furtivite((Integer) spinnerFurtiviteValue.getValueFactory().getValue());
    }
    
    public void setHabiliteSpinner(Habilite hab) {
        spinnerHabiliteValue.getValueFactory().setValue(hab.getValue());
    }

    public Habilite getHabilite(){
        return new Habilite((Integer) spinnerHabiliteValue.getValueFactory().getValue());
    }
    
    private void setIntelligenceSpinner(Intelligence intelligence) {
        spinnerIntelligenceValue.getValueFactory().setValue(intelligence.getValue());
    }

    public Intelligence getIntelligence(){
        return new Intelligence((Integer) spinnerIntelligenceValue.getValueFactory().getValue());
    }
    
    public void setPrecisionSpinner(Precision prec) {
        spinnerPrecisionValue.getValueFactory().setValue(prec.getValue());
    }

    public Precision getPrecision(){
        return new Precision((Integer) spinnerPrecisionValue.getValueFactory().getValue());
    }
    
    public StatistiqueBruteClasse getStatBrute(){
        StatistiqueBruteClasse statBrute = new StatistiqueBruteClasse();
        
        statBrute.setDexterite(getDexterite());
        statBrute.setEsprit(getEsprit());
        statBrute.setForce(getForce());
        statBrute.setRapidite(getRapidite());
        statBrute.setResistance(getResistance());
        statBrute.setVie(getVie());
        
        return statBrute;
    }
    
    public StatistiquePerception getStatPerception(){
        StatistiquePerception statPerception = new StatistiquePerception();
        
        statPerception.setChance(getChance());
        statPerception.setCharisme(getCharisme());
        statPerception.setEndurance(getEndurance());
        statPerception.setEsquive(getEsquive());
        statPerception.setFurtivite(getFurtivite());
        statPerception.setHabilite(getHabilite());
        statPerception.setIntelligence(getIntelligence());
        statPerception.setPrecision(getPrecision());
        
        return statPerception;
    }
    
    
    
    
    
    
    public void setClassesList(Map<String, Classe> classes) {
        List<String> list = new ArrayList<>(classes.keySet());
        classeList = FXCollections.observableList(list);

    }
    
    

    public void setMainApp(Main main) {
        this.main = main;
        setClassesList(main.getClasses());
        classeBox.getItems().addAll(classeList);

    }
    
    public void setControllerCompetence(CompetenceAssociationOverviewController competenceController){
        this.competenceController = competenceController;
    }

    public Classe newClasse() {
        StatistiqueBruteClasse statBrute = getStatBrute();
        StatistiquePerception statPerception = getStatPerception();
        String nom = getNom();
        String description = getDescription();
        
        Classe classe = new Classe();
        classe.setName(nom);
        classe.setDescription(description);
        classe.setStatBrute(statBrute);
        classe.setStatPerception(statPerception);
        
        return classe;
    }

}
