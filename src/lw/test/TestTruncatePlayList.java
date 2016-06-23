/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.PlayListDAO;

/**
 *
 * @author Cyruss
 */
public class TestTruncatePlayList {
    public static void main(String[] args) {
        try {
            PlayListDAO dao = new PlayListDAO();
            dao.cleanTable("r16060033");
        } catch (LWException ex) {
            Logger.getLogger(TestTruncatePlayList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
