/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.update;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author adm
 */
public class TestUpdateMember_1 {
    public static void main(String[] args) {
        try {
            RDBMemberDAO dao = new RDBMemberDAO();
            
            Member m = new Member();
            
//            m.setBirthday("1989/8/6");
//            dao.update(m, 9529);
            
            System.out.println(dao.getOneByEmail("karl@gmail.com"));
        } catch (LWException ex) {
            Logger.getLogger(TestUpdateMember_1.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            
        }
    }
}
