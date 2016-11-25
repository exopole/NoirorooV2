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
    Button raceButton = new Button("Race");
    
    @FXML
    Button classeButton = new Button("Classe");
    
    @FXML
    Button competenceButton = new Button("Competence");
    
    Main main;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void goToRace(){
        System.out.println("Go to admin race view");
        main.setScene(main.getPanAdminRace());
    }

    
    
    @FXML
    public void goToClasse(){
        System.out.println("noiroroo view");
        main.setScene(main.getPanAdminClasse());
    }

    @FXML
    public void goToCompetence(){
        System.out.println("noiroroo view");
        main.setScene(main.getPanAdminCompetence());
    } 
    
    public void setMain(Main main){
        this.main = main;
    }
}
