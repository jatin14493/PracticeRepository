package com.jatin.blueoptima.practice;

import java.util.Scanner;
import java.util.Stack;


//Given an array, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.
//
//        Input:
//        The first line of input contains an integer T denoting the number of test cases.
//        The first line of each test case is N,N is the size of array.
//        The second line of each test case contains N input A[i].
//
//        Output:
//        Should print 1 if given array can represent preorder traversal of BST. Otherwise 0.
//
//        Constraints:
//        1 <=T<= 55
//        1 <= N <= 1000
//        1 <= arr[i] <= 1000
//
//        Example:
//
//        Input:
//        3
//        5
//        40 30 35 80 100
//        8
//        40 30 32 35 80 90 100 120
//        8
//        7  9 6 1 4 2 3 40
//
//        Output:
//        1
//        1
//        0


public class preorderBstToPostorder {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0){
            int n = s.nextInt();
            int []ar = new int[n];
            for(int i=0; i<n; i++){
                ar[i] = s.nextInt();
            }

            int index = -1;
            String ans = ar[0] + " ";

            for(int i=1;i<n;i++){
                if(ar[i] > ar[i-1]){
                    index = i;

                    break;
                }

            }// end for

            for(int i =index+1; i>index; i++){
                if(ar[i] >  ar[i-1]){

                }
            }
        }
    }
}
