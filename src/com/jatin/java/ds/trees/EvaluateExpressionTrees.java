package com.jatin.java.ds.trees;

class Node3{
    String data;
    Node3 left,right;
    Node3(String x){
        this.data = x;
        left=right=null;
    }
}

public class EvaluateExpressionTrees {

    Node3 root;

    public static void main(String[] args) {

        EvaluateExpressionTrees tree = new EvaluateExpressionTrees();
        tree.root = new Node3("+");
        tree.root.left = new Node3("*");
        tree.root.left.left = new Node3("5");
        tree.root.left.right = new Node3("4");
        tree.root.right = new Node3("-");
        tree.root.right.left = new Node3("100");
        tree.root.right.right = new Node3("20");
        System.out.println("Evaluate :" + eval(tree.root));

    }

    private static int eval(Node3 root) {

        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return Integer.valueOf(root.data);


        int left_val = eval(root.left);
        int right_val = eval(root.right);


        if(root.data == "+"){
            return left_val + right_val;
        }
        else if(root.data == "-"){
            return left_val - right_val;
        }
        else if(root.data == "*"){
            return left_val * right_val;
        }
        else{
            return left_val/right_val;
        }

    }
}
