package me.qingkou.test;

/**
 * Created with IntelliJ IDEA.
 * User: sshli
 * Date: 10/25/13
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinTree {

    public static void printValue(Node n) {
        System.out.println(n.getValue());
        if(n.getLeftChild() != null) {
            printValue(n.getLeftChild());
        }
        if(n.getRightChild() != null) {
            printValue(n.getRightChild());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(null, null, 90);
        root.appendLeftChild(new Node(null, null, 890));
        root.appendRightChild(new Node(new Node(null, null, 799), new Node(null, null, 79), 80));

        printValue(root);
    }

    public boolean isBalanced(Node n) {
        int maxD = 0;
        int minD = 0;
        return true;
    }
}