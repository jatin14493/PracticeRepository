package com.jatin.cracking.the.code;


/*
Given two strings, S1 and S2, write code to check
        if S2 is a rotation of S1 using only one call to isSubstring (e.g., Uwaterbottleuis a rotation ofuerbottlewatU).
*/


import java.util.Scanner;

public class stringRotate {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        String s2 = s.next();
        boolean flag= false;


        if(s1.length() == 0 && s2.length()==0) {
            flag = true;

        }
        else if(s1.length() == s2.length()){
            String s1s1 = s1+s1;
            flag = isRotated(s1s1 , s2);

        }else
            flag = false;


        System.out.println("Are 2 strings rotated :" + flag);
    }

    private static boolean isRotated(String s1s1, String s2) {
        return s1s1.contains(s2);
    }
}
