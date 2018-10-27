package com.Amazon;

public class Replace0with5 {

    public static void main(String[] args) {
        int n = 12030;
        int answer = calFunction(n);
        System.out.println(answer);
    }

    private static int calFunction(int n) {
        if(n==0)
            return 0;
        else
            return calUtilFunction(n);
    }

    private static int calUtilFunction(int n) {
        if(n==0)
            return 0;

        int digit = n%10;
        if(digit == 0)
            digit =5;

        return calFunction(n/10)*10 + digit;
    }
}
