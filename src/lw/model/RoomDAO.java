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
public class RoomDAO implements lwMysqlDAO<Room, Room>{
    private static final String COLUMN_LIST = "roomId, ownerId, roomName, wCoin, "
            + "roomPwd, chatroomId, playMode, videoPlayNow, videoWhereNow, roomType";
    private static final String SELECT_ALL = "SELECT " + COLUMN_LIST + " from rooms";
    private static final String SELECT_ROOM_BY_ID = "SELECT "+ COLUMN_LIST + " FROM rooms WHERE roomid=?";
    private static final String UPDATE_rooms = "UPDATE rooms"
            + " SET ownerId=?, roomName=?, wCoin=?,"
            + " roomPwd=?, chatroomId=?, playMode=?, videoPlayNow=?, videoWhereNow=?, roomType=?"
            + " WHERE roomid=?";
    private static final String INSERT_ROOM = "INSERT INTO rooms" 
               +" (" + COLUMN_LIST + " ) " + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_ROOM = "DELETE FROM rooms WHERE roomId=?";
    private static final String DROP_TABLE = "DROP TABLE ";
    private static final String SELECT_SYNC = "SELECT action,area,currentTime,videoId  FROM rooms WHERE roomid='";
    private static final String SELECT_TIME = "SELECT time  FROM rooms WHERE roomid=";
    private static final String UPDATE_SYNC = "UPDATE rooms SET action=?,area=?,currentTime=?,videoId=? WHERE roomId=?";
    private static final String UPDATE_TIME = "UPDATE rooms SET time=? WHERE roomId=?";
    
    public String getTime(String roomId) throws LWException{
        String time="not set";
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
                
                )
        {
            try(ResultSet rs = stmt.executeQuery(SELECT_TIME +"'" +roomId+"'");){
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
    
    
    public void updateTime(String time,String roomId) throws LWException{
        try(
                Connection connection = RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_TIME);
                ){
                pstmt.setString(1, time);
                pstmt.setString(2, roomId);
                pstmt.executeUpdate();
       }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("連線失敗" ,ex);
        }
    }
    
    
    
    
    
    public Room getSyncInfo(String roomId) throws LWException{
        Room r=null;
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_SYNC + roomId+"'");
            )
        {
            
            while(rs.next()){
                r = new Room();
                r.setAction(rs.getString("action"));
                r.setArea(rs.getString("area"));
                r.setCurrentTime(rs.getString("currentTime"));
                r.setVideoId(rs.getString("videoId"));
            }
            System.out.println();
            return r;
            
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
        }catch(LWException ex){
                throw new LWException("Connection or Statement failed!", ex);
        }
    
    }
    
    
    public void updateSyncInfo(Room r ,String roomId) throws LWException{
        try(
                Connection connection = RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(UPDATE_SYNC);
                ){
                pstmt.setString(1, r.getAction());
                pstmt.setString(2, r.getArea());
                pstmt.setString(3, r.getCurrentTime());
                pstmt.setString(4, r.getVideoId());
                pstmt.setString(5, roomId);
                pstmt.executeUpdate();
                System.out.println(pstmt);
       }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("連線失敗" ,ex);
        }
    }
    
    
    @Override
    public List<Room> getAll() throws LWException {
         List<Room> rlist = new ArrayList<>();
        try(Connection con = RDBMemConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
                ){
            while(rs.next()){
                Room r = new Room();
                r.setRoomId(rs.getString("roomId"));
                r.setOwnerId(rs.getString("ownerId"));
                r.setRoomName(rs.getString("roomName"));
                r.setwCoin(rs.getInt("wCoin"));
                r.setRoomPwd(rs.getString("roomPwd"));
                r.setChatRoomId(rs.getString("chatroomId"));
                r.setPlayMode(rs.getInt("playMode"));
                r.setVideoPlayNow(rs.getString("videoPlayNow"));
                r.setVideoWhereNow(rs.getString("videoWhereNow"));
                r.setRoomType(rs.getInt("roomType"));
                System.out.println(stmt);
                rlist.add(r);
            
            }
        return rlist;
        }catch(SQLException ex){
            throw new LWException("Connection or Statement failed!", ex);
        }
    }
    
