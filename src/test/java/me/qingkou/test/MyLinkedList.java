package me.qingkou.test;

/**
 * Created with IntelliJ IDEA.
 * User: sshli
 * Date: 10/29/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyLinkedList<T> {

    public final Node<T> head;

    public MyLinkedList(T head) {
        this.head = new Node<T>(head);
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);
        Node<T> end = head;
        while(end.next != null) {
            end = end.next;
        }
        end.next = node;
    }

    public T get(int index) {
        Node<T> n = head;
        while(index > 0) {
            n = n.next;
            index --;
        }
        return n.value;
    }

    private class Node<S> {
        private S value = null;
        private Node<S> next  = null;

        public Node(S value) {
            this.value = value;
        }

        public void setNext(Node<S> node) {
            this.next = node;
        }

        public Node getNext() {
            return next;
        }
    }
    public static void main(String[] dsasasd) {
        MyLinkedList<Integer> l = new MyLinkedList<Integer>(2);
        l.add(9);
        l.add(10);
        l.add(11);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.get(3));
    }
}
