package interviewbit;


//Given a set of digits (A) in sorted order,
// find how many numbers of length B are possible whose value is less than number C.

//A = {0,1,2,5}
//B = 2
//C = 21

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraysProgram {

    public static int solve(List<Integer> A, int B, int C) {
        String str = Integer.toString(C);
        int cl = str.length();    //2
        int size=A.size();        //4
        int d=size,d2;            //4

        if(B>cl || C==0 || size==0)
            return 0;

        int zeros = A.lastIndexOf(0)-A.indexOf(0)+1;

        boolean zero=A.contains(0);

        int ans=0;

        if(B<cl){

            if(zero && B != 1)
                ans += size-1;
            else
                ans=size;

            for(int i=1;i<B;i++)
                ans *= size;

            return ans;
        }

        int dp[]=new int[B+1];

        int lower[]=new int[11];

        if(B==cl){

            for(int i = 0; i <= B; i++)
                dp[i] = 0;

            for(int i = 0; i <= 10; i++)
                lower[i] = 0;

            for(int i = 0; i < d; i++) {
                lower[A.get(i) + 1] = 1;
                System.out.print(lower[i] + " ");
            }

            System.out.println();

            for(int i = 1; i <= 10; i++) {
                lower[i] = lower[i - 1] + lower[i];
                System.out.print(lower[i] + " ");
            }

            System.out.println();

            boolean flag = true;

            dp[0] = 0;
            for(int i = 1; i <= B; i++) {

                int digit = str.charAt(i-1)-'0';
                d2 = lower[digit];
                System.out.println("d2 :" + d2);
                dp[i] = dp[i-1] * d;
                System.out.println("dp[i] :" + dp[i]);

                // For first index we can't use 0
                if(i == 1 &&  A.get(0) == 0 && B != 1) {
                    d2 = d2 - 1;
                    //System.out.println("d2 updated :" + d2);
                }

                //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
                if(flag) {
                    dp[i] += d2;
                    System.out.println("inside flag dp[i]" + dp[i]);
                }

                //Is digit[i - 1] present in A ?
//                System.out.println(lower[digit + 1]);
//                System.out.println(lower[digit] + 1);
//                System.out.println(lower[digit + 1] == lower[digit] + 1);
                flag = flag & (lower[digit + 1] == lower[digit] + 1);
            }


            return dp[B];

        }

        return 0;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer ar[] = new Integer[]{0,1,2,5};
        List <Integer>a = Arrays.asList(ar);
        int b = 3;
        int c = 210;
        int val = solve(a,b,c);
        System.out.println("val :" + val);
    }
}