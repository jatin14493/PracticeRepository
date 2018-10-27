package com.jatin.PracticeGeeksForGeeks;

/*
1
2 7
3 8 12
4 9 13 16
5 10 14 17 19
6 11 15 18 20 21
*/

import java.util.Scanner;

public class patternProgram {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int val = n;

        for(int i =1; i<=n; i++){

            int addFactor = val;
            int count = i;
            System.out.print(i + " ");

            for(int j = 1 ; j < i; j++){
                addFactor = addFactor - 1;
                count += addFactor;
                System.out.print(count + " ");
            }

            System.out.println();
        }
    }
}
