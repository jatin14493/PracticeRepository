package com.Amazon;



public class matrixMultiplication {

    public int findCost(int arr[]){

        int temp[][] = new int[arr.length][arr.length];
        int q = 0;

        for(int l=2; l < arr.length; l++){

            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;

                for(int k=i+1; k < j; k++){
                    q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    System.out.println("l :" + l + " i :" + i + " k :" + k + " q :" + q);
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
                
            }

        }
        return temp[0][arr.length-1];
    }

    public static void main(String args[]){
        matrixMultiplication mmc = new matrixMultiplication();
        int arr[] = {1,2,3,4};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}