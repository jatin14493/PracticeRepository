package com.practice.PayTm;

import java.util.Scanner;

public class excelSheetColumnNumberRepresentation {

    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
            String val = computeColumnName(n);
            System.out.println(val);
        }
    }

    private static String computeColumnName(int n) {
        String ans = "";
        String ans1 ="";
        while(n>0){
            int div = n%26;
            if(div == 0){
                div =26;
                char val1 = (char)('A' + div - 1);
                System.out.println(val1);
                ans = ans + val1;
                n=n/26-1;
            }else {
                char val1 = (char) ('A' + div - 1);
                ans = ans + val1;
                n=n/26;
            }
        }

        //Reversing the O/p
        for(int i=ans.length()-1;i>=0;i--){
            ans1 += ans.charAt(i) + "";
        }

        return ans1;
    }
}
