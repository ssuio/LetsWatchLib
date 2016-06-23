/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.BuyHistory;
import lw.domain.LWException;
import lw.domain.PayWay;
import lw.model.RDBBuyHistoryDAO;

/**
 *
 * @author adm
 */
public class TestBuyHistoryInsert1 {
    public static void main(String[] args) {
        try {
            RDBBuyHistoryDAO dao = new RDBBuyHistoryDAO();
            BuyHistory bh = new BuyHistory();
            bh.setBuydate("1989/08/06");
            bh.setOrderId("O99999998");
            bh.setPay(PayWay.ATM);
            bh.setPrice(100);
            bh.setProduct("Wcoin 500 point");
            bh.setState("closed");
            dao.insert(bh,"m88888888");
        } catch (LWException ex) {
            Logger.getLogger(TestBuyHistoryInsert1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
