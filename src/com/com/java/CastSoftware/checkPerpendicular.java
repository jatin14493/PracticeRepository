package com.com.java.CastSoftware;

import java.util.Scanner;

public class checkPerpendicular {

    public static void main(String []args){

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            double x1 = s.nextDouble();
            double y1 = s.nextDouble();
            double x2 = s.nextDouble();
            double y2 = s.nextDouble();
            double x3 = s.nextDouble();
            double y3 = s.nextDouble();
            double x4 = s.nextDouble();
            double y4 = s.nextDouble();


            double deno1x = diff(x2,x1);
            double deno2x = diff(x4,x3);
            double num1x = diff(y2,y1);
            double num2x = diff(y4,y3);

            if((deno1x == num1x && deno1x==0 && num1x==0) || (deno2x == num2x && deno2x==0 && num2x==0)){
                // Case of Equal Numbers
                System.out.println("INVALID");
            }else{
                double sl1 = num1x/deno1x;
                double sl2 = num2x/deno2x;
                double m = sl1 * sl2;

                if(m==-1){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    private static double diff(double a, double b) {
        double sub = a-b;
        return sub;
    }
}









/* IMPORTANT: Multiple classes and nested static classes are supported *//*


*/
/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*//*

import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            String answer = "";
            double x1 = s.nextDouble();
            double y1 = s.nextDouble();
            double x2 = s.nextDouble();
            double y2 = s.nextDouble();

            double x3 = s.nextDouble();
            double y3 = s.nextDouble();
            double x4 = s.nextDouble();
            double y4 = s.nextDouble();


            double deno1x = diff(x1,x2);
            double deno2x = diff(x3,x4);

            double num1x = diff(y2,y1);
            double num2x = diff(y4,y3);


            if((deno1x == num1x && deno1x==0 && num1x==0) || (deno2x == num2x && deno2x==0 && num2x==0)){
                // Case of Equal Numbers
                answer = "INVALID";
            }else{
                if((num1x == 0 && deno2x==0) || (num2x == 0 && deno1x==0)){
                    answer = "YES";
                }else{
                    answer = slopeCalculation(num1x,deno1x,num2x,deno2x);
                }
            }
            System.out.println(answer);
        }
    }

    private static double diff(double a, double b) {
        double sub = a-b;
        return sub;
    }

    private static String slopeCalculation(double num1x,double deno1x, double num2x, double deno2x){

        double sl1 = num1x/deno1x;
        double sl2 = num2x/deno2x;
        double m = sl1 * sl2;

        if(sl1==1 && sl2==1){
            return "NO";
        }
        else if(m==-1){
            return "YES";
        }else{
            return "NO";
        }
    }
}
*/


