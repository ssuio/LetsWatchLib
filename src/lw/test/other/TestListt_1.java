/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.other;

import java.util.*;
/**
 *
 * @author adm
 */
public class TestListt_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int b =1;
        list.add(b);//auto-boxing
        list.add(1);
        list.add(0,3);
        list.add(4);
        list.add(null);
        System.out.println(list);
        Iterator<Integer> i = list.iterator();
        double sum = 0;
        while(i.hasNext()){
            Integer data = i.next();
            if(data!=null){
               sum+= data;
            }
        }
        System.out.println(sum);
    }
}
