/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.Room;
import lw.model.RoomService;

/**
 *
 * @author adm
 */
public class TestCreateRoom {
    public static void main(String[] args) {
        RoomService rs = new RoomService();
        Room r = new Room();
        r.setRoomName("PocketRoom");
        r.setwCoin(1000);
        r.setRoomType(5);
        r.setRoomPwd("123456");
        r.setOwnerId("M00000000");
        try {
            rs.createRoom(r);
        } catch (LWException ex) {
            Logger.getLogger(TestCreateRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
