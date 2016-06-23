/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.sql.SQLException;
import lw.domain.LWException;
import lw.domain.Product;
import lw.model.RDBProductDAO;

/**
 *
 * @author Patty
 */
public class TestProduct {
     public static void main(String[] args) throws LWException, SQLException {
     RDBProductDAO dao = new RDBProductDAO();
     Product p =null;
     try{
         dao.getAll();
         
        System.out.println(p); //0        
       
     }catch (LWException ex) { 
              throw new LWException("", ex);
                      
     } 
            }
}
  
