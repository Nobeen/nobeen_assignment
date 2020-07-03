/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bookings;

import Model.BookingsModel;
import Model.DAO;
import Model.RoomsModel;
import Rooms.RoomsController;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nobeen
 */
public class BookingsController implements Initializable {

    

    @FXML TableView Bookings;
    @FXML ComboBox availibleRooms;
    DAO dao;
    ArrayList<BookingsModel> bookings=null;
    
    Button[] btn;
    ArrayList<RoomsModel> avail_rooms ;
    Stage stage = null;
    Parent myNewScene = null;
    
    public BookingsController() {
        this.dao = new DAO();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            
            bookings =  dao.getAllBookings(); 
            btn = new Button[bookings.size()];
            for(int i=0;i<bookings.size();i++){
                btn[i]  = new Button();
                btn[i].setText("Delete");
                btn[i].setOnAction(this::handleDeleteBookings);
                bookings.get(i).setDelete(btn[i]);
            }
            ObservableList ob = FXCollections.observableArrayList();
            for(int i=0;i<bookings.size();i++){
                ob.add(bookings.get(i));
            }
            Bookings.setItems(ob);
            
        
        }catch(Exception ex){
        
        
        }
        
        
        try{
        
            avail_rooms =  dao.getAvailbleRooms(); 
            ObservableList ob = FXCollections.observableArrayList();

            for(int i=0;i<avail_rooms.size();i++){
            
                ob.add(avail_rooms.get(i).getRoomId());
                
            }
            
            availibleRooms.setItems(ob);
            
            
        }catch(Exception ex){
        
        
        }
        
        
    }    
    
    
    public void handleDeleteBookings(ActionEvent event){
        
        DAO d = new DAO();
        for(int i=0;i<btn.length;i++){
            
            if(event.getSource() == btn[i])
            {
                System.out.println("Button "+(i+1));
                
                if(d.deleteRoom((bookings.get(i)).getId())==1){
                    
                    JOptionPane.showMessageDialog(null, "Room Deleted ","Success", JOptionPane.INFORMATION_MESSAGE);
                    bookings = d.getAllBookings();
                    try{
                        btn = new Button[bookings.size()];

                        for(int ii=0;ii<bookings.size();ii++){

                            btn[ii]  = new Button();
                            btn[ii].setText("Delete");
                            btn[ii].setOnAction(this::handleDeleteBookings);
                            (bookings.get(ii)).setDelete(btn[ii]);
                        }
           
                        ObservableList ob = FXCollections.observableArrayList();
            
                        for(int ii=0;ii<bookings.size();ii++){

                            ob.add(bookings.get(ii));

                        }
            
           
                        Bookings.setItems(ob);
                        
                    }catch(Exception ex){

                        System.out.println(ex.getMessage());

                    }
                }
                
                break;
            }
        }
        
    
    }
    
    public void handlerAddBooking(ActionEvent event){
    
        try {
            
            stage = (Stage) Bookings.getScene().getWindow();
            URL url = new File("src/Bookings/AddBookings.fxml").toURI().toURL();
            //URL url = getClass().getResource("/Manager/Dashboard.fxml");
            
            myNewScene = FXMLLoader.load(url);
            Scene scene = new Scene(myNewScene);
            stage.setScene(scene);
            stage.setTitle("Add Bookings");
            stage.show();
            
           

            
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(RoomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    @FXML Button add_booking;
    @FXML DatePicker start_date;
    @FXML DatePicker end_date;
    
    public void handlerAddBookingConfirm(ActionEvent event){
    
        try{
        
            ObservableList ob = availibleRooms.getItems();
            
            int i = availibleRooms.getSelectionModel().getSelectedIndex();
            
            String rid = avail_rooms.get(i).getId();
            BookingsModel t = new BookingsModel();
            
            t.setRoomId(rid);
            t.setBooking_start_date(new Date(start_date.getEditor().getText()));
            t.setBooking_end_date(new Date(end_date.getEditor().getText()));
            
            if(dao.addBooking(t)==1){
                
                JOptionPane.showMessageDialog(null, "Success", "Booking Added", JOptionPane.INFORMATION_MESSAGE);
            
            }else{
            
                JOptionPane.showMessageDialog(null, "OOPS!!", "Something Went Wrong", JOptionPane.ERROR_MESSAGE);
            
            }
            
        
        }catch(Exception ex){
        
        
        }
        
        
    
    }
    
    public void handlerGotoDashboard(ActionEvent event){
    
         try {
            if(Bookings!=null)
                stage = (Stage) Bookings.getScene().getWindow();
            else
                   stage = (Stage) add_booking.getScene().getWindow();

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
    
    public void handlerGoBack(ActionEvent event){
    
         try {
          
            stage = (Stage) add_booking.getScene().getWindow();

            URL url = new File("src/Bookings/AllBookings.fxml").toURI().toURL();
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
