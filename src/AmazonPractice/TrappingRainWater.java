package AmazonPractice;

import java.util.Scanner;

public class TrappingRainWater {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int []ar = new int[n];

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
        }


        int left[] = new int[n];
        int right[] = new int[n];


        //traversing from left to right

        left[0] = ar[0];
        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i-1], ar[i]);
        }

        right[n-1] = ar[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], ar[i]);
        }

        int answer =0;

        for(int i=0; i<n; i++){
            answer += Math.min(left[i],right[i]) - ar[i];
        }

        System.out.println(answer);
    }
}
