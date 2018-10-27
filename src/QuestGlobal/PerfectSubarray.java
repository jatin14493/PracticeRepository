package QuestGlobal;

import java.util.Scanner;

public class PerfectSubarray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        //cumilative array
        int []ar = new int[n];
        int prev =0;
        int count = 0;
        for(int i=0 ; i<n; i++){
            ar[i] = prev + s.nextInt();
            prev =ar[i];
            if(isPerfectSquare(ar[i])){
                count = count + 1;
            }
        }

//        for(int i =0; i<n; i++)
//        System.out.println(ar[i] +  " ");
        
        
        for(int i= 0; i<n ; i++){
            int temp = ar[i];
            for(int j =i+1; j<n; j++){
                int val = ar[j] - temp;
                if(isPerfectSquare(val)){
                    count = count + 1;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isPerfectSquare(int x) {

        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }
}
