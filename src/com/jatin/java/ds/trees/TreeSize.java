package com.jatin.java.ds.trees;

public class TreeSize {

    Node root;

    public static void main(String[] args) {

//                  5
//            4           3
//        1      2     8     7
//           9
//


        TreeSize tree = new TreeSize();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(2);
        tree.root.right.right = new Node(7);
        tree.root.right.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        int n = calculateSize(tree.root);
        System.out.println("Size of tree is :" + n);

        int height = calculateHeight(tree.root);
        System.out.println("Height of tree is :" + height);

        int diameter = calculateDiameter(tree.root);
        System.out.println("Diameter of tree is :" + diameter);

    }

    private static int calculateDiameter(Node root) {

        if(root==null)
            return  0;

        int lheight = calculateHeight(root.left);
        int rheight = calculateHeight(root.right);

        int ldiameter = calculateDiameter(root.left);
        int rdiameter = calculateDiameter(root.right);

        return Math.max(1+rheight+lheight , Math.max(ldiameter,rdiameter));

    }

    private static int calculateHeight(Node root) {
        /*if(root!=null)
            System.out.println("Recursive Stack :" + root.data);
        else{
            System.out.println("Returned from here :");
        }*/

        if(root==null)
            return 0;
        else {
            int lheight = calculateHeight(root.left);
            int rheight = calculateHeight(root.right);

            if (lheight < rheight)
                return rheight+1;
            else
                return lheight + 1;
            }
    }

    private static int calculateSize(Node root) {

        if(root == null)
            return 0;

        return calculateSize(root.left) + 1 + calculateSize(root.right);
    }
}
