/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.*;
import lw.domain.*;
/**
 *
 * @author Cyruss
 */
public class RoomService {
    public String createRoom(Room r) throws LWException{
        RoomDAO rDAO = new RoomDAO();
        RoomMemberListDAO rmDAO = new RoomMemberListDAO();
        PlayListDAO pDAO = new PlayListDAO();
        IdGenerateService idG = new IdGenerateService();
        try {
            r.setRoomId(idG.generateRoomId());
            //rDAO.createTable(r.getRoomId());
            rmDAO.createTable(r.getRoomId());
            pDAO.createTable(r.getRoomId());
            rDAO.insert(r);

            return r.getRoomId();
        } catch (LWException ex) {
            throw new LWException("LW error");
        } catch (SQLException ex) {
            throw new LWException("SQL error");
        }
    }
    
    public void enterRoom(Member m , String roomId){
        try {
            RoomMemberListDAO dao = new RoomMemberListDAO();
            dao.insert(m, roomId);
        } catch (LWException ex) {
            Logger.getLogger(RoomService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void leaveRoom(Member m , String roomId){
        try {
               RoomMemberListDAO dao = new RoomMemberListDAO();
               dao.delete(roomId, m);
           } catch (LWException ex) {
               Logger.getLogger(RoomService.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
    
    public void deleteRoom(String roomId){
        try {
            RoomMemberListDAO mlDAO = new RoomMemberListDAO();
            PlayListDAO pDAO = new PlayListDAO();
            RoomDAO dao = new RoomDAO();
            dao.delete(roomId);
            mlDAO.deleteTable(roomId);
            pDAO.deleteTable(roomId);
            
        } catch (LWException ex) {
            Logger.getLogger(RoomService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void deleteAllRoom(){
        try {
            RoomDAO rDAO = new RoomDAO();
            List<Room> rList = new ArrayList<>();
            rList = rDAO.getAll();
            for(Room r : rList){
                deleteRoom(r.getRoomId());
            
            }
            
            
        } catch (LWException ex) {
            Logger.getLogger(RoomService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
            
    }
    
    

