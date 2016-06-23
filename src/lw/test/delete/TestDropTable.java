/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.delete;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RoomDAO;
import lw.model.PlayListDAO;

/**
 *
 * @author Cyruss
 */
public class TestDropTable {
    public static void main(String[] args) {
        try {
            PlayListDAO dao = new PlayListDAO();
            dao.deleteTable("r11111112");
        } catch (LWException ex) {
            Logger.getLogger(TestDropTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
