package Capillary;


/*Maximum Sum
        Given an array  of  integers. Now, you have to output the sum of unique values of the maximum subarray sum of all the possible subarrays of the given array .
        Note: Subarray means contiguous elements with atleast one element in it.

        Input Format

        The first line of the input contains a single integer , the total number of elements in array .
        The next line of the input contains  space-separated integers representing the elements of the array.

        Output Format

        The only single line of the output should contain a single integral value representing the answer to the problem.

        Constraints


        Sample Input
        4
        5 -2 7 -3
        Sample Output
        17
        Explanation
        Following are the possible number of subarrays and their respective maximum subarray sums:










        Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.*/

import java.util.*;


public class MaxNumber {



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Long answer = 0L;

        Long []ar = new Long[n];
        HashSet<Long> hashSet =new HashSet<>();

        for(int i=0; i<n; i++){
            ar[i] = s.nextLong();
            //hashSet.add(ar[i]);
        }


        for(int i=0; i<n; i++){

            hashSet.add(ar[i]);
            Long max = 0L;

            if(ar[i] > 0)
                max = ar[i];
            else
                continue;


            Long negSum = 0L;

            for(int j=i+1 ; j<n; j++){

                Long temp = 0L;

                if(ar[j] >= 0){
                    Long tempVal = Long.sum(Long.sum(max,ar[j]),negSum);
                    temp = (tempVal > ar[j])?tempVal : ar[j];

                    if(temp > max){
                        max = temp;
                        negSum = 0L;
                        hashSet.add(max);
                    }

                }else{
                    negSum += ar[j];
                }
            }
        }

        Iterator<Long> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            Long temp = iterator.next();
            answer = Long.sum(answer, temp);
        }
        System.out.println(answer);
    }

}
//24
//        -1 -2 -3 -4 32 234 2 -3 4 34 243 -233 11 101 -342 23 -32 -323 25 13 -12 3124 1324 -3232

//10
//        -1 -2 -3 -4 32 234 2 -3 -2 24

