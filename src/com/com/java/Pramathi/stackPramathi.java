package com.com.java.Pramathi;


import java.util.Scanner;
import java.util.Stack;
public class stackPramathi {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        Stack<Long> stack = new Stack<>();
        Long max = Long.MIN_VALUE;
        int n = s.nextInt();
        Long k = s.nextLong();
        Long []ar = new Long[n];
        for(int i =0 ; i< n; i = i+1){
            ar[i] = s.nextLong();
            if(ar[i] >= max){
                max = ar[i];
            }
        }


        String evenOdd = k.toString();
        int num = (int)evenOdd.charAt(evenOdd.length()-1);
        //flag = true for even and false odd
        boolean flag = (num%2==0)?true:false;

        for(int i =n-1; i>=0 ; i--){
            stack.push(ar[i]);
        }


        if(k==n && k==1){
            System.out.println("-1");
        }
        else if(k > n){

            if(n%2==0){
                if(flag){
                    Long val = findMaxStack(stack,Long.valueOf(n));
                    System.out.println(val);
                }else{
                    System.out.println(max);
                }
            }else{
                if (!flag) {
                    Long val = findMaxStack(stack,Long.valueOf(n));
                    System.out.println(val);
                } else {
                    System.out.println(max);
                }

            }

        }else{
            if(k<=n){
                Long val = findMaxStack(stack,k);
                if(val == 0l){
                    System.out.println("-1");
                }else{
                    System.out.println(val);
                }
            }else {
                System.out.println("-1");
            }
        }

//        if(k>n){
//            if(n%2==0){
//                if(k%2==0){
//                    System.out.println("-1");
//                }else{
//                    System.out.println(max);
//                }
//            }else{
//                if(k%2!=0){
//                    System.out.println("-1");
//                }else{
//                    System.out.println(max);
//                }
//
//            }
//        }else{
//
//            if((k == n)){
//                Long val = findMax(ar, Long.valueOf(n), stack);
//                System.out.println("-1");
//            }
//            else if(k<n){
//                Long val = findMax(ar, k, stack);
//                System.out.println(val);
//            }
//            else if(index > k){
//                Long val = findMax(ar, k, stack);
//                System.out.println(val);
//            }else{
//                System.out.println("-1");
//            }
//        }
        // if((k == n)){
        //     Long val = findMax(ar, Long.valueOf(n), stack);
        //     if(val == 0)
        //      System.out.println("-1");
        //      else
        //      System.out.println(val);
        // }else if(k>n){
        //     System.out.println(max);
        // }else if(k<n){
        //     Long val = findMax(ar, k, stack);
        //     System.out.println(val);
        // }
        // else if(index > k){
        //     Long val = findMax(ar, k, stack);
        //     System.out.println(val);
        // }else{
        //     System.out.println("-1");
        // }

        //Long val = findMaxStack(stack , k);

    }

    static Long findMax(Long []ar, Long k, Stack stack){
        Long max = 0L;
        Long prev = 0L;
        for(int i=0; i < k && !stack.isEmpty(); i++){
            Long val = (Long)stack.pop();
            if(val >= max){
                max = val;
                prev = val;
            }
        }
        if(stack.isEmpty())
            return 0L;
        else
            return max;
    }


    static Long findMaxStack(Stack stack, Long k){

        Long prev = Long.MIN_VALUE;
        while(k-- > 1){
            Long top = (Long) stack.pop();
            System.out.println("Top : " + top);
            if(top> prev){
                prev = top;
            }
        }


        System.out.println("(Long)stack.peek() :" + stack.peek());

        if(!stack.isEmpty()){
            Long top = (Long)stack.pop();

            if(stack.isEmpty()){
                return prev;
            }else{
                return (prev > (Long) stack.peek())?prev:(Long)stack.peek();
            }
        }else{
            return (prev > (Long) stack.peek())?prev:(Long)stack.peek();
        }

    }
}
