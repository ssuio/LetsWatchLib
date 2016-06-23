/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.delete;

import lw.model.RoomService;

/**
 *
 * @author Cyruss
 */
public class TestDeleteRoomTotally {
    public static void main(String[] args) {
        RoomService rs = new RoomService();
        rs.deleteAllRoom();
    }
}
