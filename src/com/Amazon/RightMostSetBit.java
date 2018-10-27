package com.Amazon;

public class RightMostSetBit {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(rightMostBitSet(n));
    }

    private static int rightMostBitSet(int n) {

        int k = n;
        while(k>1){
            int val = k>>1;
            System.out.println(val);
        }
        return -1;
    }
}
