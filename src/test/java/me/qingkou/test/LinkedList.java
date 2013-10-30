package me.qingkou.test;

/**
 * User: seeker
 * Date: 10/28/13
 * Time: 9:33 PM
 */
public class LinkedList {



    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private int getValue() {
            return value;
        }
    }
}


