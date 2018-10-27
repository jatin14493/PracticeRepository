package morganStanleyPractice;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class MedianFinder {
    PriorityQueue<Integer> maxHeap;//lower half
    PriorityQueue<Integer> minHeap;//higher half

    public MedianFinder(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }


    public static void main(String []args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        MedianFinder mf = new MedianFinder();
        while(n-->0) {
            mf.addNum(s.nextInt());
            System.out.println(mf.findMedian());
        }

    }
}