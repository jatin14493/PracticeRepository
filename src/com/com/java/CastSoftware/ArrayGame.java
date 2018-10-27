package com.com.java.CastSoftware;


//Problem Statement

/*
A Game on Array
        Problem Statement
        There is an array A of size N. Alex and Bob play a game on it with Alex moving first and the players playing their turns alternately.

        In each turn, the length of the array decreases by 1 because of following operation that the player performs:
        1. If the length of array is odd, the middle number is removed from array.
        2. If the length is even, the player has a choice of removing either of the middle two elements.

        The value of removed element is added to the score of the current player.
        At end, the winner is decided by the one having maximum score. If both have same score at end, we allow Alex to win as he is the inventor of this game.
        Both players play optimally.
        Print the winner of the game and the absolute difference between their scores after the game ends.

        Constraints


        Input Format
        First line contains an integer N, denoting the size of array.
        Next line contains N space separated natural numbers, denoting the array A.

        Output Format
        In a single line, print the winner followed by a single integer denoting the absolute value of the difference between their scores.

        Sample Input
        4
        1 1 1 1
        Sample Output
        Alex 0
        Explanation
        Since all elements are same, both have a score of 2 at end. So Alex wins with the absolute difference between their scores as 0.
*/


import java.util.ArrayList;
import java.util.Scanner;

public class ArrayGame {

    public static void main(String args[]){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(n);

        for(int i=0;i<n;i++){
            list.add(s.nextInt());
        }
        int alex_sum = 0;
        int other_sum =0;

        boolean turn =false; //false mean add to Alex
        boolean mid_true = false; //take the mid value -1;

        int len = n;
        while(len >0){
            if(len%2!=0){
                int mid = len/2;
                int val = list.get(mid);
                if(!turn){
                    alex_sum = alex_sum + val;
                    turn = true;
                }else{
                    other_sum += val;
                    turn = false;
                }
                list.remove(mid);
            }else{
                int mid1 = len/2;
                int mid2 = mid1-1;
                int val = (list.get(mid1)>list.get(mid2))?list.get(mid1) : list.get(mid2);
                if(list.get(mid1)>list.get(mid2)){
                    mid_true = true;
                }else{
                    mid_true = false;
                }
                if(!turn){
                    alex_sum += val;
                    turn = true;
                }else{
                    other_sum += val;
                    turn = false;
                }
                if(mid_true){
                    list.remove(mid1);
                }else{
                    list.remove(mid2);
                }
            }
            len--;
        }

        String answer ="";
        if(alex_sum >= other_sum){
            int diff = alex_sum - other_sum;
            answer = "Alex" + diff;
        }else{
            int diff = other_sum - alex_sum;
            answer = "Bob" + diff;
        }

        System.out.println(answer);
    }
}
