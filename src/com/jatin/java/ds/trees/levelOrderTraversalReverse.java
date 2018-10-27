package com.jatin.java.ds.trees;

import java.util.LinkedList;
import java.util.Stack;

public class levelOrderTraversalReverse {

    Tree root;

    public static void main(String[] args) {
        levelOrderTraversalReverse object = new levelOrderTraversalReverse();
        object.root = new Tree(1);
        object.root.left = new Tree(2);
        object.root.right = new Tree(3);
        object.root.left.left = new Tree(4);
        object.root.left.right = new Tree(5);
        object.root.right.left = new Tree(6);
        object.root.right.right = new Tree(7);

        printLevelOrderTraversal(object.root);

    }

    private static void printLevelOrderTraversal(Tree root) {
        LinkedList<Tree> list = new LinkedList<>();
        Stack<Tree> stack = new Stack<>();

        if(root!=null)
            list.add(root);

        while(!list.isEmpty()){
            Tree temp = list.removeFirst();
            if(temp.left!=null){
                list.add(temp.left);
            }

            if(temp.right!=null){
                list.add(temp.right);
            }
            stack.push(temp);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }

    }
}
