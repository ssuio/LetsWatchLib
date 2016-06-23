/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Room;
import lw.model.RoomDAO;
import lw.test.update.TestRoomDAOUpdateSyncInfo;

/**
 *
 * @author Cyruss
 */
public class TestRoomDAOGetTime {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            
            
            String str = dao.getTime("R16060038");
            
            System.out.println(str);
        } catch (LWException ex) {
            Logger.getLogger(TestRoomDAOUpdateSyncInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
