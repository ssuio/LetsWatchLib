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
import lw.domain.PlayList;
import lw.domain.Room;

/**
 *
 * @author Cyruss
 */
public class PlayListDAO implements lwMysqlDAO<List<PlayList>, List<String>>{
    private static final String DROP_TABLE = "DROP TABLE ";
    private static final String TRUNCATE_TABLE = "TRUNCATE ";
    private static final String INSERT_PLAYLIST = "INSERT INTO lw.? "+ "(number,videoId,videoTitle,videoTime,videoImg,time) " +
    "VALUES(?,?,?,?,?,?)";
    private static final String SELECT_PLAYLIST = "SELECT videoId,videoTitle,videoTime,videoImg FROM ";
    private static final String SELECT_TIME = "SELECT time FROM ";
    
    public List<PlayList> getAll(String roomId) throws LWException {
        List<PlayList> pList = new ArrayList<>();
        PlayList p;
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_PLAYLIST + roomId + "playlist");
            )
        {
            
            while(rs.next()){
                p = new PlayList();
                p.setVideoId(rs.getString("videoId"));
                p.setVideoTitle(rs.getString("videoTitle"));
                p.setVideoTime(rs.getString("videoTime"));
                p.setVideoImg(rs.getString("videoImg"));
                pList.add(p);
            }
            return pList;
            
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        
    }

    @Override
    public List<String> getOneById(String roomId) throws LWException, SQLException {
       List<String> rlist = new ArrayList<>();
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
                
                )
        {
            try(ResultSet rs = stmt.executeQuery(SELECT_PLAYLIST + roomId + "playlist");){
                while(rs.next()){
                    rlist.add(rs.getString("list"));
                }
                return rlist;
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        
    }

    
    public void insert(List<PlayList> pList, String roomId, String time) throws LWException {
           try(
                Connection con = RDBMemConnection.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_PLAYLIST);
                   Statement stmt = con.createStatement();
                ){
               int number =1;
               for (PlayList p: pList){
                pstmt.setString(1, roomId+"playlist");
                pstmt.setString(2, number+"");
                pstmt.setString(3, p.getVideoId());
                String videoTitle = p.getVideoTitle();
                videoTitle= videoTitle.replaceAll("'", "");
                videoTitle= videoTitle.replaceAll("|", "");
                videoTitle= videoTitle.replaceAll(":", "");
                videoTitle= videoTitle.replaceAll("\\.", "");
                pstmt.setString(4, videoTitle);
                
                pstmt.setString(5, p.getVideoTime());
                pstmt.setString(6, p.getVideoImg());
                pstmt.setString(7, time);
                String sql=pstmt + "";
                sql = sql.replaceAll(".*: ", "");
                sql = sql.replaceAll("\\.'", ".");
                sql = sql.replaceAll("' ", " ");
                System.out.println(sql);
                stmt.executeUpdate(sql);
                number++;
               }
       
       }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
            }catch(SQLException ex){
                throw new LWException("連線失敗" ,ex);
            }
    }

    @Override
    public void update(List<PlayList> m, String id) throws LWException {
    }

    @Override
    public void createTable(String roomId) throws LWException {
         String CREAT_BUYHISTORY_TABLE = "CREATE TABLE lw."+ roomId +"PlayList " 
            + "(number INT UNIQUE,"
            + " videoId VARCHAR(45) NULL,"
            + " videoTitle VARCHAR(100) NULL,"
            + " videoTime VARCHAR(45) NULL,"
            + " videoImg VARCHAR(100) NULL,"
            + " time VARCHAR(45) NULL,"
            + " PRIMARY KEY (number));";
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
    public void deleteTable(String roomId) throws LWException {
        try(
                Connection con = RDBMemConnection.getConnection();
                Statement stmt = con.createStatement();
                ) {
            String sql = DROP_TABLE + roomId +"playlist";
            //System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        } 
    }

    @Override
    public void delete(String roomId) throws LWException {
        
    }
    
    public void cleanTable(String roomId) throws LWException{
        try(
                Connection con = RDBMemConnection.getConnection();
                Statement stmt = con.createStatement();
                ) {
                String sql = TRUNCATE_TABLE + roomId + "playlist";
                stmt.executeUpdate(sql);
        }catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        }
    
    
    }

    @Override
    public void insert(List<PlayList> m) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<List<PlayList>> getAll() throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getTime(String roomId) throws LWException{
        String time="not set";
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
                
                )
        {
            try(ResultSet rs = stmt.executeQuery(SELECT_TIME + roomId + "playlist" + " WHERE number=1");){
                while(rs.next()){
                    if(rs.getString("time")!=null)
                    time = rs.getString("time");
                }
                return time;
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
    }

}
