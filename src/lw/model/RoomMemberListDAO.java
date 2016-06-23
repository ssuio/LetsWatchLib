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
import lw.domain.Member;

/**
 *
 * @author Cyruss
 */
public class RoomMemberListDAO implements lwMysqlDAO<List<Member>, List<Member>>{
    private static final String DROP_TABLE = "DROP TABLE ";
    private static final String INSERT_PLAYLIST = "INSERT INTO lw.? "+ "(memberId,memberName) " +
    "VALUES(?,?)";
    private static final String SELECT_MEMBERLIST = "SELECT memberId,memberName FROM ";
    
    @Override
    public List<List<Member>> getAll() throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Member> getOneById(String roomId) throws LWException, SQLException {
        List<Member> mlist = new ArrayList<>();
        
        try(
            Connection con = RDBMemConnection.getConnection();
             Statement stmt = con.createStatement();
                
                )
        {
            try(ResultSet rs = stmt.executeQuery(SELECT_MEMBERLIST + roomId + "memberList");){
                while(rs.next()){
                    Member m = new Member();
                    m.setId(rs.getString("memberId"));
                    m.setName(rs.getString("memberName"));
                    mlist.add(m);
                }
//                System.out.println(mlist);
                return mlist;
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        
    }

    @Override
    public void insert(List<Member> m) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void insert(Member m, String roomId) throws LWException {
           try(
                Connection con = RDBMemConnection.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_PLAYLIST);
                   Statement stmt = con.createStatement();
                ){
                pstmt.setString(1, roomId + "memberList");
                pstmt.setString(2, m.getId());
                pstmt.setString(3, m.getName()==null?"anonymous":m.getName());
                System.out.println(pstmt);
                String sql=pstmt + "";
                sql = sql.replaceAll(".*: ", "");
                sql = sql.replaceAll("\\.'", ".");
                sql = sql.replaceAll("' ", " ");
                System.out.println(sql);
                stmt.executeUpdate(sql);
       
       }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
            }catch(SQLException ex){
                throw new LWException("連線失敗" ,ex);
            }
    }

    @Override
    public void update(List<Member> m, String id) throws LWException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createTable(String roomId) throws LWException {
         String CREAT_BUYHISTORY_TABLE = "CREATE TABLE lw."+ roomId +"MemberList " 
            + "(memberId VARCHAR(45),"
            + " memberName VARCHAR(45) NULL DEFAULT 'anonymous',"
            + " PRIMARY KEY (MemberId));";
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
            String sql = DROP_TABLE + roomId +"MemberList";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void delete(String roomId, Member m) throws LWException {
        String DELETE_MEMBER_FROM_LIST = "DELETE FROM "+ roomId + "memberList WHERE memberId=?";
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(DELETE_MEMBER_FROM_LIST);
        ){
            pstmt.setString(1, m.getId());
            pstmt.executeUpdate();
            
    }catch(LWException ex){
            throw new LWException("更新資料失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("更新資料失敗" ,ex);
        }
    }
    
}
