package com.company.Jatin;

import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum =0;
        for(int i= 1; i<=n ; i++){
            sum = sum+computeSum(i);
        }

        System.out.println(sum);

        }

    private static int computeSum(int i) {
        int sum =0;
        while(i>0){
            sum += i%10;
            i = i/10;
        }
        return sum;
    }


}
