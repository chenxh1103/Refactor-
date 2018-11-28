package org.chenxh.dataStructrue;

public class MyLinkedList<E> implements  MyList<E>{

    private Node<E> frist;
    private Node<E> last;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<E>(e);
        if(size == 0){
            frist = node;
            last = node;
        }else{
            last.setNext(node);
            last = node;
        }
        size ++ ;
    }

    @Override
    public void clear() {
        frist = null;
        last = null;
        size = 0;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            if(frist == last){
                frist = null;
                last = null;
            }else{
                frist = frist.getNext();
            }
        }else if(index == size - 1){
            Node<E> node = frist;
            while (node.getNext()!=last){
                node = node.getNext();
            }
            last = node;
        }else {
            Node<E> node = frist;
            Node<E> pre = null;
            for (int i = 1;i <= index;i++){
                pre = node;
                node = node.getNext();
            }
            pre.setNext(node.getNext());
        }
        size --;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = frist;
        for (int i = 1;i <= index;i++){
            node = node.getNext();
        }
        return node.getE();
    }

}
