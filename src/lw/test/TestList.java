/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5ccc");
        
        for(String msg:list)
        System.out.println(msg);
    }
}
