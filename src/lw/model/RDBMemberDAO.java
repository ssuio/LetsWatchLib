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
 * @author adm
 */
public class RDBMemberDAO implements lwMysqlDAO<Member,Member> {
    private static final String COL_LIST = "id, name, email, pwd, birthday, wCoin, phone, gender, epaper, introduction, status, roomId";
    private static final String SELECT_MEMBER_BY_ID = "SELECT "+ COL_LIST + " FROM member WHERE id=?";
    private static final String SELECT_MEMBER_BY_EMAIL = "SELECT "+ COL_LIST +" FROM member WHERE email=?";
    private static final String SELECT_ALL_MEMBER = "SELECT "+ COL_LIST +" FROM Member";
    private static final String INSERT_MEMBER = "INSERT INTO member "+ "( "+ COL_LIST + " ) " +
    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_WCOIN = "UPDATE member SET wCoin=? WHERE id=?";
    private static final String UPDATE_Member = "UPDATE member "
            + "SET name=?,pwd=?,birthday=?,phone=?,gender=?,epaper=?,introduction=?,roomId=?"
            + " WHERE id=?";
    
    


    
    
    
    @Override
    public void insert(Member m) throws LWException{
            try(
                Connection connection = RDBMemConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(INSERT_MEMBER);
                ){
                pstmt.setString(1, m.getId());
                pstmt.setString(2, m.getName());
                pstmt.setString(3, m.getEmail());
                pstmt.setString(4, m.getPwd());
                pstmt.setDate(5, m.getBirthday()!=null?new java.sql.Date (m.getBirthday().getTime()):null);
                pstmt.setInt(6, m.getwCoin());
                pstmt.setString(7, m.getPhone());
                pstmt.setString(8, (m.getGender()) + "");
                pstmt.setBoolean(9, m.isEpaper());
                pstmt.setString(10, m.getIntroduction());
               pstmt.setInt(11, m.getStatus());
               pstmt.setString(12, m.getRoomId());
                
                pstmt.executeUpdate();
                
            }catch(LWException ex){
                throw new LWException("連線失敗!",ex);
            }catch(SQLException ex){
                throw new LWException("連線失敗" ,ex);
            }
    }
    
    @Override
    public List<Member> getAll() throws LWException{
        List<Member> memberList = new ArrayList<>();
        try(
            Connection con = RDBMemConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_MEMBER);
                )
        {
            while (rs.next()){
                Member m = new Member();
                try{
                    m.setId(rs.getString("id"));
                    m.setName((rs.getString("name")));
                    m.setEmail(rs.getString("email"));
                    m.setPwd(rs.getString("pwd"));
                    m.setBirthday(rs.getDate("birthday"));
                    m.setwCoin(rs.getInt("wCoin"));
                    m.setPhone(rs.getString("phone"));
                    m.setGender(rs.getString("gender").charAt(0));
                    m.setEpaper(rs.getBoolean("epaper"));
                    m.setIntroduction(rs.getString("introduction"));
                    m.setStatus(rs.getInt("status"));
                    memberList.add(m);
                }catch (LWException ex){
                    throw new LWException("Set failed", ex);
                }
          }
        }catch(SQLException ex){
            throw new LWException("Connection or Statement failed!", ex);
        }
         return memberList;
    }
    
    
    @Override
    public Member getOneById(String id) throws LWException, SQLException{
        Member m = new Member();
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER_BY_ID)
                )
        {
            pstmt.setString(1,id);
            try(ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    try{
                        m.setId(rs.getString("id"));
                        m.setName((rs.getString("name")));
                        m.setEmail(rs.getString("email"));
                        m.setPwd(rs.getString("pwd"));
                        m.setBirthday(rs.getDate("birthday"));
                        m.setwCoin(rs.getInt("wCoin"));
                        m.setPhone(rs.getString("phone"));
                        m.setGender(rs.getString("gender").charAt(0));
                        m.setEpaper(rs.getBoolean("epaper"));
                        m.setIntroduction(rs.getString("introduction"));
                        m.setStatus(rs.getInt("status"));
                        m.setRoomId(rs.getString("roomId"));
                    }catch (LWException ex){
                        throw new LWException("資料讀取錯誤", ex);
                    }
                }
            }catch(SQLException ex){
                throw new LWException("Connection or Statement failed!", ex);
            }
        return m;
        }
    }
    
     public Member getOneByEmail(String email) throws LWException, SQLException{
        Member m = new Member();
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT_MEMBER_BY_EMAIL)){
            pstmt.setString(1,email);
            //System.out.println("HERE");
               try(ResultSet rs = pstmt.executeQuery();){
                   //System.out.println("OUT WHILE");
                    while (rs.next()){
                        m.setId(rs.getString("id"));
                        m.setName((rs.getString("name")));
                        m.setEmail(rs.getString("email"));
                        m.setPwd(rs.getString("pwd")!=null?rs.getString("pwd"):null);
                        m.setBirthday(rs.getDate("birthday"));
                        m.setwCoin(rs.getInt("wCoin"));
                        m.setPhone(rs.getString("phone"));
                        m.setGender(rs.getString("gender").charAt(0));
                        m.setEpaper(rs.getBoolean("epaper"));
                        m.setIntroduction(rs.getString("introduction"));
                        m.setRoomId(rs.getString("roomId"));
                        }
                }catch (LWException ex){
                    throw new LWException("資料讀取錯誤", ex);
                }catch(SQLException ex){
                    throw new LWException("Connection or Statement failed!", ex);
                }
        return m;
        }
    }
    
    public void updateWcoin(Member m, int wCoin ) throws LWException{
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_WCOIN);
        ){
        pstmt.setInt(1, (m.getwCoin()+wCoin));
        pstmt.setString(2, m.getId());
        pstmt.executeUpdate();
        }catch(LWException ex){
            throw new LWException("連線失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("連線失敗" ,ex);
        }
   }
    
    
    @Override
    public void update(Member m, String id) throws LWException{
        RDBMemberDAO dao = new RDBMemberDAO();
        try(
            Connection connection = RDBMemConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_Member);
        ){
            //name=?,pwd=?,birthday=?,phone=?,gender=?,epaper=?,introduction=? WHERE id=?";
            Member mOrigin = dao.getOneById(id);
            pstmt.setString(1, m.getName()!=null?m.getName():mOrigin.getName());
            pstmt.setString(2, m.getPwd()!=null?m.getPwd():mOrigin.getPwd());
            
            //Birthday
            if (m.getBirthday()==null && mOrigin.getBirthday()!=null){
                pstmt.setDate(3, new java.sql.Date (mOrigin.getBirthday().getTime()));
            }else if(m.getBirthday()==null && mOrigin.getBirthday()==null){
                pstmt.setDate(3,null);
            }else if(m.getBirthday()!=null){
                pstmt.setDate(3,new java.sql.Date(m.getBirthday().getTime()));
            }
            
            pstmt.setString(4,m.getPhone()!=null?m.getPhone():mOrigin.getPhone());
            pstmt.setString(5, m.getGender()+"");
            pstmt.setBoolean(6, m.isEpaper());
            pstmt.setString(7, m.getIntroduction()==null?mOrigin.getIntroduction():m.getIntroduction());
            pstmt.setString(8, m.getRoomId());
            pstmt.setString(9, id);
            pstmt.executeUpdate();
            }catch(LWException ex){
            throw new LWException("更新資料失敗!",ex);
        }catch(SQLException ex){
            throw new LWException("更新資料失敗" ,ex);
        }
        
        
        
    }

    @Override
    public void createTable(String id) throws LWException {
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
