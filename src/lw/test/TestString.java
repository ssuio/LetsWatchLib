/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test;

/**
 *
 * @author adm
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = str1;
        
        str2=str2.replaceAll("e", "a");
        
        System.out.println(str1);
        System.out.println(str2);
    }
}
