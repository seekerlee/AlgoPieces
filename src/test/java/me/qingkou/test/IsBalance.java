package me.qingkou.test;

/**
 * User: seeker
 * Date: 10/26/13
 * Time: 3:05 PM
 */
public class IsBalance {
    private int deep = 0;
    private int shallow = Integer.MAX_VALUE;

    public boolean isBalance(Node root, int depth) {
        if(depth - shallow > 1) return false;
        // reach end
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            if(depth > deep) deep = depth;
            if(depth < shallow) shallow = depth;
            return (deep - shallow <= 1);
        } else if (root.getLeftChild() != null && root.getRightChild() == null) {
            return isBalance(root.getLeftChild(), depth + 1);
        } else if(root.getRightChild() != null && root.getLeftChild() == null) {
            return isBalance(root.getRightChild(), depth + 1);
        } else {
            return isBalance(root.getRightChild(), depth + 1) && isBalance(root.getLeftChild(), depth + 1);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(null, null, 90);
        root.appendLeftChild(new Node(null, null, 890));
        root.appendRightChild(new Node(new Node(null, null, 799), new Node(null, new Node(null, null, 77), 79), 80));

        System.out.println(new IsBalance().isBalance(root, 0));
    }
}
