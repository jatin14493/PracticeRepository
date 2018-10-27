package morganStanleyPractice;

import java.util.Scanner;

public class MaxZeroes {

    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t>0) {

       int n = s.nextInt();
        int ar[] = new int [n];

        for(int i=0;i<n;i++){
            ar[i] = s.nextInt();
        }

        int maxCount= -1;
        int index = -1;

        for(int i=0;i<ar.length;i++){

            int localCount = countZeroes(ar[i]);

            if(localCount >= maxCount  && localCount>0){

                if(localCount>maxCount){
                    maxCount = localCount;
                    index = i;
                }
                else if(maxCount == localCount){
                    if(ar[index] < ar[i]){
                        index = i;
                    }
                }

            }
        }

        if(index==-1){
            System.out.println(index);
        }else{
            System.out.println(ar[index]);
        }

        t--;
        }

    }

    public static int countZeroes(int num){

        int count =0;
        while(num>0){
            int val = num%10;
            if(val == 0){
                count++;
            }
            num = num/10;
        }
        return count;
    }



}
