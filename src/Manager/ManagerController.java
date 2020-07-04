/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Faizan
 */
public class ManagerController {

    
    Stage stage = null;
    Parent myNewScene = null;
    
    @FXML Button Rooms_btn;
    
    public void handleOpenAllRooms(ActionEvent event) throws IOException{
    
        stage = (Stage) Rooms_btn.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("/Rooms/AllRooms.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("All Rooms");
        stage.show();
    
        
    }
    
    public void handleOpenAllBookings(ActionEvent event) throws IOException{
    
        stage = (Stage) Rooms_btn.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("/Bookings/AllBookings.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("All Bookings");
        stage.show();
    
        
    }
    
    public void handleOpenAllUsers(ActionEvent event) throws IOException{
    
        stage = (Stage) Rooms_btn.getScene().getWindow();
        myNewScene = FXMLLoader.load(getClass().getResource("/Users/AllUsers.fxml"));
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("All Users");
        stage.show();
    
        
    }
    
    
}
