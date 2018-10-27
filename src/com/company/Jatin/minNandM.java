package com.company.Jatin;

import java.util.Stack;

public class minNandM {

    public static void main(String args[]){
        String s ="MN";
        System.out.println(generateNumber(s));

        s ="M";
        System.out.println(generateNumber(s));

        s ="N";
        System.out.println(generateNumber(s));

        s ="MMMMMMM";
        System.out.println(generateNumber(s));

        s ="NNNNNNN";
        System.out.println(generateNumber(s));

        s ="MNMMMMN";
        System.out.println(generateNumber(s));

        s ="NNMMNNN";
        System.out.println(generateNumber(s));
    }

    private static String generateNumber(String seq) {
        String result ="";
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<=seq.length();i++){
            s.push(i+1);

            if(i==seq.length() || seq.charAt(i)=='M'){

                while(!s.empty()){
                    result += s.peek();
                    result += "";
                    s.pop();
                }
            }
        }

        return result;
    }

}
