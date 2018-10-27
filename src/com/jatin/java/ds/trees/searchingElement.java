package com.jatin.java.ds.trees;

import java.util.LinkedList;

public class searchingElement {

    Tree root;
    public static void main(String[] args) {
        searchingElement object = new searchingElement();
        object.root = new Tree(16);
        object.root.left = new Tree(5);
        object.root.right = new Tree(23);
        object.root.left.left = new Tree(21);
        object.root.left.right = new Tree(43);
        object.root.right.left = new Tree(27);
        object.root.right.right = new Tree(9);
        int k = 2;
        //Recursive Implementation
        //Boolean flag = elementPresent(object.root, k);

        //Non-Recursive Implementation
        Boolean flag = elementPresentNonRecursive(object.root, k);
        if(flag)
            System.out.println("Elememt Present");
        else
            System.out.println("Element not Present");
    }

    private static Boolean elementPresentNonRecursive(Tree root, int k) {
        LinkedList <Tree>  q = new LinkedList<>();
        if(root!=null)
            q.add(root);

        while(!q.isEmpty()){
            Tree temp = q.removeFirst();
            if(temp.data == k)
                return true;

            if(temp.left!=null)
                q.add(temp.left);

            if(temp.right!=null)
                q.add(temp.right);
        }

        return false;
    }

    private static Boolean elementPresent(Tree root, int data) {

        if(root == null)
            return false;

        if(root.data == data)
            return true;

        return elementPresent(root.left,data) || elementPresent(root.right,data);
    }
}
