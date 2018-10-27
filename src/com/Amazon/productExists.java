package com.Amazon;


import java.util.HashSet;

//O(n) solution
public class productExists {

    public static void main(String[] args) {
        int ar[] = {-10, 20, 9, -40};
        int product = -400;
        HashSet<Integer> hs = new HashSet<>();
        boolean flag = false;

        for(int i=0; i<ar.length; i++){
            hs.add(ar[i]);
        }

        for(int i= 0 ; i<ar.length; i++){
            int val = product / ar[i];
            if(hs.add(val)){
                hs.remove(val);
            }else{
                System.out.println("Pair is : " + ar[i] + "," + val);
                flag = true;
                break;
            }
        }

        if(!flag)
            System.out.println("No Such pair exists!!");

    }
}
