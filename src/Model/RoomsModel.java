/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
public class RoomsModel {
    
    
   private final SimpleStringProperty id = new SimpleStringProperty("");
   private final SimpleStringProperty roomId = new SimpleStringProperty("");
   private final SimpleStringProperty availibilty = new SimpleStringProperty("");
   private Button delete;
   
    public RoomsModel() {

        this.setId("");
        this.setRoomId("");
        this.setAvailblilty("");
        delete = new Button("Delete");

    }

    public RoomsModel(String id,String roomId,String availibilty,Button btn){
         
        this.setId(id);
        this.setRoomId(roomId);
        this.setAvailblilty(availibilty);
        delete = btn;
     }   
        
    

    public String getId(){
        return id.get();
    }
    
    public String getAvailblilty(){
        return availibilty.get();
    }
    public String getRoomId(){
        
        return roomId.get();
    
    }
    
    public void setId(String id){
        this.id.set(id);
    }
    
    public void setAvailblilty(String availibilty){
        this.availibilty.set(availibilty);
    }
    public void setRoomId(String roomId){
        
        this.roomId.set(roomId);
    
    }

    public Button getDelete() {
        return delete;
    }
    
    public void setButton(Button btn){
        delete = btn;
    }
    
    
}