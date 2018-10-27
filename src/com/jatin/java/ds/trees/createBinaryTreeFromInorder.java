package com.jatin.java.ds.trees;

class createBinarySearchTreeFromInorder {

    Node root;

    public static void main(String[] args) {
        int []ar = new int[]{1,2,3,4,5,6,7};
        createBinarySearchTreeFromInorder tree= new createBinarySearchTreeFromInorder();
        tree.root = utilFunction1(ar,0,ar.length-1);

        printList(tree.root);
    }

    private static void printList(Node root) {

        //preorder traversal
            if(root!=null){
                System.out.println(root.data + " ");
                printList(root.left);
                printList(root.right);
            }

    }

    private static Node utilFunction1(int[] ar, int i, int i1) {
        return utilFunction(null, ar, i, i1);
    }

    private static Node utilFunction(Node node ,int[] ar, int l, int n) {
        if(l>n)
            return null;

        int mid = (n+l)/2;
        node = new Node(ar[mid]);
        node.left = utilFunction(node.left ,ar,  l , mid-1);
        node.right = utilFunction(node.right ,ar, mid+1, n);

        return node;
    }
}
