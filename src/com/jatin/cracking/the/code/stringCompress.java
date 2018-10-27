package com.jatin.cracking.the.code;

public class stringCompress {

    public static void main(String[] args) {


        String str = "aaabbbbccbbaaaaab";
        char first = str.charAt(0);
        String result ="";

        int count =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == first){
                count++;
            }else{
                result = result + first + count;
                count = 1;
            }
            first = str.charAt(i);
        }
        result = result + first + count;

        System.out.println(result);
    }


}
