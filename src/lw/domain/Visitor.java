/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

/**
 *
 * @author adm
 */
public class Visitor {
    private int id;
    private String name;
    private String roomId;

    public Visitor(){
    
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    
    
    public Visitor(int id, String name){
    super();
    
    } 
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 45 && name.length()>=2)
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name ;
    }
    
}
