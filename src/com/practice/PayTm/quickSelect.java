package com.practice.PayTm;

import java.util.Scanner;

public class quickSelect {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int []ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();

        quickSelect qs = new quickSelect();
        int val = qs.randomizedQuickSelect(ar,0,n-1, k);
        System.out.println("val :" + val);
        printarray(ar);

    }

    private static void printarray(int[] ar) {
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i] + " ");
        }
    }

    private int randomizedQuickSelect(int[] ar, int p, int r, int i) {

        if(p==r){
            return ar[p];
        }

       /* if(k>0 && k <= r-l+1){*/
            int q = partition(ar, p, r);

            int k = q-p+1;

            if(i == k) {
                return ar[q];
            }
            else if(i  < k){
                //left sub-array
                return randomizedQuickSelect(ar,p,q-1,i);
            }else
                //right sub-array
                return randomizedQuickSelect(ar,q+1, r,i-k);
    }

    private static int partition(int[] ar, int l, int r) {
        int x = ar[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (ar[j] <= x)
            {
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, r);
        return i;
    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
