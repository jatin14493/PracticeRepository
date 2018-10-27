package com.jatin.blueoptima.practice;


/*
String Construction
        Alice got a string S and a message along with it.
        The message said Alice had to traverse through the string in given order
        and need to construct a new string. While traversing Alice can insert the current character
        at any position in the new string. Alice gets a score in each step which is equal to the sum of number of distinct
        characters present in the left part and the right part of the new string.
        Alice wants to know what is the maximum score that can be attained in this process. Help him do this.

        Input:
        First line of the input contains the number of the number of strings N.
        It is followed by N lines. Each line contains a single string S.

        Output:
        For each string output a single number, the maximum score attainable.

        Constraints:
        1 <= N <= 100
        1 <= |S| <= 10^5
        S contains only lower case or upper case latin letters, that is characters a to z or A to Z.

        Sample Input
        5
        abcd
        aabc
        abcdcf
        aAcbAZd
        xuVaSva
        Sample Output
        6
        6
        15
        21
        21
        Explanation
        Input: abcd

        Initially there is no new string so score attained for this step equals 0 New String : a ,
        Total score: 0 Now add b to the right so score attained in this step equals 1 New String: ab ,
        Total score:1 Now add c to the right so score attained in this step equals 2 New String: abc , Total score:3
        Now add d to the right so score attained in this step equals 3 New String: abcd , Total score:6

        Input: aabc

        Initially there is no new string so score attained for this step equals 0 New String : a , Total score: 0
        Now add a to the right so score attained in this step equals 1 New String: aa , Total score:1
        Now insert b between the a's present so score attained in this step equals 2
        ( there is one distinct character in the right and another in the left) New String: aba , Total score:3
        Now insert c between "ab" and "a" so score attained in this step equals 3 New String: abca , Total score:6*/


import java.util.Scanner;

public class stringConstruction {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-->0) {
            String str = s.next();
            int n = str.length();
            int k = n * (n - 1) / 2;
            System.out.println(k);
        }
    }
}
