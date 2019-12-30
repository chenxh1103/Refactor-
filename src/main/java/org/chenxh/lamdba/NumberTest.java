package org.chenxh.lamdba;

import java.util.ArrayList;
import java.util.List;

public class NumberTest {

    public void Array(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(String.valueOf(i));
        }
        list.forEach(x->System.out.println(x+5));
    }
    public void lambda(){
        Number number = (a,b)->{int c = a+b;System.out.println(c);return c;};
        int value = number.add(1,4);
        System.out.println(value);
        Thread thread = new Thread(()->{int c =4;System.out.println(c);});
        thread.start();
    }
    public static void main(String[] args) {
        NumberTest numberTest = new NumberTest();
        numberTest.lambda();
        numberTest.Array();
    }
}
