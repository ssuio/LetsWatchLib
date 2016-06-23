/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author adm
 */
public class TestTime {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("toString(): " + now); 
        
        Calendar cal = Calendar.getInstance();
        System.out.println("Hour:" + cal.get(Calendar.HOUR)+" Min:"+ cal.get(Calendar.MINUTE)+" Sec:"+cal.get(Calendar.SECOND));
    }
}
