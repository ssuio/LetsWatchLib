/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Member;
import lw.model.MemberService;

/**
 *
 * @author adm
 */
public class TestRegister_1 {
    public static void main(String[] args) {
        try {
            MemberService ms = new MemberService();
            Member m = new Member();
            m.setEmail("ssuio22@gmail.com");
            m.setId("M88888887");
            m.setName("ssuio22");
            m.setPwd("Abcd1234");
            ms.register(m);
        } catch (LWException ex) {
            Logger.getLogger(TestRegister_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
