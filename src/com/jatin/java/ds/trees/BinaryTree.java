package com.jatin.java.ds.trees;


import java.util.LinkedList;
import java.util.Queue;

class Node{

    int data;
    Node left,right;

    public Node(int x){
        this.data = x;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(7);
        tree.printTree(tree.root);


        int key =12;
        tree.insert(tree.root,key);
        System.out.println("Printing tree after insertion : ");
        tree.printTree(tree.root);


        int delKey = 6;
        tree.deleteNode(tree.root,delKey);
    }

    private void deleteNode(Node root, int delKey) {

        //to be completed later
        return;
    }

    public void printTree(Node root){
        if(root==null){
            return;
        }
            System.out.println(root.data);
            printTree(root.left);
            printTree(root.right);
    }


//  level order insertion
    public void insert(Node temp, int key){

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(temp);

        while(!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                queue.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                queue.add(temp.right);
            }
        }
    }

}
