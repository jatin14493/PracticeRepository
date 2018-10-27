package com.com.HotstarHiringChallenge;

import java.util.Scanner;

/*Score : 81/100 */

/*
Greatest String
        You are given a string S and an integer Q. You are allowed to perform at most Q operations on the string. In one operation, you can change any vowel to it's next character (e.g., 'a'->'b', 'e'->'f', 'i'->'j', 'o'->'p', 'u'->'v'). Generate the lexicographically greatest string by performing at most Q operations on string S.

        Note- Vowels in English alphabet are- 'a','e','i','o','u'.

        Input Format:

        First line contains an integer T denoting the number of test cases .
        For each test case,in first line you will be given the string S and in second line an integer Q (maximum number of operations allowed).

        Output Format:

        For each test case , print the lexicographically greatest string that can be formed after applying at most Q operations on the given string.
        Answer for each test case should come in a new line.

        Constraints:




        String will consist of only lowercase English alphabets.

        Sample Input
        2
        abcde
        3
        xyzwu
        0
        Sample Output
        bbcdf
        xyzwu

        Explanation
        For case 1:
        We have string "abcde" and we are allowed to perform at max 3 operations, we can form lexicographically greatest string by applying the operation on first and last character of string by changing the string to "bbcdf",which is lexicographically greatest.

        For Case 2:
        We are not allowed to do any operations, so the answer will be the string itself.
*/



public class lexographicGreaterString {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- >0){
            String str = s.next();
            int q = s.nextInt();
            StringBuffer sb = new StringBuffer(str);

        /*if(!str.contains('a'+"") && !str.contains('e'+"") && !str.contains('o'+"") && !str.contains('i'+"") && !str.contains('u'+"")){
            System.out.println(sb);
        }
        else*/ if(q>0) {
                for (int i = 0; i < str.length() && q>0; i++) {
                    switch (sb.charAt(i)) {
                        case 'a':
                            try {
                                char v1 = str.charAt(i + 1);
                                int val = (int)v1 -(int)'a';
                                if (val > -1 && q > 0) {
                                    sb.replace(i,i+1,'b'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'a'+"");
                                }
                            } catch (Exception e) {
                                if (q > 0) {
                                    sb.replace(i,i+1,'b'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'a'+"");
                                }
                            }
                            break;
                        case 'e':
                            try {
                                char v1 = str.charAt(i + 1);
                                int val = 'a' + "".compareTo(v1 + "");
                                if (val > -1 && q > 0) {
                                    sb.replace(i,i+1,'f'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'e'+"");
                                }
                            } catch (Exception e) {
                                if (q > 0) {
                                    sb.replace(i,i+1,'f'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'e'+"");
                                }

                            }
                            break;
                        case 'i':
                            try {
                                char v1 = str.charAt(i + 1);
                                int val = 'a' + "".compareTo(v1 + "");
                                if (val > -1 && q > 0) {
                                    sb.replace(i,i+1,'j'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'i'+"");
                                }
                            } catch (Exception e) {
                                if (q > 0) {
                                    sb.replace(i,i+1,'j'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'i'+"");
                                }
                            }
                            break;
                        case 'o':
                            try {
                                char v1 = str.charAt(i + 1);
                                int val = 'a' + "".compareTo(v1 + "");
                                if (val > -1 && q > 0) {
                                    q--;
                                    sb.replace(i,i+1,'p'+"");
                                } else {
                                    sb.replace(i,i+1,'o'+"");
                                }
                            } catch (Exception e) {
                                if (q > 0) {
                                    sb.replace(i,i+1,'p'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'o'+"");
                                }
                            }
                            break;
                        case 'u':
                            try {
                                char v1 = str.charAt(i + 1);
                                int val = 'a' + "".compareTo(v1 + "");
                                if (val > -1 && q > 0) {
                                    sb.replace(i,i+1,'v'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'u'+"");
                                }
                            } catch (Exception e) {
                                if (q > 0) {
                                    sb.replace(i,i+1,'v'+"");
                                    q--;
                                } else {
                                    sb.replace(i,i+1,'u'+"");
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }// for loop
            }else{
            }
            System.out.println(sb);
        }//while loop for test cases.
    }

}
