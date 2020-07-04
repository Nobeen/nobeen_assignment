/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameerassignment_1;


import Model.DAO;
import java.io.File;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static sameerassignment_1.SameerAssignment_1.u;

public class FXMLController {
    
     @FXML private Text actiontarget;
     @FXML private TextField username;
     @FXML private TextField passwordField;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        
        Stage stage = null;
        Parent myNewScene = null;
        
        DAO d = new DAO();
        try{
            
            String user = username.getText();
            String pass = passwordField.getText();
            
            
        if(d.login(user,pass)){
            
            String role = u.getRole();
            
            if(role.equals("Manager")){
            
                stage = (Stage) username.getScene().getWindow();
                URL url = new File("src/Manager/Dashboard.fxml").toURI().toURL();
                //URL screen = getClass().getClassLoader().getResource("Dashboard.fxml");
                myNewScene = FXMLLoader.load(url);
                Scene scene = new Scene(myNewScene);
                stage.setScene(scene);
                stage.setTitle("My New Scene");
                stage.show();
            }else{
            
                JOptionPane.showMessageDialog(null, "You are a Clerk");
            
            }
        
        
        }
        
        }catch(Exception ex){
        
            System.out.println(ex);
        }
        
    }
    
}
