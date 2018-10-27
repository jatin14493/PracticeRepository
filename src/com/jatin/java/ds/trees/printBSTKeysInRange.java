package com.jatin.java.ds.trees;

public class printBSTKeysInRange {
    Node root;

    public static void main(String[] args) {

        printBSTKeysInRange tree = new printBSTKeysInRange();
        int k1 = 10, k2 = 25;
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);

        tree.Print(tree.root, k1, k2);
    }

    private void Print(Node root, int k1, int k2) {

        if(root==null)
            return;

        if(root.data > k1){
            Print(root.left,k1,k2);
        }

        if(root.data > k1 && root.data < k2){
            System.out.println(root.data + " ");
        }


        if(root.data < k2){
            Print(root.right,k1,k2);
        }

    }
}
