package me.qingkou.test;

/**
 * User: seeker
 * Date: 10/26/13
 * Time: 3:03 PM
 */
class Node{
    private Node lChild = null;
    private Node rChild = null;

    private int value = 0;

    public Node(Node l, Node r, int v) {
        this.lChild = l;
        this.rChild = r;
        this.value = v;
    }

    public Node appendLeftChild(Node n){
        this.lChild = n;
        return this;
    }

    public Node appendRightChild(Node n) {
        this.rChild = n;
        return this;
    }

    public Node getLeftChild() {
        return lChild;
    }

    public Node getRightChild() {
        return rChild;
    }

    public int getValue() {
        return value;
    }
}
