/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author Cyruss
 */
public class TestMemberDAO {
    public static void main(String[] args) {
        try {
            RDBMemberDAO mDAO = new RDBMemberDAO();
            Member m = new Member();
            m.setEmail("Karl@hotmail.com");
            m.setId("M1111178");
            m.setPwd("Abcd1234");
            m.setRoomId("R16060005");
            mDAO.update(m, "M1111178");
        } catch (LWException ex) {
            Logger.getLogger(TestMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
}
