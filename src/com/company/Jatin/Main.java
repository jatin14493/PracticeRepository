package com.company.Jatin;

import java.util.Arrays;

class nextGreaterElement {

    public static void main(String[] args) {
	// write your code here
        int digit[] = {3,4,3,9,5,9,3,3,1};
        String num = calculateNextGreater(digit);
        System.out.println(num);
    }

    static void swap(int ar[], int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private static String calculateNextGreater(int[] ar) {
        int i;
        int n = ar.length;
        String ans ="";
        for(i=n-1; i>0; i--){
            if(ar[i] > ar[i-1]){
                break;
            }
        }
        if(i==0){
            System.out.println();
        }else{
            int x = ar[i - 1], min = i;
            //System.out.println(x);
            //System.out.println(min);
            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++)
            {
                if (ar[j] > x && ar[j] < ar[min])
                {
                    min = j;
                }
            }

            //System.out.println(min);

        swap(ar, i - 1, min);
        Arrays.sort(ar, i, n);

        for(int j=0; j<n; j++){
            ans = ans + ar[j];
        }
        }
        return ans;
    }
}
