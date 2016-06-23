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
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.BuyHistory;
import lw.domain.LWException;
import lw.domain.PayWay;

/**
 *
 * @author adm
 */
public class RDBBuyHistoryDAO implements lwMysqlDAO<BuyHistory,List<BuyHistory>>{
    private static final String INSERT_BUY_HISTORY = "INSERT INTO lw.? "+ "(orderId, buydate, product, price, pay, state ) " +
    "VALUES(?,?,?,?,?,?)";
    
    private static final String SELECT_ALL_BUYHISTORY = "SELECT number, orderId, buydate, product, price, pay, state FROM ";
    
    
//    public BuyHistory getBuyHistoryByMemberId(String MemberId) throws LWException{
//        MemberId += "buyhistory";
//        BuyHistory bh = new BuyHistory();
//        try(
//                Connection con = RDBMemConnection.getConnection();
//                PreparedStatement pstmt = con.prepareStatement(MemberId);)
//        {
//            
//        
//        
//        } catch (LWException ex) {
//            throw new LWException ("RDBMemberConnection error!", ex);
//        } catch (SQLException ex) {
//            throw new LWException ("SQL error!", ex);
//        }
//    }
    @Override
    public List<BuyHistory> getOneById(String MemberId) throws LWException{
        List<BuyHistory> bhList = new ArrayList<>();
        BuyHistory bh = new BuyHistory();
        try(
                Connection con = RDBMemConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SELECT_ALL_BUYHISTORY+MemberId+"buyhistory");
                ) {
            while(rs.next()){
                    bh.setNumber(rs.getInt("number"));
                    bh.setOrderId(rs.getString("orderId"));
                    bh.setBuydate(rs.getDate("buydate"));
                    bh.setProduct(rs.getString("product"));
                    bh.setPrice(rs.getInt("price"));
                    bh.setPay(PayWay.valueOf(rs.getString("pay")));
                    bh.setState(rs.getString("state"));
                    bhList.add(bh);
            }
            return bhList;
        } catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        }
    
    }
    
    public void insert(BuyHistory buyHistory, String id) throws LWException{
     
        try(
                Connection con = RDBMemConnection.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_BUY_HISTORY);
                Statement stmt = con.createStatement();
                ) {
            pstmt.setString(1, id+"buyhistory");
            pstmt.setString(2, buyHistory.getOrderId());
            pstmt.setDate(3, new java.sql.Date (buyHistory.getBuydate().getTime()));
            pstmt.setString(4, buyHistory.getProduct());
            pstmt.setInt(5, buyHistory.getPrice());
            pstmt.setString(6, buyHistory.getPay().name());
            pstmt.setString(7, buyHistory.getState());
            
            String sql=pstmt + "";
            sql = sql.replaceAll(".*: ", "");
            sql = sql.replaceAll("\\.'", ".");
            sql = sql.replaceAll("' ", " ");
            System.out.println(sql);
//            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        }
    
    }
    
    @Override
    public void createTable(String id) throws LWException{
        String CREAT_BUYHISTORY_TABLE = "CREATE TABLE lw."+ id +"BuyHistory " 
            + "(number INT NULL, orderId VARCHAR(45) NOT NULL,"
            + " buydate DATE NULL,product VARCHAR(45) NULL,"
            + "price INT NULL,pay VARCHAR(45) NULL,"
            + "state VARCHAR(45) NULL, PRIMARY KEY (orderId));";
        try(
                Connection con = RDBMemConnection.getConnection();
                Statement stmt = con.createStatement();
                ) {
            
            stmt.executeUpdate(CREAT_BUYHISTORY_TABLE);
            
        } catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        }
    
    }

    @Override
    public List<BuyHistory> getAll() throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(BuyHistory m) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BuyHistory m, String id) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTable(String id) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
            
}
