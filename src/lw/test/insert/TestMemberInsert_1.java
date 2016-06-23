/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.sql.SQLException;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author adm
 */
public class TestMemberInsert_1 {
    public static void main(String[] args) {
        RDBMemberDAO dao = new RDBMemberDAO();
        Member m =null;
        try{
            m = new Member();
        m.setEmail("kooo@gmail.com");
        m.setPwd("Abcd1234");
        m.setId("1111");
        m.setName("00000000");
        m.setBirthday("2016/08/06");
        dao.insert(m);
        
            System.out.println(dao.getOneByEmail("eeeilsa@gmail.com"));
        
        }catch (LWException ex){
            System.out.println("Add people failed" + ex);
        
        }catch (SQLException ex){
            System.out.println("SQL Add people failed" + ex);
        }
    }
}
