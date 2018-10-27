package com.jatin.java.ds.trees;

public class BinaryTreeInsertion {

    Tree root;
    public static void main(String[] args) {
        BinaryTreeInsertion object=  new BinaryTreeInsertion();
        object.root = new Tree(16);
        object.root.left = new Tree(5);
        object.root.right = new Tree(23);
        object.root.left.left = new Tree(21);
        object.root.left.right = new Tree(43);
        object.root.right.left = new Tree(27);
        object.root.right.right = new Tree(9);

        //recursive
        object.insertNode(object.root, 15);

        printTree(object.root);
    }

    private static void printTree(Tree root) {
        if(root!=null){
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    private void insertNode(Tree root, int data) {

        if(root==null) {
            root = new Tree(data);
            return;
        }
        else{
            if(root.data >= data) {   // any check to stop it from going onto the next if/else check
                if (root.left != null) {
                    insertNode(root.left, data);
                } else {
                    root.left = new Tree(data);
                    return;
                }
            }
            else {
                if (root.right != null) {
                    insertNode(root.right, data);
                } else {
                    root.right = new Tree(data);
                    return;
                }
            }
        }


    }
}
