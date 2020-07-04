/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;

public class UsersModel {
    
    
    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty name = new SimpleStringProperty("");
    private final SimpleStringProperty username = new SimpleStringProperty("");
    private final SimpleStringProperty role = new SimpleStringProperty("");
    
    
    public void setId(String id){
        
        this.id.set(id);
    
    }
    
    public void setName(String name){
    
        this.name.set(name);
        
    }
    
    public void setUsername(String username){
    
        this.username.set(username);
        
    }
    
    public void setRole(String role){
    
        this.role.set(role);
        
    }
    
    public String getId(){
    
        return this.id.get();
    }
    
    public String getName(){
    
        return this.name.get();
    }
    
    public String getUsername(){
    
        return this.username.get();
    }
    
    public String getRole(){
        return this.role.get();
    }
    
    
    
}




