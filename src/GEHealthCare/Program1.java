package GEHealthCare;


/*

Given a string S of length N.
Now, you need to cut the string S into K+1 non-empty substrings by performing K cuts.
There are lots of ways of performing the cuts in the string S.
For every way of performing the cuts, you need to count how many substrings will be a palindrome in that way of cut.
You need to sum this count over all possible ways of cutting the string S.  Input Format
The first line contains two integers N and K as input. The second line contains the string S as input.  Output Format
In the output, you need to print the sum modulo 10^9+7. 
    
   Constraints
        2≤N≤5000

        1≤K≤N−1
         String S contains only lowercase english alphabets


        Sample Input

        5 2
        aabbc
        Sample Output

        12


   Explanation
        In the given test case there are 
        6 ways to perform the cuts. All the ways are described below.

        a | a | bbc = 2 substrings are palindrome
        a | ab | bc = 1 substring is palindrome
        a | abb | c = 2 substrings are palindrome
        aa | b | bc = 2 substrings are palindrome
        aa | bb | c = 3 substrings are palindrome
        aab | b | c = 2 substrings are palindrome
        So, the output is 
        2+1+2+2+3+2=12

*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []c = br.readLine().split(" ");
        int n  = Integer.parseInt(c[0]);
        int k  = Integer.parseInt(c[1]);

        StringBuilder builder = new StringBuilder(br.readLine());
        //System.out.println(builder);

    }
}
