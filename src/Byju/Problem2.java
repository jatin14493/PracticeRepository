package Byju;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {



        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        long []ar = new long[n];

        long minValue = Long.MIN_VALUE;
        long diff = 0l;

        for(int i=0; i<n; i++){

            long a = s.nextLong();
            long b = s.nextLong();

            if(i==1 || i==0)
                diff = (b-a);
            else
                diff = (b-a) + (i-1);

            if(diff > minValue){
                minValue = diff;
            }


            ar[i] = diff;
            //System.out.println(ar[i]);
        }

//        for(int i=0; i<n; i++){
//            System.out.print(ar[i] + " ");
//        }



        System.out.println(minValue);

    }
}


//9
//        1 9
//        3 4
//        2 10
//        2 4
//        1 7
//        5 3
//        1 9
//        9 19
//        1 7