//    public List<Room> getAll(String roomId) throws LWException {
//        List<Room> rlist = new ArrayList<>();
//        try(Connection con = RDBMemConnection.getConnection();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(SELECT_ALL + roomId);
//                ){
//            while(rs.next()){
//                Room r = new Room();
//                r.setRoomId(rs.getString("roomId"));
//                r.setOwnerId(rs.getString("ownerId"));
//                r.setRoomName(rs.getString("roomName"));
//                r.setwCoin(rs.getInt("wCoin"));
//                r.setRoomPwd(rs.getString("roomPwd"));
//                r.setChatRoomId(rs.getString("chatroomId"));
//                r.setPlayMode(rs.getInt("playMode"));
//                r.setVideoPlayNow(rs.getString("videoPlayNow"));
//                r.setVideoWhereNow(rs.getString("videoWhereNow"));
//                r.setRoomType(rs.getInt("roomType"));
//                System.out.println(stmt);
//                rlist.add(r);
//            
//            }
//        return rlist;
//        }catch(SQLException ex){
//            throw new LWException("Connection or Statement failed!", ex);
//        }
//    }

    @Override
    public Room getOneById(String id) throws LWException, SQLException {
        Room r = new Room();
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ROOM_BY_ID)
                )
        {
            pstmt.setString(1, id);
            try(ResultSet rs = pstmt.executeQuery();){
                while(rs.next()){
                r.setRoomId(rs.getString("roomId"));
                r.setOwnerId(rs.getString("ownerId"));
                r.setRoomName(rs.getString("roomName"));
                r.setwCoin(rs.getInt("wCoin"));
                r.setRoomPwd(rs.getString("roomPwd"));
                r.setChatRoomId(rs.getString("chatroomId"));
                r.setPlayMode(rs.getInt("playMode"));
                r.setVideoPlayNow(rs.getString("videoPlayNow"));
                r.setVideoWhereNow(rs.getString("videoWhereNow"));
                r.setRoomType(rs.getInt("roomType"));
                }
                return r;
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
    }

    @Override
    public void insert(Room r) throws LWException {
       
       try(
                Connection connection = RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_ROOM);
                ){
                pstmt.setString(1, r.getRoomId());
                pstmt.setString(2, r.getOwnerId());
                pstmt.setString(3, r.getRoomName());
                pstmt.setInt(4, r.getwCoin());
                pstmt.setString(5, r.getRoomPwd());
                pstmt.setString(6, r.getChatRoomId());
                pstmt.setInt(7, r.getPlayMode());
                pstmt.setString(8, r.getVideoPlayNow());
                pstmt.setString(9,r.getVideoWhereNow());
                pstmt.setInt(10,r.getRoomType());
                pstmt.executeUpdate();
       
       }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
            }catch(SQLException ex){
                throw new LWException("連線失敗" ,ex);
            }
       
    }

    @Override
    public void update(Room m, String id) throws LWException {
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_rooms);
        ){
                pstmt.setString(1, m.getOwnerId());
                pstmt.setString(2, m.getRoomName());
                pstmt.setInt(3, m.getwCoin());
                pstmt.setString(4, m.getRoomPwd());
                pstmt.setString(5, m.getChatRoomId());
                pstmt.setInt(6, m.getPlayMode());
                pstmt.setString(7, m.getVideoPlayNow());
                pstmt.setString(8,m.getVideoWhereNow());
                pstmt.setInt(9,m.getRoomType());
                pstmt.setString(10,m.getRoomId());
                pstmt.executeUpdate();
        
        }catch(LWException ex){
            throw new LWException("更新資料失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("更新資料失敗" ,ex);
        }
    }

    @Override
    public void createTable(String id) throws LWException {
    }

    @Override
    public void deleteTable(String tableName) throws LWException {
        try(
                Connection con = RDBMemConnection.getConnection();
                Statement stmt = con.createStatement();
                ) {
            String sql = DROP_TABLE + tableName;
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (LWException ex) {
            throw new LWException ("RDBMemberConnection error!", ex);
        } catch (SQLException ex) {
            throw new LWException ("SQL error!", ex);
        }
    }

    @Override
    public void delete(String roomId) throws LWException {
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(DELETE_ROOM);
        ){
            pstmt.setString(1, roomId);
            pstmt.executeUpdate();
            
    }catch(LWException ex){
            throw new LWException("更新資料失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("更新資料失敗" ,ex);
        }
    }
    
    
}
