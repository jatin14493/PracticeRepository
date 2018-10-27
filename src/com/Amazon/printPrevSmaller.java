package com.Amazon;

import java.util.Stack;

public class printPrevSmaller {

    public static void main(String[] args) {
        int ar[] = {1, 6, 4, 10, 2, 5};
        int n = ar.length;
        compute(ar,n);
    }

    private static void compute(int[] ar, int n) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ;i <n ; i++){

            while(!stack.isEmpty() && stack.peek() >= ar[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                System.out.print("_");
            }
            else{
                System.out.print("," + stack.peek());
            }

            stack.push(ar[i]);
        }
    }
}
