/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class BookingsModel {

    private final SimpleStringProperty id = new SimpleStringProperty("");
    private final SimpleStringProperty roomId = new SimpleStringProperty("");
    private final SimpleStringProperty booking_start_date = new SimpleStringProperty("");
    private final SimpleStringProperty booking_end_date = new SimpleStringProperty("");
    private Button delete;

    
    
    public void setId(String id){
        
        this.id.set(id);
    
    }
    
    public void setRoomId(String roomId){
        
        this.roomId.set(roomId);
    
    }
    
    public void setBooking_start_date(Date date){
        
        this.booking_start_date.set(date.toString());
    
    }
    
    public void setBooking_end_date(Date date){
    
        this.booking_end_date.set(date.toString());
    
    }

    public String getId() {
        return id.get();
    }

    public String getRoomId() {
        return roomId.get();
    }

    public String getBooking_start_date() {
        return booking_start_date.get();
    }

    public String getBooking_end_date() {
        return booking_end_date.get();
    }

    public void setDelete(Button btn){
    
        this.delete = btn;
        
    }
    
    public Button getDelete() {
        return delete;
    }
    
    
    
    
    
}
