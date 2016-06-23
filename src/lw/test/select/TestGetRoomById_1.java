/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

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
public class TestGetRoomById_1 {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            Room r = dao.getOneById("r11111111");
            
            System.out.println(r);
        } catch (LWException ex) {
            Logger.getLogger(TestGetRoomById_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestGetRoomById_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
