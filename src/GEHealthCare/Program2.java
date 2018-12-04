package GEHealthCare;


/*
Substring Slicing
        You are given a string .
        Now, you can cut the string into two parts such that each part is the substring of the string  and is non-empty.
        Now, you can form a new string by arranging these two parts in any order.
        Print YES if it is possible to cut the string into two parts and then rearrange them to form a palindrome otherwise print NO.

        Input Format
        The first line contains an integer  that denote the total number of test cases.
        The first line of each test case contains a string .

        Output Format
        For each test case, print YES  or NO in a new line.

        Constraints

        Sample Input
        2
        abbavv
        apple
        Sample Output
        YES
        NO
        Explanation
        Sample test case : Choose the first substring as abbav and second substring as v.
        Now, you arrange them as v + abbav that will form the string vabbav which is a palindrome.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0){
           String builder = br.readLine();
           boolean check = false;
            for(int i=builder.length()-1; i>0; i--){
                String s = builder.substring(i, builder.length());
                String s1 = builder.substring(0,i);
                s = s+s1;
                 check = isPallindrome(s);
                if(check)
                    break;
            }

            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean isPallindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}
