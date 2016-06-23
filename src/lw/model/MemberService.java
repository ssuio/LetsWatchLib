/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.SQLException;
import lw.domain.LWException;
import lw.domain.Member;

/**
 *
 * @author adm
 */
public class MemberService {
    private RDBMemberDAO dao = new RDBMemberDAO();
    
    public void register(Member m) throws LWException{
        RDBBuyHistoryDAO buyHistoryDAO = new RDBBuyHistoryDAO();
        dao.insert(m);
        buyHistoryDAO.createTable(m.getId());
        dao.updateWcoin(m, 5000);
    }
    
    public Member login(String email, String pwd) throws LWException{
        Member m=null;
        //        if(id==null || pwd==null){
        //            throw new LWException("帳號密碼不得為null");
        //        }
        try{
            m = dao.getOneByEmail(email);
        }catch (LWException ex){
            throw new LWException("登入失敗,帳號或密碼不符", ex);
        }catch(SQLException ex){
            throw new LWException("登入失敗,帳號或密碼不符",ex);
        }
        if (m != null && pwd.equals(m.getPwd())){
            return m;
        }
        
       throw new LWException("登入失敗,帳號或密碼不符");
       
    }
    
    
    
    public void update(Member m, String id)throws LWException{
        dao.update(m,id);
    }
}
