package com.practice.PayTm;


import java.util.Scanner;

public class kRotatedArray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){

            int n = s.nextInt();
            int k = s.nextInt();
            int ar[] = new int[n];
            for(int i=0; i<n; i++){
                ar[i] = s.nextInt();
            }

            printkRotatedArray(ar,n,k);
        }
    }

    private static void printkRotatedArray(int[] ar, int n, int k) {
        int mod = k%n;

        for(int i =0 ; i<n; i++){
            System.out.print(ar[(i+mod)%n] + " ");
        }
    }
}
