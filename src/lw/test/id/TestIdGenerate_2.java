/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.id;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.IdGenerateService;

/**
 *
 * @author adm
 */
public class TestIdGenerate_2 {
    public static void main(String[] args) {
        try {
            
            
            IdGenerateService idg = new IdGenerateService();
            
            System.out.println(idg.generateManagerId());
            
            
            
        } catch (LWException ex) {
            Logger.getLogger(TestIdGenerate_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestIdGenerate_2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
