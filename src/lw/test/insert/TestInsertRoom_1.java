/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Room;
import lw.model.RoomDAO;

/**
 *
 * @author Cyruss
 */
public class TestInsertRoom_1 {
    public static void main(String[] args) {
        try {
            Room r = new Room();
            r.setRoomId("r11111111");
            r.setOwnerId("M11111111");
            r.setRoomName("Ice and Fire");
            r.setwCoin(5000);
            r.setRoomPwd("12345678910");
            r.setRoomType(5);
            System.out.println(r);
            RoomDAO dao = new RoomDAO();
            dao.insert(r);
            dao.update(r, r.getRoomId());
            
            try {
                System.out.println(dao.getOneById("r11111111"));
            } catch (SQLException ex) {
                Logger.getLogger(TestInsertRoom_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LWException ex) {
            Logger.getLogger(TestInsertRoom_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
