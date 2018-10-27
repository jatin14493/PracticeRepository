package com.jatin.java.ds.trees;

public class NonRecursiveInorderWithoutStack {
    
    Node root;

    public static void main(String[] args) {

        NonRecursiveInorderWithoutStack tree = new NonRecursiveInorderWithoutStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }

    private void inorder() {

        Node current, pre;

        if(root==null)
            return;

         current = root;
         while(current!=null){
             if(current.left==null){
                 System.out.println(current.data + " ");
                 current = current.right;
             }else{

                 pre = current.left;
                 // To Do
                 while(pre!=null){

                 }
             }
         }


    }
}
