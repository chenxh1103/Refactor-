package org.chenxh.dataStructrue.Iterable;

import org.chenxh.dataStructrue.MyLinkedList;

public class MyLinkedListIterator<T> implements MyIterator<T>{
    private MyLinkedList<T> myLinkedList;

    public MyLinkedListIterator(MyLinkedList<T> myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
