/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RoomMemberListDAO;

/**
 *
 * @author Cyruss
 */
public class TestMemberListDAOGetLists1 {
    public static void main(String[] args) {
        try {
            List<Member> mlist;
            RoomMemberListDAO dao = new RoomMemberListDAO();
            mlist = dao.getOneById("r16060020");
            if (mlist.isEmpty())
                System.out.println("Empty!");
                
        } catch (LWException ex) {
            Logger.getLogger(TestMemberListDAOGetLists1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestMemberListDAOGetLists1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
