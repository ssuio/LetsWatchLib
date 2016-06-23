/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.other;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author adm
 */
public class TestSet_1 {
    public static void main(String[] args) {
        Set set = new HashSet();
        
        set.add(1);
        set.add(2.0);
        set.add('3');
        set.add("4");
        for(Object o: set){
            
        
        }
        System.out.println(set);
        
    }
}
