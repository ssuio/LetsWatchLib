/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.delete;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RDBMemberDAO;
import lw.model.RoomDAO;

/**
 *
 * @author Cyruss
 */
public class TestDeleteRoom {
    public static void main(String[] args) {
        try {
            RoomDAO dao = new RoomDAO();
            dao.delete("r00000000");
        } catch (LWException ex) {
            Logger.getLogger(TestDeleteRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
