package com.jatin.PracticeGeeksForGeeks;

import java.util.Scanner;

public class MinRotationLexicographical {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            String str = s.next();
            checkOrder(str,str.length());
        }

        return;
    }

    private static void checkOrder(String str, int length) {

        char []s = str.toCharArray();
        int index = 0;
        
        for(int i=1 ; i<length; i++){
         
            if(booleanCompare(s , i , index, length)){
                index = i;
            }
        }

        printMinRotationString(s, index, length);
    }

    private static void printMinRotationString(char[] s, int index, int n) {

        int mod = index%n;
        for(int i=0; i<n; i++){
            System.out.print(s[(i+mod)%n]);
        }
    }

    private static Boolean booleanCompare(char [] s, int x, int y, int length) {

        for(int i=0; i<length; i++){
            if((s[x] - s[y]) > 0){
                return false;
            }else if((s[x] - s[y]) < 0){
                return true;
            }else{
                x = (x + i)%length;
                y = (y + i)%length;

            }
        }
        return true;
    }
}
