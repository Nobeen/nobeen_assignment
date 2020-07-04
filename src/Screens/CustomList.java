/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

/**
 *
 * @author Faizan
 */
public class CustomList<E> {
    
    
    Object [] temp = new Object[1];
    int size=0;
    
    public void insert(Object obj){
    
        
        
        if(temp[size]==null ){
            
            temp[size] = obj;
            size++;
        }
        
        Object [] temp2 = new Object[size+1];    
        
        for(int i=0;i<temp.length;i++){
            
            temp2[i]= temp[i];
        
        }
        temp = temp2;
        
    
    }
    
    
    public boolean remove(int index){
        
        if(size<index){
            
            return false;
        
        }else{
        
            
            for(int i=index;i<size;i++){
                
                if(size>i+1)
                    temp[i]=temp[i+1];
                else
                    temp[size--]=null;
            }
        
            return true;
        }
        
    
    }
    
    public int size(){
        
        return size;
    
    }
    
    public Object get(int index){
    
        if(index<size){
            
            return temp[index];
        
        }else{
        
            return null;
        }
    
    }
    
    
}
