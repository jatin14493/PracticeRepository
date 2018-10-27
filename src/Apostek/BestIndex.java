package Apostek;

/*

        Best Index
        You are given an array  of  elements. Now you need to choose the best index of this array .
        An index of the array is called best if the special sum of this index is maximum across the special sum of all the other indices.

        To calculate the special sum for any index  , you pick the first element that is  and add it to your sum.
        Now you pick next two elements i.e.  and  and add both of them to your sum.
        Now you will pick the next  elements and this continues till the index for which it is possible to pick the elements. For example:

        If our array contains  elements and you choose index to be  then your special sum is denoted by -
        , beyond this its not possible to add further elements as the index value will cross the value .

        Find the best index and in the output print its corresponding special sum.
        Note that there may be more than one best indices but you need to only print the maximum special sum.

        Input
        First line contains an integer  as input.
        Next line contains  space separated integers denoting the elements of the array .
        Output
        In the output you have to print an integer that denotes the maximum special sum

        Constraints

        Sample Inputs

        Input	Output
        5
        1 3 1 2 5

        8
        10
        2 1 3 9 2 4 -10 -9 1 3

        9


        Sample Input
        6
        -3 2 3 -4 3 1
        Sample Output
        3
        Explanation
        Let us calculate the special value for each index :

        For index 1:
        For index 2:
        For index 3:
        For index 4:
        For index 5:
        For index 6:
        So the maximum value among all the special values is 3 hence it is the output.

*/

import java.util.Scanner;

public class BestIndex {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] ar = new long[n];

        for(int i=0; i<n; i++){
            ar[i] = s.nextLong();
        }

        for(int i=1; i<n; i++){
            ar[i] = ar[i-1] + ar[i];
        }

        long maxVal = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {

            long tempVal = Integer.MIN_VALUE;

            long turn = 0;
            long rem = 2 * (n-i);

            Double val = Math.sqrt(rem);

            long chk = val.longValue();
            long chkProduct = chk * (chk + 1);

            if (chkProduct > rem) {
                turn = chk - 1;
            } else {
                turn = chk;
            }


            long loopVal = ((turn)*(turn+1))/2;
            int num = (int)loopVal;

            if(i==0)
                tempVal = ar[i+num-1];
            else{
                    tempVal = ar[i+num-1] -(ar[i-1]);
                }


            if(tempVal > maxVal){
                maxVal = tempVal;
            }



        }
        System.out.println(maxVal);

    }
}
