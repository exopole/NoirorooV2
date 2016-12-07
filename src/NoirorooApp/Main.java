package NoirorooApp;

import parsing.ParsingFile;
import informations.*;
import front.view.*;
import front.view.adminView.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
import java.net.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Main extends Application {

    private Stage stage;

    enum Step {
        race,
        classe,
        competence,
        competenceAssociationClasse,
        competenceAssociationRace
    }

    private Map<String, Race> races = new HashMap<String, Race>();
    private Map<String, Classe> classes = new HashMap<String, Classe>();
    private Map<String, Competence> competences = new HashMap<String, Competence>();
    private ObservableList<Competence> compRace = FXCollections.observableArrayList();
    private ObservableList<Competence> compClasse = FXCollections.observableArrayList();

    RaceOverviewController controllerRace;
    ClasseOverviewController controllerClasse;
    CompetenceOverviewController controllerCompetence;
    PersonnageOverviewController controllerPersonnage;
    AccueilOverviewController controllerAccueil;
    AdminController controllerAdmin;
    RaceAdminOverviewController controllerAdminRace;
    ClasseAdminOverviewController controllerAdminClasse;
    CompetenceAdminOverviewController controllerAdminCompetence;
    CompetenceAssociationClasseOverviewController controllerAdminCompetenceAssociationClasse;
    CompetenceAssociationRaceOverviewController controllerAdminCompetenceAssociationRace;
    CompetenceAssociationOverviewController controllerAdminCompetenceAssociation;

    BorderPane panClasse = new BorderPane();
    BorderPane panRace = new BorderPane();
    BorderPane panCompetence = new BorderPane();
    BorderPane panPersonnage = new BorderPane();
    BorderPane panAccueil = new BorderPane();
    BorderPane panAdmin = new BorderPane();
    BorderPane panAdminRace = new BorderPane();
    BorderPane panAdminClasse = new BorderPane();
    BorderPane panAdminCompetence = new BorderPane();
    BorderPane panAdminCompetenceAssociationClasse = new BorderPane();
    BorderPane panAdminCompetenceAssociationRace = new BorderPane();
    BorderPane panAdminCompetenceAssociation = new BorderPane();

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

        List listClasse = new ArrayList();
        if (classes.size() > 0 && classes.get(0) != null) {
            Map<String, Integer> competenceClasse = classes.get(0).getCompetences();
            for (Map.Entry<String, Integer> entry : competenceClasse.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                listClasse.add(new Competence(competences.get(key), value));

            }
        }
        compClasse = FXCollections.observableArrayList(listClasse);

        List listRace = new ArrayList();
        if (races.size() > 0) {
            Map<String, Integer> competenceRace = races.get(1).getCompetences();
            for (Map.Entry<String, Integer> entry : competenceRace.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                listRace.add(new Competence(competences.get(key), value));

            }
        }
        compRace = FXCollections.observableArrayList(listRace);

        controllerCompetence = loadfxml.getController();
        controllerCompetence.setCompetence(compRace, compClasse);

        //Personnage
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/PersonnageOverview.fxml"));
        GridPane personnageGridPane = (GridPane) loadfxml.load();
        controllerPersonnage = loadfxml.getController();
        if (classes.size() > 0 && races.size() > 0) {
            controllerPersonnage.setPersonnage(controllerRace.getRace(), controllerClasse.getClasse(), controllerCompetence.getCompetenceAll());
        } else {
            System.out.println("NoirorooApp.Main.start() => on ne peut pas instancier le personnage car il n'y a ni classes ni races");
        }
        panPersonnage.setCenter(personnageGridPane);
        panPersonnage.setBottom(createButtonBar(current_step, lastStep));
        // Page d'accueil
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/AccueilOverview.fxml"));
        Pane accueilPaneCenter = (Pane) loadfxml.load();
        panAccueil.setCenter(accueilPaneCenter);
        controllerAccueil = loadfxml.getController();

        //Page Admin
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/Admin.fxml"));
        Pane paneAdminCenter = (Pane) loadfxml.load();
        panAdmin.setCenter(paneAdminCenter);
        controllerAdmin = loadfxml.getController();
        controllerAdmin.setMain(this);

        //Page AdminRace
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/RaceAdminOverview.fxml"));
        panAdminRace = (BorderPane) loadfxml.load();
        controllerAdminRace = loadfxml.getController();
        controllerAdminRace.setMainApp(this);

        //Page AdminClasse
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/ClasseAdminOverview.fxml"));
        panAdminClasse = (BorderPane) loadfxml.load();
        controllerAdminClasse = loadfxml.getController();
        controllerAdminClasse.setMainApp(this);

        //Page Admin competence
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/CompetenceAdminOverview.fxml"));
        panAdminCompetence = (BorderPane) loadfxml.load();
        controllerAdminCompetence = loadfxml.getController();
        controllerAdminCompetence.setCompetenceList(competences);

        //Page Admin competence association classe
        /*
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/CompetenceAssociationClasseOverview.fxml"));
        panAdminCompetenceAssociationClasse = (BorderPane) loadfxml.load();
        controllerAdminCompetenceAssociationClasse = loadfxml.getController();
        controllerAdminCompetenceAssociationClasse.setCompetenceList(competences);

        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/CompetenceAssociationRaceOverview.fxml"));
        panAdminCompetenceAssociationRace = (BorderPane) loadfxml.load();
        controllerAdminCompetenceAssociationRace = loadfxml.getController();
        controllerAdminCompetenceAssociationRace.setCompetenceList(competences);
*/  
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("/front/view/adminView/CompetenceAssociationOverview.fxml"));
        panAdminCompetenceAssociation = (BorderPane) loadfxml.load();
        controllerAdminCompetenceAssociation = loadfxml.getController();
        controllerAdminCompetenceAssociation.setMainApp(this);
        controllerAdminCompetenceAssociation.setCompetenceList(competences);
        controllerAdminClasse.setControllerCompetence(controllerAdminCompetenceAssociation);
        controllerAdminRace.setControllerCompetence(controllerAdminCompetenceAssociation);

        // ajout des boutons 
        /*
        loadfxml = new FXMLLoader();
        loadfxml.setLocation(Main.class.getResource("../front/view/button/Button.fxml"));
        AnchorPane buttonAnchorPane = (AnchorPane) loadfxml.load();
        panPersonnage.setBottom(buttonAnchorPane);
         */
        //primaryStage.setScene(new Scene(pan));
        current_Scene = new Scene(panAdminClasse);
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

        if (listOfFilesRace != null) {
            for (int i = 0; i < listOfFilesRace.length; i++) {
                Race newRace = new Race(listOfFilesRace[i].getPath());
                races.put(newRace.getName(), newRace);
            }

        }
        if (listOfFilesClasse != null) {
            for (int i = 0; i < listOfFilesClasse.length; i++) {
                Classe newClasse = new Classe(listOfFilesClasse[i].getPath());
                classes.put(newClasse.getName(), newClasse);
            }
        }

        /*
        try {
            JSONObject objWrite = new JSONObject();
            Vector<String> fileContenant = ParsingFile.readFile("Competence/competences.txt");
            int test = 4;
            for (String comp : fileContenant) {
                Competence compTmp = new Competence(comp);
                competences.addElement(compTmp);
                objWrite.put(test++, compTmp.getJSONObject());

            }
            FileWriter file = new FileWriter("Competence/test.json");
            file.write(objWrite.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            System.out.println("NoirorooApp.Main.<init>(), le fichier Competence/competence.txt n'a pas été trouver");
        }

         */
        /////////// Try competences json ///////////////////
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("Competence/competences.json"));
            JSONObject jsonObject = (JSONObject) obj;

            for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                System.out.println(key);
                System.out.println(jsonObject.get(key).toString());
                Competence newComp = new Competence(jsonObject.get(key).toString(), true);
                competences.put(newComp.getNom(), newComp);
            }

        } catch (Exception e) {
            System.out.println("NoirorooApp.Main.<init>() error : " + e.getMessage());
        }

    }

    public Map<String, Race> getRaces() {
        return races;
    }

    public Map<String, Classe> getClasses() {
        return classes;
    }

    public ObservableList<Competence> getCompClasse() {
        return compClasse;
    }

    public ObservableList<Competence> getCompRace() {
        return compRace;
    }

    public Map<String, Competence> getCompetences() {
        return competences;
    }

    public void prepareCompetence() {
        compClasse.clear();
        Map<String, Integer> competenceClasse = controllerClasse.getClasse().getCompetences();
        List listClasse = new ArrayList();
        List listRace = new ArrayList();
        for (Map.Entry<String, Integer> entry : competenceClasse.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            listClasse.add(new Competence(competences.get(key), value));
        }

        compClasse = FXCollections.observableArrayList(listClasse);

        compRace.clear();
        Map<String, Integer> competenceRace = controllerRace.getRace().getCompetences();
        listRace.clear();
        for (Map.Entry<String, Integer> entry : competenceRace.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            listRace.add(new Competence(competences.get(key), value));
        }

        compRace = FXCollections.observableArrayList(listRace);

        System.out.println("NoirorooApp.Main.start() : race => " + controllerRace.getRace().getName() + ", Classe => " + controllerClasse.getClasse().getName());
        controllerCompetence.setCompetence(compRace, compClasse);
    }

    public void preparePersonnage() {
        controllerPersonnage.setPersonnage(controllerRace.getRace(), controllerClasse.getClasse(), controllerCompetence.getCompetenceChoisies());
    }

    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return stage;
    }

    public Button createButtonWithScene(Scene scene, int step) {
        Button button = new Button();
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(".handle() + createButtonWithScene");

                stage.setScene(scene);

                current_step = step;
                if (step < lastStep) {
                    lastStep = step;
                }

            }
        });
        return button;
    }

    public Button createButtonWithBorderPane(BorderPane pane, int step) {
        Button button = new Button();
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (step == 3) {
                    prepareCompetence();
                }

                if (step == 4) {
                    preparePersonnage();
                }

                System.out.println(".handle() + createButtonWithSBorderPane");
                current_step = step;
                System.out.println(".handle() + step => " + step);
                if (step > lastStep) {
                    lastStep = step;
                }
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

    /*
    public AnchorPane createButtonBarAdmin(Step step) {
        AnchorPane bar = new AnchorPane();
        HBox hb = new HBox();
        hb.getChildren().add(getButton(panAccueil, "Acceuil"));
        hb.getChildren().add(getButton(panAdmin, "Admin"));

        if (step == Step.classe) {
            hb.getChildren().add(getButton(panAdminRace, "Race"));
            hb.getChildren().add(getButton(panAdminCompetenceAssociation, "Competences"));
        } else if (step == Step.race) {
            hb.getChildren().add(getButton(panAdminClasse, "Classe"));
            hb.getChildren().add(getButton(panAdminCompetenceAssociation, "Competences"));
        } else if (step == Step.competenceAssociation) {
            hb.getChildren().add(getButton(panAdminRace, "Race"));
            hb.getChildren().add(getButton(panAdminCompetenceAssociation, "Classe"));
            hb.getChildren().add(getButton(panAdmin, "Enregistrer"));

        } else if (step == Step.competence) {
            hb.getChildren().add(getButton(panAdminRace, "Race"));
            hb.getChildren().add(getButton(panAdminClasse, "Classe"));
        }

        bar.getChildren().add(hb);
        AnchorPane.setRightAnchor(hb, 0.0);
        return bar;
    }
     */
    public AnchorPane createButtonBar(int currentStep, int lastStep) {
        AnchorPane bar = new AnchorPane();
        HBox hb = new HBox();
        hb.getChildren().add(getButton(panAccueil, "Acceuil"));
        for (int i = 1; i <= lastStep; i++) {
            if (i != currentStep) {
                hb.getChildren().add(createButtonFromStep(i));
            }
        }
        if (currentStep == lastStep) {
            hb.getChildren().add(createButtonFromStep(lastStep + 1));

        }

        bar.getChildren().add(hb);
        AnchorPane.setRightAnchor(hb, 0.0);
        return bar;
    }

    public Button getButton(BorderPane pane, String name) {
        Button button = new Button();
        button.setText(name);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                current_Scene.setRoot(pane);
                stage.setScene(current_Scene);
                System.out.println(".handle() + setScene");
                stage.setFullScreen(true);
                stage.show();
            }
        });
        return button;
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

    public AccueilOverviewController getControllerAccueil() {
        return controllerAccueil;
    }

    public AdminController getControllerAdmin() {
        return controllerAdmin;
    }

    public CompetenceAssociationOverviewController getControllerAdminCompetenceAssociation() {
        return controllerAdminCompetenceAssociation;
    }
    
    

    public BorderPane getPanAccueil() {
        return panAccueil;
    }

    public BorderPane getPanAdmin() {
        return panAdmin;
    }

    public BorderPane getPanAdminClasse() {
        return panAdminClasse;
    }

    public BorderPane getPanAdminRace() {
        return panAdminRace;
    }

    public BorderPane getPanAdminCompetence() {
        return panAdminCompetence;
    }

    public BorderPane getPanAdminCompetenceAssociationClasse() {
        return panAdminCompetenceAssociationClasse;
    }

    public BorderPane getPanAdminCompetenceAssociationRace() {
        return panAdminCompetenceAssociationRace;
    }

    public BorderPane getPanAdminCompetenceAssociation() {
        return panAdminCompetenceAssociation;
    }
    
    

    public BorderPane getPanAdminFromStep(Step step) {
        switch (step) {
            case classe:
                return getPanAdminClasse();
            case race:
                return getPanAdminRace();
            case competence:
                return getPanAdminCompetence();
            case competenceAssociationClasse:
                return getPanAdminCompetenceAssociationClasse();
            case competenceAssociationRace:
                return getPanAdminCompetenceAssociationRace();
            default:
                return null;
        }
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

    public void setScene(BorderPane pane) {
        current_Scene.setRoot(pane);
        stage.setScene(current_Scene);
        System.out.println(".handle() + setScene");
        stage.setFullScreen(true);
        stage.show();
        controllerPersonnage.setSize(stage.getWidth(), stage.getHeight());

    }

    public void setSceneWithBarButton(BorderPane pane) {
        pane.setBottom(createButtonBar(current_step, lastStep));
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
