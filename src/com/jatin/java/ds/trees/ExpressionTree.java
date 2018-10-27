package com.jatin.java.ds.trees;



import java.util.Stack;

class Node1 {
    char data;
    Node1 left,right;
    Node1(char x){
        this.data = x;
        left = right = null;
    }
}

public class ExpressionTree {

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node1 root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
    }

    // Inorder Traversal
    private void inorder(Node1 root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    //Algorithm
    /*- Create a stack that will hold Node values
            - loop for all elements of char array
                1. if scanned character is operand, create a new node and add to stack;
                2. if scanned character is operator, remove 2 nodes from stack and make the operator as parent.

     return top of the stack which will be a root of the Expression Tree
     */




    private Node1 constructTree(char[] charArray) {
        Stack<Node1> s = new Stack<Node1>();
        Node1 t,t1,t2;

        for(int i = 0 ; i<charArray.length; i++){

            if(!isOperator(charArray[i])){
                t = new Node1(charArray[i]);
                s.push(t);
            }else if(isOperator(charArray[i])){
                t = new Node1(charArray[i]);
                t1 = s.pop();
                t2 = s.pop();

                //pulled from stack that is why right first and then left
                t.right = t1;
                t.left = t2;
                s.push(t);
            }

        }
        t = s.peek();
        System.out.println("Root of tree is :" +s.pop().data);
        return t;
    }
}


//Evaluation of Expression Tree : Next Assignment