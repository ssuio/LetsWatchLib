/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.update;

import java.sql.SQLException;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author adm
 */
public class TestUpdateWcoin_1 {
    public static void main(String[] args) {
        RDBMemberDAO mDAO = new RDBMemberDAO();
        try{
            
            Member m = mDAO.getOneByEmail("xssuio@gmail.com");
            
            System.out.println(m + "STORE 50000$");
            mDAO.updateWcoin(m, -50000000);
            Member mafter = mDAO.getOneByEmail("xssuio@gmail.com");
            System.out.println(mafter);
        }catch(SQLException ex){
            System.out.println("SQL error" + ex);
        }catch(LWException ex){
            System.out.println("LW " + ex);
        }
        
    }
}
