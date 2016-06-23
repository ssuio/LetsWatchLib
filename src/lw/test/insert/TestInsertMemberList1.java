/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RoomMemberListDAO;

/**
 *
 * @author Cyruss
 */
public class TestInsertMemberList1 {
    public static void main(String[] args) {
        try {
            RoomMemberListDAO dao = new RoomMemberListDAO();
            Member m = new Member();
            m.setId("M00000002");
            m.setName("Karl");
            dao.insert(m,"r11111113");
        } catch (LWException ex) {
            Logger.getLogger(TestInsertMemberList1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
