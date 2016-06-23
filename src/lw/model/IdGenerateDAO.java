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
import lw.domain.LWException;

/**
 *
 * @author adm
 */
public class IdGenerateDAO {
    private static final String SELECT_ID_TABLE = "SELECT * FROM idseries WHERE ids=?";
    private static final String UPDATE_MEMBER_ID = "UPDATE idseries SET MemberId=? WHERE ids=?";
    private static final String UPDATE_VISITOR_ID = "UPDATE idseries SET VisitorId=? WHERE ids=?";
    private static final String UPDATE_MANAGER_ID = "UPDATE idseries SET ManagerId=? WHERE ids=?";
    private static final String UPDATE_ROOM_ID = "UPDATE idseries SET RoomId=? WHERE ids=?";
    
    public int getMemberId() throws LWException, SQLException{
         try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ID_TABLE);
            )
         {
             pstmt.setInt(1,999);
                try(
                    ResultSet rs = pstmt.executeQuery();
                         )
                {
                    int preId=0;
                    while (rs.next()){
                        preId = rs.getInt("MemberId");
                    }
                    
                    return preId ;
                }catch(SQLException ex){
                       throw new LWException("Connection or Statement failed!", ex);
                }
         }
    }
    
    public void updateMemberId(int nextId) throws SQLException, LWException{
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_MEMBER_ID);
            )
         {
            pstmt.setInt(1,nextId);
            pstmt.setInt(2,999);
            pstmt.executeUpdate();
            }catch(SQLException ex){
                   throw new LWException("Connection or Statement failed!", ex);
            }
         }
    public int getRoomId() throws LWException, SQLException{
         try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ID_TABLE);
            )
         {
             pstmt.setInt(1,999);
                try(
                    ResultSet rs = pstmt.executeQuery();
                         )
                {
                    int preId=0;
                    while (rs.next()){
                        preId = rs.getInt("RoomId");
                    }
                    
                    return preId ;
                }catch(SQLException ex){
                       throw new LWException("Connection or Statement failed!", ex);
                }
         }
    }
    
    public void updateRoomId(int nextId) throws SQLException, LWException{
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_ROOM_ID);
            )
         {
            pstmt.setInt(1,nextId);
            pstmt.setInt(2,999);
            pstmt.executeUpdate();
            }catch(SQLException ex){
                   throw new LWException("Connection or Statement failed!", ex);
            }
         }
  
    public int getVisitorId() throws LWException, SQLException{
         try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ID_TABLE);
            )
         {
             pstmt.setInt(1,999);
                try(
                    ResultSet rs = pstmt.executeQuery();
                         )
                {
                    int preId=0;
                    while (rs.next()){
                        preId = rs.getInt("VisitorId");
                    }
                    
                    return preId ;
                }catch(SQLException ex){
                       throw new LWException("Connection or Statement failed!", ex);
                }
         }
    
    }

    
     public void updateVisitorId(int nextId) throws SQLException, LWException{
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_VISITOR_ID);
            )
         {
            pstmt.setInt(1,nextId);
            pstmt.setInt(2,999);
            pstmt.executeUpdate();
            }catch(SQLException ex){
                   throw new LWException("Connection or Statement failed!", ex);
            }
         }
     
    public int getManagerId() throws LWException, SQLException{
         try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ID_TABLE);
            )
         {
             pstmt.setInt(1,999);
                try(
                    ResultSet rs = pstmt.executeQuery();
                         )
                {
                    int preId=0;
                    while (rs.next()){
                        preId = rs.getInt("ManagerId");
                    }
                    
                    return preId ;
                }catch(SQLException ex){
                       throw new LWException("Connection or Statement failed!", ex);
                }
         }
    
    }

    
     public void updateManagerId(int nextId) throws SQLException, LWException{
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_MANAGER_ID);
            )
         {
            pstmt.setInt(1,nextId);
            pstmt.setInt(2,999);
            pstmt.executeUpdate();
            }catch(SQLException ex){
                   throw new LWException("Connection or Statement failed!", ex);
            }
         }
}



