package com.com.java.KelltonHiringChallenge;


/*

Palindromic grid
   You are given a 2-d grid of N rows and M columns containing lower case alphabets only.
   You need to check whether it is possible to rearrange the complete grid so that each row and column becomes palindromic.

        Input :

        The first line of input contains T, the number of test cases.
        The first line of each test case contains two space-separated integers N and M, denoting the number of rows and columns.
        Each of the following N lines contains a string of length M.
        Output :

        Output YES if it is possible to rearrange the grid to make all the rows and columns palindromic. else output NO.
        Constraints :


        //abc -> aa, bb, ca , abc, aba
        //aba


        Sample Input
        2
        2 2
        aa
        aa
        2 3
        aba
        aca
        Sample Output
        YES
        NO
        Explanation
        The given arrangement already have all the rows and columns palindromic.*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pallindromicGrid {

    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();



        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int sum=0;
            List<String> list = new ArrayList<>(n+m);
            String[] ar = new String[n];
            for (int i = 0; i < n; i++) {
                    ar[i] = s.next();
                    list.add(ar[i]);
            }

            for(int i =0; i<m;i++){
                String list1 = "";
                for(int j = 0 ; j<n; j++){
                    list1 = list1 + ar[j].charAt(i);
                }
                list.add(list1);
            }

            for(int i=0;i<list.size();i++) {
                int val = checkPallindrome(list.get(i));
                if(val == 0)
                    break;
                else{
                    sum += val;
                }
            }

            if(sum==m+n){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static int checkPallindrome(String list) {
        int len = list.length();
        int start =0;
        int end = len-1;
        while(start<end){
            if(list.charAt(start) == list.charAt(end)){
                start++;
                end--;
            }else{
                return 0;
            }
        }
        return 1;
    }
}
