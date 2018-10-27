package com.com.java.com.java.Furlenco;


/*
Chocolate Distribution


        There are Q queues of students.Each queue contains  () number of students.
        You have to distribute chocolates to K students. Also each student will only be happy if he gets  () number of chocolates.
        Find the minimum number of chocolates that you need to make  students happy.

        Note:-

        You have to follow all the properties of a queue while distributing the chocolates.
        That is, if a student standing in front of a queue gets chocolate(s) and he is happy, he will leave the queue and the next student in queue comes in front.
        You can give chocolates only to the students standing in the front of the queue.
        Also if K is greater than the total number of students then you simply fulfill everyone's requirement.

        Constraints


        Input format
        First line: T i.e number of testcases
        For each test case:
        First line: Two space-separated integers Q and K
        For each queue :
        First line: N i.e number of students in that queue.
        Second line: N space-separated integers denoting requirement of each student.

        Format of the output file:
        For each testcase, print the minimum number of chocolates as asked in the statement.
        Answer for each test case should come in a new line.

        Sample Input
        1
        3 5
        2
        1 6
        3
        2 3 4
        1
        5
        Sample Output
        15
        Explanation
        There are total six students. We have to make 5 students happy.
        If we give chocolates to all students except second student of 1st queue, our answer will be 15 which is the minimum possible answer.

        Note: Your code should be able to convert the sample input into the sample output.
        However, this is not enough to pass the challenge, because the code will be run on multiple test cases.
        Therefore, your code must solve this problem statement.


        1 6 2 3 4 5
        6 1 4 2 3 5
        1 2 3 4 5 6
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class chocolateDistribution {

    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int  t = s.nextInt();
        while(t-- >0)
        {
            List<Integer> list = new ArrayList<Integer>();
            int q = s.nextInt();
            int k = s.nextInt();
            int sum =0;
            int []qr = new int[q];  //stores size of queue

           // int []qr = new int[q];
            for(int i= 0;i<q; i++){
               int val = s.nextInt();
               qr[i] = val;
               while(val-- > 0){
                   list.add(s.nextInt());
               }
            }

            for(int i=0;i<list.size();i++){
                sum += list.get(i);
            }


            if(k >= list.size()){
                System.out.println(sum);
            }else{
                // logic
                Collections.sort(list, Collections.reverseOrder());
                int diff = list.size() -k;
                //System.out.println(diff);
                int minSum = 0;
                for(int i=0;i<diff;i++){
                    minSum = list.get(i);
                    //System.out.println(minSum);
                    sum = sum - minSum;

                }

                System.out.println(sum);

            }
        }
    }

}
