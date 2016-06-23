/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.PlayList;
import lw.model.PlayListDAO;

/**
 *
 * @author Cyruss
 */
public class TestPlayListDAOGetLists {
    public static void main(String[] args) {
        try {
            List<PlayList> list;
            PlayListDAO dao = new PlayListDAO();
            String s = dao.getTime("R16060038");
                System.out.println(s);
        } catch (LWException ex) {
            Logger.getLogger(TestPlayListDAOGetLists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
