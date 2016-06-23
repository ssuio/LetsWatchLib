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

/**
 *
 * @author Cyruss
 */
public class TestRoomDAOgetSyncInfo {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            Room r ;
            r = dao.getSyncInfo("r16060040");
            
            System.out.println(r);
        } catch (LWException ex) {
            Logger.getLogger(TestRoomDAOgetSyncInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
