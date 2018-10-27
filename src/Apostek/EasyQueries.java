package Apostek;

/*
Easy Queries
        You are given an array of size  in which the value of the elements are either  or .
        All the elements of array are numbered from position  to .You are given some queries which can be of following  types.

        : In this type of query you have to find the nearest left and nearest right element from position  in the array whose value is .
        : In this type of query you need to change the value at positon  to  if its previous value is 0 or else leave it unchanged.

        Important Note : If there is no position with value 1 on the left side of any index in query then print -1 instead of left index and similarly if there is no value 1 in right side of the value index in that query then print -1 in place of the answer for right element.


        Input
        First line contains  integers  and  denoting the number of elements in array and number of queries.
        Next line contains  elements denoting the array.
        Next  lines contains  integer each denoting the any type of Query.

        Output
        For each query print left and right nearest element seprated by space.

        Constraints

        Sample Inputs

        Input	Output
        5 4
        0 0 0 0 0
        0 2
        1 2
        1 4
        0 3

        -1 -1
        2 4
        6 2
        1 0 1 0 1 1
        0 0
        0 4
        -1 2
        2 5
        Sample Input
        7 4
        1 0 0 0 1 0 1
        0 1
        0 5
        1 2
        0 2
        Sample Output
        0 4
        4 6
        0 4
        Explanation
        The First query is 0 1. So the nearest 1 in left side from index 1 is element at index 0 and in right side the element is at index 4.

        Similarly, the second query is 0 5. So the nearest 1 in left side from index 5 is element at index 4 and in right side the element is at index 6.

        The third query is 1 2. So set the value equal to 1 of the element at index 2.

        The Fourth query is 0 2. So the nearest 1 in left side from index 1 is element at index 2 and in right side the element is at index 4.

*/


import java.util.Scanner;

public class EasyQueries {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        int ar[] = new int[n];

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
        }

        int [][]qr = new int[q][2];


        for(int i=0; i<q; i++){
            for(int j=0; j<2; j++){
                qr[i][j] = s.nextInt();
            }
        }

        for(int i=0; i<q; i++){
            int val = qr[i][0];
            int index = qr[i][1];


            if(val == 0){
                boolean isLeft = false;
                boolean isRight = false;

                int low = 0;
                int high = n-1;
                int temp = index;

                while(temp >low)
                {
                    temp--;
                    if(ar[temp] == 1){
                        System.out.print(temp+ " ");
                        isLeft = true;
                        break;
                    }
                }

                if(temp == low && !isLeft){
                    System.out.print("-1 ");
                }

                temp = index;

                while(temp<high){
                    temp++;
                    if(ar[temp] == 1){
                        System.out.print(temp + " ");
                        isRight = true;
                        break;
                    }
                }

                if(temp==high && !isRight){
                    System.out.print("-1 ");
                }

                System.out.println();
            }
            else{
                ar[index] = 1;
            }

        }

    }
}
