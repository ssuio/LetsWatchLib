/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import lw.domain.LWException;

/**
 *
 * @author adm
 */
public class RDBMemConnection {
    private static final String driver; // = "com.mysql.jdbc.Driver";
    private static final String url; // = "jdbc:mysql://localhost:3306/lw?zeroDateTimeBehavior=convertToNull";
    private static final String userid; // = "root";
    private static final String pwd; // = "1234";
    
    static{
        ResourceBundle bundle = null;
        try{
            bundle = ResourceBundle.getBundle("lw.model.dao");
        }catch(Exception ex){
        }
        
        if (bundle != null){
            
            String dr = bundle.getString("jdbc.driver");
            if (dr != null){
                driver = dr;
            }else{
                driver = "com.mysql.jdbc.Driver";
            }
            
            String ur = bundle.getString("jdbc.url");
            if (ur != null){
                url = ur;
            }else{
                url = "jdbc:mysql://localhost:3306/lw?zeroDateTimeBehavior=convertToNull";
            }
            
            String us = bundle.getString("jdbc.userid");
            if (dr != null){
                userid = us;
            }else{
                userid = "root";
            }
            
            String pw = bundle.getString("jdbc.password");
            if(pw != null){
                pwd = pw;
            }else{
                pwd = "1234";
            }
           
        
       }else {
            
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/lw?zeroDateTimeBehavior=convertToNull";
            userid = "root";
            pwd = "1234";
            
        }
               
        
    
    
    }
    
    public static Connection getConnection() throws LWException{
        Connection connection;    
        Context ctx;
        DataSource ds = null;
        try{
            ctx = new InitialContext();
            //由server connection pool 取得連線
            //if(ctx ==null) throw new RuntimeException("JNDI Context 是 null!");
            
            
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lw");
            if(ds==null) throw new RuntimeException("無法取得DataSource.");
            
            connection = ds.getConnection();
            System.out.println("Connection Pool: " + connection);
            return connection;
        }catch (NamingException|RuntimeException|SQLException nex){
            System.out.println("無法取得Naming Service" + nex);
            try {
                Class.forName(driver);

                //2. 建立Connection
                try{
                    connection = DriverManager.getConnection(url, userid, pwd);
                    return connection;
                }catch(SQLException ex){
                   // System.out.println("無法建立連線");
                    throw new LWException("無法建立連線", ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RDBMemConnection.class.getName()).log(Level.SEVERE, null, ex);
                 throw new LWException("無法載入JDBC Driver: "+driver, ex);
            }
      }
    }
    
    
        
}
