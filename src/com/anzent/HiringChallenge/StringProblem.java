package com.anzent.HiringChallenge;

import java.util.Scanner;
import java.util.Arrays;
public class StringProblem {


    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        StringBuilder st = new StringBuilder(s.next());
        int k = s.nextInt();
        int countArr [] = new int[26];
        String temp="";

        int min_index = 0;
        char chk ='\0';
        String answer = "";
        int n = st.length();

        if(k==1){
            System.out.println(st.toString());
        }else if(k>=n){
            for(int i=0; i<st.length(); i++){
                countArr[st.charAt(i)-'a']++;
            }

            for (int i=0;i<26;i++)
                for (int j=0;j<countArr[i];j++)
                    temp = temp + (char)('a'+i);

            answer = answer+temp;

            System.out.println(answer);
        }else {


            while (n-- > 0) {
                for (int i = 0; i < k && k <= n; i++) {
                    char vl = st.charAt(i);
                    int comp = (int)vl;
                    //System.out.println(vl-chk);

                    if (i == 0) {
                        min_index = 0;
                        chk = vl;
                    } else if (vl-chk < 0) {
                        min_index = i;
                        chk = vl;
                    }
                }

                if (n >= k) {
                    answer = answer + chk;
                    chk = '\0';
                    st.deleteCharAt(min_index);
                } else {
                    for(int i=0; i<st.length(); i++){
                        countArr[st.charAt(i)-'a']++;
                    }

                    for (int i=0;i<26;i++)
                        for (int j=0;j<countArr[i];j++)
                            temp = temp + (char)('a'+i);
                    answer = answer + temp;
                    break;
                }
            }
            System.out.println(answer);
        }

    }
}


//Alternative logic is : first step compute minimum val and next minimum.
// Remove minimum and in the second iteration, check if the next element is lower tha
//Sample I/P ;
//mynameisjatinmahajaniliveinkrishannagardidmybtechfromusitdelhicurrentlyworkinginairtelpaymentsbankasbackenddeveloperneedachangeinmycareerrightnow
//4









//    public static void main(String args[] ) throws Exception {
//        Scanner s = new Scanner(System.in);
//        StringBuilder st = new StringBuilder(s.next());
//        int k = s.nextInt();
//
//        int min_index = 0;
//        char chk ='\0';
//        String answer = "";
//        int n = st.length();
//
//        if(k==1){
//            System.out.println(st.toString());
//        }else if(k>=n){
//            char []c  = st.toString().toCharArray();
//            Arrays.sort(c);
//            answer = String.valueOf(c);
//            System.out.println(answer);
//        }else {
//
//
//            while (n-- > 0) {
//                for (int i = 0; i < k && k <= n; i++) {
//                    char vl = st.charAt(i);
//                    if (i == 0) {
//                        min_index = 0;
//                        chk = vl;
//                    } else if (vl-chk < 0) {
//                        min_index = i;
//                        chk = vl;
//                    }
//                }
//
//                if (n >= k) {
//                    answer = answer + chk;
//                    chk = '\0';
//                    st.deleteCharAt(min_index);
//                } else {
//                    char[] c = st.toString().toCharArray();  //O(k) operation
//                    Arrays.sort(c); //O(klogk) on k elements
//                    answer += String.valueOf(c);
//                    break;
//                }
//            }
//            System.out.println(answer);
//        }
//
//    }
