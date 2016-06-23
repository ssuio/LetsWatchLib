/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

import java.util.List;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.RDBMemberDAO;

/**
 *
 * @author Cyruss
 */
public class TestMemberDBgetAll_1 {
    public static void main(String[] args) {
        RDBMemberDAO r = new RDBMemberDAO();
        List<Member> m;
        try{
        m = r.getAll();
        System.out.println(m);
        }catch(LWException ex){
            System.out.println("FAILED!");
        }
        
    }
}
