package com.jatin.java.ds.trees;

import java.util.LinkedList;

public class kSumPathTrees {

    Node root;
    public static void main(String[] args) {

        kSumPathTrees tree = new kSumPathTrees();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(1);
        tree.root.left.right.left = new Node(1);
        tree.root.right = new Node(-1);
        tree.root.right.left = new Node(4);
        tree.root.right.left.left = new Node(1);
        tree.root.right.left.right = new Node(2);
        tree.root.right.right = new Node(5);
        tree.root.right.right.right = new Node(2);

        int k = 5;
        printKSumPathUtil(tree.root,k);
    }

    private static void printKSumPathUtil(Node root, int k) {
        LinkedList <Node>list = new LinkedList();
        printKSumPath(root,list, k);
    }

    private static void printKSumPath(Node root , LinkedList<Node> paths, int k) {
        if(root==null){
            return;
        }

        System.out.println("Adding to the path :" + root.data);

        paths.add(root);

        System.out.println("List till now :" + paths.toString());

        printKSumPath(root.left, paths, k);
        printKSumPath(root.right,paths, k);

        int f1 = 0;
        for(int i = paths.size()-1; i>=0; i--){
            f1 += paths.get(i).data;
            if(f1 == k){
                printList(paths, i);
            }
        }

        paths.removeLast();
    }

    private static void printList(LinkedList<Node> paths, int i) {
        for(int j=i ; j<paths.size(); j++){
            System.out.print(paths.get(j).data + " ");
        }
        System.out.println();
    }
}
