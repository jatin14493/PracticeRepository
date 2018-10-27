package com.jatin.java.ds.trees;

public class BtreeSymmetry {
    Tree root;
    Tree root2;

    public static void main(String[] args) {

        BtreeSymmetry object = new BtreeSymmetry();
        object.root = new Tree(1);
        object.root.left = new Tree(2);
        object.root.right = new Tree(3);
        object.root.left.left = new Tree(4);
        object.root.left.right = new Tree(5);
        object.root.right.left = new Tree(6);
        //object.root.right.right = new Tree(7);


        object.root2 = new Tree(1);
        object.root2.left = new Tree(2);
        object.root2.right = new Tree(3);
        object.root2.left.left = new Tree(4);
        object.root2.left.right = new Tree(5);
        object.root2.right.left = new Tree(6);
        //object.root2.right.right = new Tree(7);

        Boolean flag = isSymmetric(object.root, object.root2);

        if(flag)
            System.out.println("Symmetric!!");
        else
            System.out.println("Non - Symmetric!!");
    }

    private static Boolean isSymmetric(Tree root, Tree root2) {
        if(root==null && root2==null)
            return true;

        if(root.data==root2.data && root.left!=null && root2.left!=null && root.right!=null && root.right!=null){
            return isSymmetric(root.left,root2.left) && isSymmetric(root.right , root2.right);
        }

        return false;
    }

}
