package com.jatin.cracking.the.code;

public class interview {

    public static void main(String[] args) {

        String s ="aba";
        int check =0;
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i) - 'a';
            System.out.println("(check & (1<<val)) : "+(check & (1<<val)));
            if((check & (1<<val)) >0){
                System.out.println("false");
                break;
            }
            System.out.println("val : " + (1<<val));
            check |= (1 <<val);
            System.out.println("check : " + check);
        }

        System.out.println((0 & (1<<1)));
        System.out.println((0 & (1<<2)));
        System.out.println((0 & (1<<3)));


        System.out.println((0 | (1<<1)));
        System.out.println((0 | (1<<2)));
        System.out.println((0 | (1<<3)));


        System.out.println((2 | (1<<1)));
        System.out.println((2 | (1<<2)));
        System.out.println((2 | (1<<3)));

        System.out.println(((1<<1)));
        System.out.println(((1<<2)));
        System.out.println(((1<<3)));

    }
}
