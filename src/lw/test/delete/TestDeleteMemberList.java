/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.delete;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RoomMemberListDAO;

/**
 *
 * @author adm
 */
public class TestDeleteMemberList {
    public static void main(String[] args) {
        try {
            RoomMemberListDAO dao = new RoomMemberListDAO();
            Member m = new Member();
            m.setId("M00000002");
            dao.delete("r11111113", m);
        } catch (LWException ex) {
            Logger.getLogger(TestDeleteMemberList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
