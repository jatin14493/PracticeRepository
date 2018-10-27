package com.jatin.cracking.the.code;

import java.util.Scanner;

public class rotateArrayBy90 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] ar  = new int[n][n];
        for(int i=0;i <n; i++){
            for(int j=0; j<n; j++){
                ar[i][j] = s.nextInt();
            }
        }


        printArrays(ar,n);
        rotateArray(ar,n);
        printArrays(ar,n);

    }

    private static void printArrays(int[][] ar, int n) {
        for(int i=0;i <n; i++){
            for(int j=0; j<n; j++){
                System.out.print(ar[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateArray(int[][] ar, int n) {

        for(int i = 0 ; i<n/2 ; i++){
            for(int j = i ; j<n-i-1 ; j++){
                int temp = ar[i][j];
                ar[i][j] = ar[n-j-1][i];
                ar[n-j-1][i] = ar[n-i-1][n-j-1];
                ar[n-i-1][n-j-1] = ar[j][n-i-1];
                ar[j][n-i-1] = temp;
            }
        }


        System.out.println("calling printarray here!!");
        printArrays(ar,n);


        for (int i =0; i < n / 2; i++) {
            int last= n-1-i;
            for(int j = i; j < last; j++) {
                int offset =j-i;

                int top = ar[i][j];
                ar[i][j] = ar[last-offset][i];
                ar[last-offset][i] = ar[last][last-offset];
                ar[last][last - offset] = ar[j][last];
                ar[j][last] = top;
            }
        }
    }
}
