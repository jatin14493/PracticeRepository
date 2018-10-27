package morganStanleyPractice;

import java.util.Scanner;


public class MedianStream {

    public static void main(String []args){

        Scanner s = new Scanner(System.in);
        int n =  s.nextInt();
        int ar[] = new int[n];

        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
        }
    }
}
