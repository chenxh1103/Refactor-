package org.chenxh.dataStructrue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    @Test
    public void size() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void get() throws Exception {
        List list = new LinkedList();
    }
    @Test
    public void test(){
        MyList<Integer> myList = new MyLinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.remove(0);
        myList.remove(myList.size()-1);

        System.out.println(myList.size());
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        List a = new LinkedList();
    }
}