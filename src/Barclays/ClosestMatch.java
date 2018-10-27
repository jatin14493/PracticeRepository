package Barclays;


/*Finding the word
        You are given a string  of lowercase English alphabets.
        You need to count the minimum number of characters you need to change in this string  so that it contains the word barclays as a substring.

        Input
        The first line of input contains a string .

        Output
        In the first line, print an integer , which should be the minimum number of characters that you need to change.
        In the next line, print the positions of the characters you need to change in ascending order and separated by space.
        Since there can be multiple outputs, you need to print the answer in which the position of the first character to change is minimal.

        NOTE: Answer will always exist. Positions of the characters are 1-indexed.

        Constraints


        Sample Input
        itisbarcwoys
        Sample Output
        2
        9 10
        Explanation
        If we change characters at position  and  to "l" and "a" respectively then we can obtain the string barclays as a substring of the given string in minimum changes.*/

import java.util.ArrayList;
import java.util.Scanner;

public class ClosestMatch {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str = s.next();
        int offset = -1;
        int count = Integer.MIN_VALUE;

        String word ="barclays";
        int num_len = word.length();


        for(int i=0; i< str.length()-word.length()+1; i++){
            String val = str.substring(i,word.length()+i);
            int len = 0;
            int lcCount =0;
            while(len < num_len){
                if(word.charAt(len) == val.charAt(len)){
                    lcCount++;
                }
                len++;
            }

            if(lcCount > count){
                count = lcCount;
                offset = i;
            }



        }


        ArrayList <Integer>al = new ArrayList<>();

        for(int i= offset, len=0; len<num_len; i++,len++){

            if(str.charAt(i)!=word.charAt(len))
                al.add(i+1);
        }

        System.out.println(num_len-count);
        al.forEach(s1 -> {
            System.out.print(s1 +  " ");
        });
    }
}
