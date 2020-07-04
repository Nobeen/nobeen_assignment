/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Screens.CustomList;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;
import static sameerassignment_1.SameerAssignment_1.u;

/**
 *
 * @author Faizan
 */
public class DAO {
    
    Connection con;
    PreparedStatement prep;
    
    
    void connect(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/room_reservation","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    //User Functions
    public boolean login(String username,String password){
    
        
        connect();
        
        try {
            
            
            String sql = "select * from users where username=? and password=?";
            
            prep = con.prepareStatement(sql);
            prep.setString(1, username);
            prep.setString(2, password);
            
            ResultSet rs = prep.executeQuery();
            
            if(rs.next()){
            
                
                
                u = new users(rs.getString("name"),
                              rs.getString("username"),
                              rs.getString("password"),
                              rs.getString("role")
                );
                
                
                
                return true;
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Invalid/Username Password");
                return false;
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        disconnect();
        
    return false;
    }
    
    
    
    
    void disconnect(){
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public CustomList<RoomsModel> getAllRooms() {
        
        CustomList<RoomsModel> temp = new CustomList();
        connect();
        
            try{
                
                String sql = "select * from rooms";
                
                prep = con.prepareStatement(sql);
                
                ResultSet rs = prep.executeQuery();
                
                while(rs.next()){
                
                    Button btn = new Button("Delete");

                    
                    
                    
                    temp.insert(new RoomsModel(rs.getString("id"),
                            rs.getString("roomId"),
                            rs.getString("availbility"),
                            btn
                            
                    ));
                    
                    
                }
                
                
            } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        disconnect();
        
        return temp;
        
    }

    public int isUnique(String name) {

        connect();
            
            try{
            
                String sql = "select * from rooms where roomId=?";
                
                prep = con.prepareStatement(sql);
                prep.setString(1, name);
                
                ResultSet rs = prep.executeQuery();
                
                if(rs.next()){
                
                    return 1;
                    
                }else{
                    return 0;
                }
                
                
                
            }catch(Exception ex){
            
                System.out.println(ex.getMessage());
                
            }
        
        disconnect();
        return 1;

    }

    public int insert(String name,int categoryid) {
        
        
        try{
            
                String sql = "insert into rooms(roomId,catid) values (?,?)";
                
                
                prep = con.prepareStatement(sql);
                
                prep.setString(1, name);
                prep.setInt(2, categoryid);
                
                int rs = prep.executeUpdate();
                
                if(rs>0){
                
                    return 1;
                    
                }else{
                    return 0;
                }
                
                
                
            }catch(Exception ex){
            
                
                
            }
        
        return 0;
        
    }

    public int deleteRoom(String id) {
       
        connect();
        
            try{
            
                String sql = "delete from rooms where id=?";
                
                prep = con.prepareStatement(sql);
                prep.setString(1, id);
                
                int i = prep.executeUpdate();
                
                return i;
                
                
                
            }catch(Exception ex){
            
                System.out.println(ex.getMessage());
            }
        
        disconnect();
        
        return 0;
        
    }
    
    
    //Categoies
    public ArrayList<Categories> getAllRoomsCategories(){
        
        connect();
        ArrayList<Categories> temp = new ArrayList();
        try{
            
            String sql = "select * from roomscategories";
            
            prep = con.prepareStatement(sql);
            
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
            
                temp.add(new Categories(rs.getString("id"),rs.getString("name")));
                
            }
            
            
        
        }catch(Exception ex){
        
        }
        
       
        disconnect();
    
        return temp;
        
    }

    public ArrayList<BookingsModel> getAllBookings() {

        ArrayList<BookingsModel> temp = new ArrayList();
        
        connect();
        
        try{
            
            String sql = "select * from bookings inner join rooms on rooms.id = bookings.roomId";
            
            prep = con.prepareStatement(sql);
            
            ResultSet rs = prep.executeQuery();
            
            
            
            
            while(rs.next()){
                
                BookingsModel temp_model = new BookingsModel();
            
                temp_model.setId(rs.getString("id"));
                temp_model.setRoomId(rs.getString("roomId"));
                temp_model.setBooking_start_date(new Date(rs.getString("booking_start_date")));
                temp_model.setBooking_end_date(new Date(rs.getString("booking_end_date")));
                temp.add(temp_model);
            
            }
            
            
        
        }catch(Exception ex){
        
        }
        
        disconnect();
        return temp;

    }

    public ArrayList<RoomsModel> getAvailbleRooms() {
        
        connect();
        ArrayList<RoomsModel> temp = new ArrayList();
        try{
        
            String sql = "select * from rooms where availbility=?";
            
            prep = con.prepareStatement(sql);
            prep.setString(1, "Yes");
            
            ResultSet rs = prep.executeQuery();
            
            while(rs.next()){
                
                Button btn = new Button("Delete");

                    
                    
                    
                    temp.add(new RoomsModel(rs.getString("id"),
                            rs.getString("roomId"),
                            rs.getString("availbility"),
                            btn
                            
                    ));
            
            }
            
            
        
        }catch(Exception ex){
        
            System.out.println(ex.getMessage());
        }
        
        
        disconnect();

        return temp;

    }

    public int addBooking(BookingsModel b) {
        
        connect();
            
            try{
                
                String sql = "INSERT INTO `bookings`(`roomid`, `booking_start_date`, `booking_end_date`) VALUES (?,?,?)";
                
                prep = con.prepareStatement(sql);
                
                prep.setString(1, b.getRoomId());
                prep.setString(2, b.getBooking_start_date());
                prep.setString(3, b.getBooking_end_date());
                
                if(prep.executeUpdate()>0){
                    
                    JOptionPane.showMessageDialog(null, "Booking Added");
                
                    sql = "Update `rooms` set availbility=No";
                    
                    prep = con.prepareStatement(sql);   
                    prep.executeUpdate();
                    
                    return 1;
                
                }else{
                
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                    
                }
                
            
            }catch(Exception ex){
            
            
            }
        
        disconnect();
        return 0;
    }
    
    public int addUser(String name,String username,String password,String role){
        
        connect();
            
            try{
                    
                String sql = "INSERT INTO `users`(`name`, `username`, `password`, `role`) VALUES (?,?,?,?)";
            
                prep = con.prepareStatement(sql);
                
                prep.setString(1, name);
                prep.setString(2, username);
                prep.setString(3, password);
                prep.setString(4, role);
                
                return prep.executeUpdate();
                
                
            }catch(Exception ex){
            
            }
        
        
        disconnect();
    
        return 0;
    }

    public ArrayList<UsersModel> getAllUsers() {
        
        connect();
        
        ArrayList<UsersModel> temp = new ArrayList();
        try{
            
            String sql = "select * from users";
            
            prep = con.prepareStatement(sql);
            
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
            
                UsersModel u = new UsersModel();
                
                u.setId(rs.getString("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setRole(rs.getString("role"));
                        
                temp.add(u);
                
            }
            
        
        }catch(Exception ex){
        
        }
        
        disconnect();
        return temp;
        
    }
    
    
}
