/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.services;

import lw.domain.Member;
import lw.model.RoomService;

/**
 *
 * @author adm
 */
public class TestLeaveRoom {
    public static void main(String[] args) {
        RoomService rs = new RoomService();
        Member m = new Member();
        m.setId("M11191119");
        System.out.println(m.getName());
        rs.leaveRoom(m, "R16060006");
    }
}
