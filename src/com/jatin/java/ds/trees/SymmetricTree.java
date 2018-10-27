package com.jatin.java.ds.trees;


public class SymmetricTree {

    Node root;

    public static void main(String[] args) {

        SymmetricTree tree = new SymmetricTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        boolean input = isMirror(tree.root,tree.root);
        if(input)
            System.out.println("Symmetric Tree!!!");
        else
            System.out.println("No Symmetry!!");
    }

    private static boolean isMirror(Node node1, Node node2) {

        if(node1!=null && node2!=null)
            return true;

        if(node1!=null && node2!=null && node1.data==node2.data)
            return(isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left));

        return false;
    }

}
