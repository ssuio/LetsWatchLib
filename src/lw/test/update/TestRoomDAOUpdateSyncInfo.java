/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.update;

/**
 *
 * @author Cyruss
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Room;
import lw.model.RoomDAO;

public class TestRoomDAOUpdateSyncInfo {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            Room r = new Room();
            r.setAction("stop");
            r.setArea("search");
            r.setCurrentTime("cuTime");
            r.setVideoId("videoId");
            
            dao.updateSyncInfo(r, "R16060040");
            
            System.out.println(r);
        } catch (LWException ex) {
            Logger.getLogger(TestRoomDAOUpdateSyncInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
