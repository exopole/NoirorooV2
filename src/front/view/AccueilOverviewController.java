/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front.view;

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
public class AccueilOverviewController implements Initializable {

    @FXML
    Button administrateur = new Button("Administrateur");
    
    @FXML
    Button noiroroo = new Button("noiroroo");
    
    Main main;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setMainApp(Main main) {
        this.main = main;
    }

    
    @FXML
    public void administrateurInteraction(){
        System.out.println("administrateur view");
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
