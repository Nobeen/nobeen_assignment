/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Model.DAO;
import Model.UsersModel;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UsersController implements Initializable {

    
      
    Stage stage = null;
    Parent myNewScene = null;
    
    @FXML TableView all_users;
    @FXML ComboBox role;
    DAO dao = new DAO();
    
    ArrayList<UsersModel> users = new ArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
        try{
        
            users  = dao.getAllUsers();
            all_users.setItems(FXCollections.observableArrayList(users));
            
        
        }catch(Exception ex){
            
            
        
        }
        
        try{
            
            role.setItems(FXCollections.observableArrayList("Manager","Clerk"));
        
        }catch(Exception ex){
        
        }
        
        
    }    
    
    public void handleAddUser(ActionEvent action){
    
        try{
            
        stage = (Stage) all_users.getScene().getWindow();
        URL url = new File("src/Users/AddUser.fxml").toURI().toURL();

        myNewScene = FXMLLoader.load(url);
        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("All Users");
        stage.show();
        
        }catch(Exception ex){
        
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    @FXML TextField name;
    @FXML TextField username;
    @FXML PasswordField password;
    
    public void handleAddUserConfirm(ActionEvent event){
    
        try{
            String ro = "";
            if(role.getSelectionModel().getSelectedIndex()==0){
                ro = "Manager";
            }else{
                ro = "Clerk";
            }
            
            if(dao.addUser(name.getText(),username.getText(),password.getText(),ro)==1){
        
                JOptionPane.showMessageDialog(null,"Success", "Record Inserted", JOptionPane.INFORMATION_MESSAGE);
                stage = (Stage) name.getScene().getWindow();
                URL url = new File("src/Users/AllUsers.fxml").toURI().toURL();

                myNewScene = FXMLLoader.load(url);
                Scene scene = new Scene(myNewScene);
                stage.setScene(scene);
                stage.setTitle("All Users");
                stage.show();

            }else{
                
                JOptionPane.showMessageDialog(null,"OOPS!!", "Something Went Wrong", JOptionPane.ERROR_MESSAGE);
            
            }
            
        }catch(Exception ex){
        
            System.out.println(ex.getMessage());
        
        }
        
        
    
    }
    
}
