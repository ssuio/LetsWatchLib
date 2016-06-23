/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lw.domain.LWException;
import lw.domain.Product;
import lw.model.RDBProductDAO;

/**
 *
 * @author Patty
 */
public class TestInsertProduct {
    public static void main(String[] args) throws LWException, SQLException {
     
     RDBProductDAO dao = new RDBProductDAO();
     Product p =null;
      try{
        p = new Product();
       // System.out.println(p.getId()); //0        
        p.setId("2");
        p.setName("Wcoin50000");
        p.setUrl("http://imgx.pcgamesupply.com/assets/images/products/1260.jpg");
        p.setDescription("Wcoin50000");
        p.setPrice(500);
        p.setStatus(0);
        dao.insert(p);
//        System.out.println(p.getId());
//        System.out.println(p.getName());
//        System.out.println(p.getPrice());
//        
//        System.out.println(p);
//        System.out.println(p.toString());
        
//        String s = "Hello";
////        
//       System.out.println(s.toString());
            System.out.println("product"+p);
       } catch (SQLException ex) {
            throw new SQLException("", ex);
       }catch (LWException ex) {
            throw new LWException("", ex);
}
    }
}
