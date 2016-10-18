package NoirorooApp;

import java.io.File;
import java.util.Vector;
import front.view.*;
import informations.*;
import java.net.URL;
import parsing.*;

import java.util.ArrayList;
import java.util.List;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Main extends Application {

    private Stage stage;

    private Vector<Race> races = new Vector<Race>();
    private Vector<Classe> classes = new Vector<Classe>();
    private Vector<Competence> competences = new Vector<Competence>();
    private ObservableList<Competence> compRace = FXCollections.observableArrayList();
    private ObservableList<Competence> compClasse = FXCollections.observableArrayList();

    DescriptionOverviewController controllerDescription;
    StatistiqueOverviewController controllerStatistique;
    RaceOverviewController controllerRace;
    ClasseOverviewController controllerClasse;
    CompetenceOverviewController controllerCompetence;
    PersonnageOverviewController controllerPersonnage;
    AccueilOverviewController controllerAccueil;

    BorderPane panClasse = new BorderPane();
    BorderPane panRace = new BorderPane();
    BorderPane panCompetence = new BorderPane();
    BorderPane panPersonnage = new BorderPane();
    BorderPane panAccueil = new BorderPane();
    
    Scene current_Scene;

    int current_step = 1;
    int lastStep = 1;
    private boolean israce = true;

    private String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi cupiditate. Voluptatum ducimus voluptates voluptas?";

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ///////////////////////// essai avec une seule page ///////
        FXMLLoader loadfxml = new FXMLLoader();
        //race 
        //FXMLLoader raceOverview = new FXMLLoader();
        URL layoutURL = getClass().getResource("/front/view/RaceOverview.fxml");
                System.out.println("NoirorooApp.Main.start() ===> " + layoutURL);

        loadfxml.setLocation(layoutURL);
        GridPane raceGridPane = (GridPane) loadfxml.load();
        controllerRace = loadfxml.getController();
        controllerRace.setMainApp(this);
        panRace.setCenter(raceGridPane);
        panRace.setBottom(createButtonBar(current_step, lastStep));
        //classe

        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/ClasseOverview.fxml"));
        GridPane classeGridPane = (GridPane) loadfxml.load();
        controllerClasse = loadfxml.getController();
        controllerClasse.setMainApp(this);
        panClasse.setCenter(classeGridPane);
        //competence
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/CompetencesOverview.fxml"));
        panCompetence.setCenter((Pane) loadfxml.load());

        Vector<Vector<String>> competenceClasse = classes.get(0).getCompetences();
        List list = new ArrayList();
        for (Vector<String> comp : competenceClasse) {
            list.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compClasse = FXCollections.observableArrayList(list);

        Vector<Vector<String>> competenceRace = races.get(1).getCompetences();
        list.clear();
        for (Vector<String> comp : competenceRace) {
            list.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compRace = FXCollections.observableArrayList(list);

        System.out.println("NoirorooApp.Main.start() : compRace[0] => " + compRace.get(0).getNom());
        controllerCompetence = loadfxml.getController();
        controllerCompetence.setCompetence(compRace, compClasse);

        //Personnage
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/PersonnageOverview.fxml"));
        GridPane personnageGridPane = (GridPane) loadfxml.load();
        controllerPersonnage = loadfxml.getController();
        controllerPersonnage.setPersonnage(controllerRace.getRace(), controllerClasse.getClasse(), controllerCompetence.getCompetenceAll());
        panPersonnage.setCenter(personnageGridPane);
        panPersonnage.setBottom(createButtonBar(current_step, lastStep));
        // Page d'accueil
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/AccueilOverview.fxml"));
        Pane accueilPane = (Pane) loadfxml.load();
        panAccueil.setCenter(accueilPane);
        controllerAccueil = loadfxml.getController();
        

        // ajout des boutons 
        /*
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("../front/view/button/Button.fxml"));
        AnchorPane buttonAnchorPane = (AnchorPane) loadfxml.load();
        panPersonnage.setBottom(buttonAnchorPane);
        */
        
     
        //primaryStage.setScene(new Scene(pan));
        current_Scene = new Scene(panAccueil);
        controllerAccueil.setMainApp(this);
        stage.setScene(current_Scene);
        stage.setFullScreen(true);

        stage.show();

        //  controllerCompetence.setSizeWidth(primaryStage.getWidth());
        controllerPersonnage.setSize(stage.getWidth(), stage.getHeight());
    }

    public Main() {
        File[] listOfFilesRace = (new File("RaceJSON/")).listFiles();
        File[] listOfFilesClasse = (new File("ClasseJSON/")).listFiles();

        for (int i = 0; i < listOfFilesRace.length; i++) {
            races.add(new Race(listOfFilesRace[i].getPath()));
        }

        for (int i = 0; i < listOfFilesClasse.length; i++) {
            classes.add(new Classe(listOfFilesClasse[i].getPath()));
        }

        competences = new Vector<Competence>();
        try {
            Vector<String> fileContenant = ParsingFile.readFile("Competence/competences.txt");
            for (String comp : fileContenant) {
                competences.addElement(new Competence(comp));
            }
        } catch (Exception e) {
            System.out.println("NoirorooApp.Main.<init>(), le fichier Competence/competence.txt n'a pas été trouver");
        }

    }

    public Vector<Race> getRaces() {
        return races;
    }

    public Vector<Classe> getClasses() {
        return classes;
    }

    public ObservableList<Competence> getCompClasse() {
        return compClasse;
    }

    public ObservableList<Competence> getCompRace() {
        return compRace;
    }
    
    public void prepareCompetence(){
        compClasse.clear();
        Vector<Vector<String>> competenceClasse = controllerClasse.getClasse().getCompetences();
        List listClasse = new ArrayList();
        List listRace= new ArrayList();
        for (Vector<String> comp : competenceClasse) {
            listClasse.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compClasse = FXCollections.observableArrayList(listClasse);

        compRace.clear();
        Vector<Vector<String>> competenceRace = controllerRace.getRace().getCompetences();
        listRace.clear();
        for (Vector<String> comp : competenceRace) {
            listRace.add(new Competence(competences.get(Integer.parseInt(comp.get(0))), Integer.parseInt(comp.get(0))));
        }

        compRace = FXCollections.observableArrayList(listRace);

        System.out.println("NoirorooApp.Main.start() : race => " + controllerRace.getRace().getName() + ", Classe => " + controllerClasse.getClasse().getName());
        controllerCompetence.setCompetence(compRace, compClasse);
    }
    
    public void preparePersonnage(){
        controllerPersonnage.setPersonnage(controllerRace.getRace(), controllerClasse.getClasse(), controllerCompetence.getCompetenceChoisies());
    }

    public void setPage2Race(int index) {
        controllerDescription.setDescript(races.get(index), competences);

    }

    public void setPage2Classe(int index) {
        controllerDescription.setDescript(classes.get(index), competences);
    }

    public void emptyPhysique() {
        controllerDescription.emptyPhysique();
    }

    public Vector<Competence> getCompetences() {
        return competences;
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return stage;
    }
    
    public Button createButtonWithScene(Scene scene, int step){
        Button button = new Button();
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(".handle() + createButtonWithScene");
                
                stage.setScene(scene);
                
                current_step = step;
                if (step < lastStep)
                    lastStep = step;
                

            }
        });
        return button;
    }
    public Button createButtonWithBorderPane(BorderPane pane, int step){
        Button button = new Button();
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (step == 3)
                    prepareCompetence();
                
                if (step == 4) {
                    preparePersonnage();
                }
                
                System.out.println(".handle() + createButtonWithSBorderPane");
                current_step = step;
                System.out.println(".handle() + step => " + step);
                if (step > lastStep)
                    lastStep = step;
                pane.setBottom(createButtonBar(current_step, lastStep));
                System.out.println(".handle() + setBottom");
                current_Scene.setRoot(pane);
                stage.setScene(current_Scene);
                System.out.println(".handle() + setScene");
                stage.setFullScreen(true);
                stage.show();
               controllerPersonnage.setSize(stage.getWidth(), stage.getHeight());

            }
        });
        return button;
    }

    public Button createButtonFromStep(int etape) {
        Button button = new Button();

        switch (etape) {
            case 1:
                
                button = createButtonWithBorderPane(panRace, etape);
                button.setText("Race");
                break;
            case 2:
                button = createButtonWithBorderPane(panClasse, etape);
                button.setText("Classe");
                break;
            case 3:
                
                button = createButtonWithBorderPane(panCompetence, etape);                
                button.setText("Competence");
                break;
            case 4:
                button = createButtonWithBorderPane(panPersonnage, etape);
                button.setText("Personnage");
                break;
            case 5:
                button = button;
                button.setText("Compiler");
                break;
            default:
                button = null;
    
        }

        return button;
    }
    
    public AnchorPane createButtonBar(int currentStep, int lastStep){
        AnchorPane bar = new AnchorPane();
        HBox hb = new HBox();
        for (int i = 1; i <= lastStep; i++) {
            if (i != currentStep)
                hb.getChildren().add(createButtonFromStep(i));
        }
        if (currentStep == lastStep) {
            hb.getChildren().add(createButtonFromStep(lastStep + 1));

        }
        
        bar.getChildren().add(hb);
        AnchorPane.setRightAnchor(hb, 0.0);
        return bar;
    }

  

    public ClasseOverviewController getControllerClasse() {
        return controllerClasse;
    }

    public CompetenceOverviewController getControllerCompetence() {
        return controllerCompetence;
    }

    public PersonnageOverviewController getControllerPersonnage() {
        return controllerPersonnage;
    }

    public RaceOverviewController getControllerRace() {
        return controllerRace;
    }

    public Scene getCurrent_Scene() {
        return current_Scene;
    }

    public int getCurrent_step() {
        return current_step;
    }

    public int getLastStep() {
        return lastStep;
    }

    public void setLastStep(int lastStep) {
        this.lastStep = lastStep;
    }

    public Stage getStage() {
        return stage;
    }
    
    public void setSceneShow(BorderPane pane){
        
        pane.setBottom(createButtonBar(current_step, lastStep));
        System.out.println(".handle() + setBottom");
        current_Scene.setRoot(pane);
        stage.setScene(current_Scene);
        System.out.println(".handle() + setScene");
        stage.setFullScreen(true);
        stage.show();
       controllerPersonnage.setSize(stage.getWidth(), stage.getHeight());

    }

    public BorderPane getPanClasse() {
        return panClasse;
    }

    public BorderPane getPanRace() {
        return panRace;
    }

    public BorderPane getPanCompetence() {
        return panCompetence;
    }

    public BorderPane getPanPersonnage() {
        return panPersonnage;
    }
    
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
