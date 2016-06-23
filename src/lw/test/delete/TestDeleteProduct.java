/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.delete;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Product;
import lw.model.RDBProductDAO;

/**
 *
 * @author Patty
 */
public class TestDeleteProduct {
     public static void main(String[] args) throws SQLException {
          Product p = null;
      try {
          RDBProductDAO dao = new RDBProductDAO();
            p =dao.get("2");
          
             if(p !=null){
            System.out.println("查詢成功: " + p);
            dao.delete(p);
            
             }else{
                 System.out.println("查無此產品");
             }
      } catch (SQLException ex) {
            throw new SQLException("查詢全部產品失敗", ex);
        } catch (LWException ex) {
          Logger.getLogger(TestDeleteProduct.class.getName()).log(Level.SEVERE, null, ex);
        
        }
         
     }
}

