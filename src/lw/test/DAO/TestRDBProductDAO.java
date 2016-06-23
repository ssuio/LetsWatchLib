/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RDBProductDAO;

/**
 *
 * @author Patty
 */
public class TestRDBProductDAO {
    public static void main(String[] args) {
        try {
            RDBProductDAO dao = new RDBProductDAO();
            System.out.println(dao.getAll());  
         
            
        } catch (LWException ex) {
            Logger.getLogger(TestRDBProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
