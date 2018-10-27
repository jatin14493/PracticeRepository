package Rndom;

import java.util.Scanner;

public class waterTrapping {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0){
            int n = s.nextInt();
            int ar[] = new int[n];
            for(int i= 0; i<n ; i++){
                ar[i] = s.nextInt();
            }

            int k = computeWater(ar,n);
            System.out.println("Water Trapped :" + k);
        }
    }

    private static int computeWater(int[] ar, int n) {
        int answer = 0;


        int left [] = new int[n];
        int right [] = new int[n];

        left[0] = ar[0];
        right[n-1] = ar[n-1];

         for(int i=1 ; i<n; i++){
            left[i] = Math.max(ar[i],left[i-1]);
        }

        for(int i = n-2 ; i>=0 ; i--){
            right[i] = Math.max(right[i+1],ar[i]);
        }

        for(int i=0; i<n; i++){
            answer += Math.min(left[i],right[i]) - ar[i];
        }

        return answer;
    }
}
