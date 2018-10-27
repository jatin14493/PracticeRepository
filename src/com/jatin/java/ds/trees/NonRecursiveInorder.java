package com.jatin.java.ds.trees;

import java.util.Stack;

public class NonRecursiveInorder {

    Node root;
    public static void main(String[] args) {

        NonRecursiveInorder tree = new NonRecursiveInorder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }

    private void inorder() {

        if(root==null)
            return;

        Node current = root;
        Stack<Node> s = new Stack<Node>();


        while(current !=null || s.size()>0){

            while(current != null){
                s.push(current);
                current = current.left;
            }


            //current must be null at this point
            current = s.pop();
            System.out.println(current.data +"");

            current = current.right;

        }
    }
}
