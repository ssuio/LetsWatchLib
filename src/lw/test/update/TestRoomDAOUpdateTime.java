/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.update;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RoomDAO;

/**
 *
 * @author Cyruss
 */
public class TestRoomDAOUpdateTime {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            String time = "8888";
            
           dao.updateTime(time, "r16060040");
            
        } catch (LWException ex) {
            Logger.getLogger(TestRoomDAOUpdateSyncInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
