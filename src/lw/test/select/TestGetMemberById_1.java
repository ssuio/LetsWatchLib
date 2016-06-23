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
import lw.model.RDBMemberDAO;

/**
 *
 * @author adm
 */
public class TestGetMemberById_1 {
    public static void main(String[] args) {
        
        try {
            RDBMemberDAO r = new RDBMemberDAO();
            System.out.println(r.getOneByEmail("xssuio@gmail.com"));
        } catch (LWException ex) {
            Logger.getLogger(TestGetMemberById_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestGetMemberById_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
