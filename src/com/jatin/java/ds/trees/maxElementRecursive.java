package com.jatin.java.ds.trees;

import java.util.LinkedList;

class Tree{
    int data;
    Tree left;
    Tree right;
    public Tree(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class maxElementRecursive {
    Tree root;

    public static void main(String[] args) {
        maxElementRecursive object = new maxElementRecursive();
        object.root = new Tree(16);
        object.root.left = new Tree(5);
        object.root.right = new Tree(23);
        object.root.left.left = new Tree(21);
        object.root.left.right = new Tree(43);
        object.root.right.left = new Tree(27);
        object.root.right.right = new Tree(9);
        //recursive implementation
        //int maxElement = maxElement(object.root);
        int maxElement = nonRecursive(object.root);
        System.out.println("Max Value :" + maxElement);
    }

    private static int nonRecursive(Tree root) {
        int maxVal = Integer.MIN_VALUE;
        LinkedList<Tree> queue = new LinkedList<>();
        if(root!=null)
        queue.add(root);
        while(!queue.isEmpty()){
            Tree temp = queue.removeFirst();
            if(temp!= null){
                if(temp.data > maxVal){
                    maxVal = temp.data;
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!= null){
                    queue.add(temp.right);
                }
            }
        }

        return maxVal;
    }

    private static int maxElement(Tree root) {
        int maxVal = Integer.MIN_VALUE;
        if(root!=null){
            int leftMax = maxElement(root.left);
            int rightMax = maxElement(root.right);
            if(leftMax > rightMax){
                maxVal = leftMax;
            }else{
                maxVal = rightMax;
            }

            if(root.data > maxVal){
                maxVal = root.data;
            }
        }
        return maxVal;
    }
}
