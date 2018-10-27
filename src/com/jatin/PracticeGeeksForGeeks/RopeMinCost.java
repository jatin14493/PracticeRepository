package com.jatin.PracticeGeeksForGeeks;

import java.util.PriorityQueue;

public class RopeMinCost {

    public static void main(String[] args) {

        int ar[] = {4,3,2,6};
        int k = computeCost(ar, ar.length);
        System.out.println("Answer :" + k);
    }

    private static int computeCost(int[] ar, int n) {

        PriorityQueue<Integer> p = new PriorityQueue<>(n);

        for(int i=0; i<n; i++){
            p.add(ar[i]);
        }

        int total = 0;

        while(p.size() >1){
            int a = p.poll();
            int b = p.poll();
            int total1 = a+b;
            total = total + total1;
            System.out.println("total :" + total );
            p.add(a + b);
        }
        return total;
    }
}
