package org.chenxh.dataStructrue;

public interface MyList<E> {

    int size();
    void add(E e);
    void clear();
    void remove(int index);
    E get(int index);
}
