/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rooms;

import Model.Categories;
import Model.DAO;
import Model.RoomsModel;
import Screens.CustomList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;




public class RoomsController implements Initializable {

    
    @FXML TableView Rooms;
    
    Stage stage = null;
    Parent myNewScene = null;
    Button[] btn;
    CustomList<RoomsModel> RoomsList ;
    @FXML ComboBox categoies;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
       DAO dao = new DAO();
       
        System.out.println(url);
        
       RoomsList = dao.getAllRooms();
       try{
            btn = new Button[RoomsList.size()];
           
            for(int i=0;i<RoomsList.size();i++){

                btn[i]  = new Button();
                btn[i].setText("Delete");
                btn[i].setOnAction(this::handleDeleteRoom);
                ((RoomsModel)RoomsList.get(i)).setButton(btn[i]);
            }
           
            ObservableList ob = FXCollections.observableArrayList();
            
            for(int i=0;i<RoomsList.size();i++){
                
                ob.add(RoomsList.get(i));
            
            }
            
           
            Rooms.setItems(ob);
       }catch(Exception ex){
       
           System.out.println(ex.getMessage());
           
       }
        
       
       try{
       
            ArrayList<Categories> temp = dao.getAllRoomsCategories();
            
            ObservableList ob =  FXCollections.observableArrayList();
            
            
            
            for(int i=0;i<temp.size();i++){
            
                ob.add(temp.get(i).getName());
                
            }
            
            
            categoies.setItems(ob);

            
            
           
       
       }catch(Exception ex){
       
       
       }
       
       
        
    }    
    
    @FXML
    public void handlerAddRooms(ActionEvent event){
        
        
        try {
            stage = (Stage) Rooms.getScene().getWindow();
            //URL url = new File("src/Rooms/AddRoom.fxml").toURI().toURL();
            URL url = getClass().getResource("/Rooms/AddRoom.fxml");
            
            myNewScene = FXMLLoader.load(url);
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("Add Room");
            stage.show();
            
           

            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    @FXML TextField roomId;
    
    
    public void handlerAddRoomsConfirm(ActionEvent event){
        
        try {
    
            DAO dao = new DAO();
            System.out.println("In here");
            if(dao.isUnique(roomId.getText())==0){
            
                if(categoies.getItems().size()>0){
                    
                    int index = categoies.getSelectionModel().getSelectedIndex();
                    if(dao.insert(roomId.getText(),Integer.parseInt(((RoomsModel)RoomsList.get(index)).getId()))==1){

                        JOptionPane.showMessageDialog(null, "Room Added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
                        stage = (Stage) roomId.getScene().getWindow();
                        myNewScene = FXMLLoader.load(getClass().getResource("/Rooms/AllRooms.fxml"));
                        Scene scene = new Scene(myNewScene);
                        stage.setScene(scene);
                        stage.setTitle("All Room");
                        stage.show();

                    }

                }else{

                    JOptionPane.showMessageDialog(null, "Please Select Category", "OOPS!!",JOptionPane.INFORMATION_MESSAGE);
                    stage = (Stage) roomId.getScene().getWindow();
                    myNewScene = FXMLLoader.load(getClass().getResource("/Rooms/AllRooms.fxml"));
                    Scene scene = new Scene(myNewScene);
                    stage.setScene(scene);
                    stage.setTitle("All Room");
                    stage.show();


                }
            }else{
                System.out.println("Oops!!");
                JOptionPane.showMessageDialog(null,"Room Already Registered");
            }
            
            
           
            
        } catch (IOException ex) {
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    public void handleDeleteRoom(ActionEvent event){
    
        DAO d = new DAO();
        for(int i=0;i<btn.length;i++){
            
            if(event.getSource() == btn[i])
            {
                System.out.println("Button "+(i+1));
                
                if(d.deleteRoom(((RoomsModel)RoomsList.get(i)).getId())==1){
                    
                    JOptionPane.showMessageDialog(null, "Room Deleted ","Success", JOptionPane.INFORMATION_MESSAGE);
                    RoomsList = d.getAllRooms();
                    try{
                        btn = new Button[RoomsList.size()];

                        for(int ii=0;ii<RoomsList.size();ii++){

                            btn[ii]  = new Button();
                            btn[ii].setText("Delete");
                            btn[ii].setOnAction(this::handleDeleteRoom);
                          ((RoomsModel)RoomsList.get(ii)).setButton(btn[ii]);
                        }
           
                        ObservableList ob = FXCollections.observableArrayList();
            
                        for(int ii=0;ii<RoomsList.size();ii++){

                            ob.add(RoomsList.get(ii));

                        }
            
           
                        Rooms.setItems(ob);
                        
                    }catch(Exception ex){

                        System.out.println(ex.getMessage());

                    }
                }
                
                break;
            }
        }
        
    
    }
    
    public void handlerGotoDashboard(ActionEvent event){
    
        try {
            stage = (Stage) Rooms.getScene().getWindow();
            URL url = new File("src/Manager/Dashboard.fxml").toURI().toURL();
            //URL url = getClass().getResource("/Manager/Dashboard.fxml");
            
            myNewScene = FXMLLoader.load(url);
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.show();
            
           

            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    
    }
    
}
