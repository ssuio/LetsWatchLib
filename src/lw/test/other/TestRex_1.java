/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.other;

/**
 *
 * @author adm
 */
public class TestRex_1 {
    public static void main(String[] args) {
        String str = "com.mysql.jdbc.JDBC4PreparedStatement@506c589e: INSERT INTO lw.'m88888888buyhistory' (orderId, buydate, product, price, pay, state ) VALUES('O99999999','1989-08-06','Wcoin 500 point',100,'ATM','closed')";
        String str2 = str.replaceAll(".*: ", "");
        str2 = str2.replaceAll("\\.'", ".");
        str2 = str2.replaceAll("' ", " ");
        System.out.println(str2);
        
    }
}
