package com.jatin.PracticeGeeksForGeeks;

import java.util.Arrays;

public class SmallestDiffTriplet {

    public static void main(String[] args) {
        int []ar = {5, 2, 8};
        int []br = {10, 7, 12};
        int []cr = {9, 14, 6};

        System.out.println(computeFunction(ar,br,cr, 3));
    }

    private static String computeFunction(int[] ar, int[] br, int[] cr, int n) {

        Arrays.sort(ar);
        Arrays.sort(br);
        Arrays.sort(cr);

        int res_min = 0;
        int res_max = 0;
        int res_mid = 0;
        int i=0,j=0,k=0;

        int diff = Integer.MAX_VALUE;

        while(i<n && j<n && k<n){

                int sum = ar[i] + br[j] + cr[k];
                int min = minimum(ar[i],br[j],cr[k]);
                int max = maximum(ar[i],br[j],cr[k]);

                if(ar[i] == min){
                    i++;
                }else if(br[j] == min){
                    j++;
                }else{
                    k++;
                }

                if(diff > (max - min)){
                    diff = max - min;
                    res_max = max;
                    res_mid = sum - (max + min);
                    res_min = min;
                }

        }
        return res_min + " " + res_mid + " " + res_max;
    }

    private static int maximum(int i, int i1, int i2) {
        return Math.max(Math.max(i,i1),i2);
    }

    private static int minimum(int i, int i1, int i2) {
        return Math.min(Math.min(i,i1),i2);
    }
}
