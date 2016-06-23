/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author adm
 */
public class TestMemberUpdate {
    public static void main(String[] args) {
        try {
            RDBMemberDAO mDAO = new RDBMemberDAO();
            Member m = mDAO.getOneById("M00000019");
            m.setName("Sssuio");
            //m.setEmail("xssuio@gmail.com");
            //m.setStatus(1);
            //m.setPwd("Abcd1234");
            mDAO.update(m, "M00000019");
        } catch (LWException ex) {
            Logger.getLogger(TestMemberUpdate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestMemberUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
