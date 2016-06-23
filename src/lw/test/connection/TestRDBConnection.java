/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.connection;

import java.sql.Connection;
import lw.model.RDBMemConnection;

/**
 *
 * @author adm
 */
public class TestRDBConnection {
    public static void main(String[] args) {
        try(Connection c = RDBMemConnection.getConnection()){
            System.out.println(c.getCatalog());
        }catch(Exception ex){
        
        }
    }
}
