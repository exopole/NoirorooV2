/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view.adminView;

import NoirorooApp.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author exopole
 */
public class AdminController implements Initializable {

    @FXML
    Button goToRace = new Button("Race");
    
    @FXML
    Button goToClasse = new Button("Classe");
    
    Main main;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goToRaceAdminView(){
        System.out.println("Go to admin race view");
        main.getCurrent_Scene().setRoot(main.getPanRace());
        main.getStage().setScene(main.getCurrent_Scene());
        System.out.println(".handle() + setScene");
        main.getStage().setFullScreen(true);
        main.getStage().show();
    }

    
    
    @FXML
    public void noirorooInteraction(){
        System.out.println("noiroroo view");
        main.getPanRace().setBottom(main.createButtonBar(1, 1));
        System.out.println(".handle() + setBottom");
        main.getCurrent_Scene().setRoot(main.getPanRace());
        main.getStage().setScene(main.getCurrent_Scene());
        System.out.println(".handle() + setScene");
        main.getStage().setFullScreen(true);
        main.getStage().show();
    }

    
}
