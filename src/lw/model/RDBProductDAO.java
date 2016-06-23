/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lw.domain.LWException;
import lw.domain.Product;

/**
 *
 * @author Patty
 */
public class RDBProductDAO {
    private static final String COL_LIST = "name,price,url,description,status";
    private static final String SELECT_SQL = "SELECT id, " + COL_LIST + " FROM product WHERE id=?";
    private static final String SELECT_ALL_SQL = "SELECT id, " + COL_LIST + " FROM product";

//    private static final String INSERT_SQL
//            = "INSERT INTO product (" + COL_LIST + ") VALUES(?,?,?,?,?,?,?)";
    private static final String INSERT_WITH_ID_SQL
            = "INSERT INTO product (" + COL_LIST + ",id) VALUES(?,?,?,?,?,?)";

    private static final String UPDATE_SQL = "UPDATE product SET name=?,price=?,url=?,description=?,status=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM product WHERE id=?";
    
      public void insert(Product p) throws LWException, SQLException{
          try (Connection connection =  RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_WITH_ID_SQL);) {
                pstmt.setString(1, p.getName());
            pstmt.setDouble(2, p.getPrice());
           
            pstmt.setString(3, p.getUrl());
            pstmt.setString(4, p.getDescription());
            pstmt.setInt(5, p.getStatus());
         
            pstmt.setString(6, p.getId());
              System.out.println(pstmt);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("新增產品失敗!", ex);
          } catch (LWException ex) { 
              throw new LWException("新增產品失敗!", ex);
              
            }
          }
      public void update(Product p) throws LWException, SQLException {
        try (Connection connection =  RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);) {

            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getPrice());
            
            pstmt.setString(3, p.getUrl());
            pstmt.setString(4, p.getDescription());
            pstmt.setInt(5, p.getStatus());
      
            pstmt.setString(6, p.getId());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("修改產品失敗!", ex);
          } catch (LWException ex) { 
              throw new LWException("修改產品失敗!", ex);
              
            }
    }

    public void delete(Product p) throws LWException, SQLException {
        try (Connection connection =  RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(DELETE_SQL);) {
            pstmt.setString(1, p.getId());
            pstmt.executeUpdate();
       } catch (SQLException ex) {
            throw new SQLException("刪除產品失敗!", ex);
          } catch (LWException ex) { 
              throw new LWException("刪除產品失敗!", ex);
              
            }
    }

    public List<Product> getAll() throws LWException {
        List<Product> list = new ArrayList<>();
        Product p=null;
        try (Connection connection =  RDBMemConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(SELECT_ALL_SQL);) {
            while (rs.next()) {
                p = new Product();
                   
                    
                    p.setId(rs.getString("id"));
                    p.setName(rs.getString("name"));
                    p.setPrice(rs.getInt("price"));
                 
                    p.setUrl(rs.getString("url"));
                    p.setDescription(rs.getString("description"));
                    p.setStatus(rs.getInt("status"));
                  
                    list.add(p);
                
            }
            System.out.println("productList = " + list);
        return list;
        } catch (SQLException ex) {
            throw new LWException("查詢全部產品失敗", ex);
        }catch (RuntimeException ex) {
            throw new LWException("查詢全部產品失敗", ex);
                }
    }

    public Product get(String id) throws LWException {
        try (Connection connection =  RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(SELECT_SQL)) {
            
            Product p = null;
            pstmt.setString(1, id); 
            try (ResultSet rs = pstmt.executeQuery();) {                    
                                
               
                while (rs.next()) {
                     p = new Product();
                   
                       
                    

                    try {
                        p.setId(rs.getString("id"));
                        p.setName(rs.getString("name"));
                        p.setPrice(rs.getInt("price"));
                        
                        p.setUrl(rs.getString("url"));
                        p.setDescription(rs.getString("description"));
                        //p.setStatus(rs.getInt("status"));
                       
                    } catch (RuntimeException ex) {
                        System.out.println("產品資料讀取錯誤: " + ex);
                    }
                }
                System.out.println(p);
                return p;
            }
        } catch (SQLException ex) {
            throw new LWException("查詢產品失敗: " + id, ex);
        }
    }
   
}
    

