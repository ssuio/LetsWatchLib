/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.select;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.model.RDBBuyHistoryDAO;

/**
 *
 * @author adm
 */
public class TestGetAllBuyHistory_1 {
    public static void main(String[] args) {
        try {
            RDBBuyHistoryDAO dao = new RDBBuyHistoryDAO();
            System.out.println(dao.getOneById("m88888888"));
        } catch (LWException ex) {
            Logger.getLogger(TestGetAllBuyHistory_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
