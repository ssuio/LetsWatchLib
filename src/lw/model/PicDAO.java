/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lw.domain.LWException;

/**
 *
 * @author Cyruss
 */
public class PicDAO {
    private final static String INSERT_PIC = "INSERT INTO memberpic (memberId,pic) values (?, ?)";
    private final static String SELECT_PIC = "SELECT pic FROM memberpic WHERE memberId = ?";
    
    public void savePic(InputStream in, String memberId) throws LWException{
        try(
                Connection connection = RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_PIC);
                ){
                pstmt.setString(1, memberId);
                pstmt.setBlob(2, in);
                pstmt.executeUpdate();
                
            }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
            }catch(SQLException ex){
                throw new LWException("連線失敗" ,ex);
            }
    }
    
    public byte[] getPic(String memberId) throws LWException{
        byte[] pic=null;
         try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_PIC)
                )
        {
            pstmt.setString(1,memberId);
            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    pic = rs.getBytes("pic");
                    }
                }
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        return pic;
        }
}

