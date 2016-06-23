/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RoomMemberListDAO;

/**
 *
 * @author Cyruss
 */
public class TestRoomMemberListDAO {
    public static void main(String[] args) {
        try {
            RoomMemberListDAO dao  = new RoomMemberListDAO();
            dao.createTable("r11111113");
        } catch (LWException ex) {
            Logger.getLogger(TestRoomMemberListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
