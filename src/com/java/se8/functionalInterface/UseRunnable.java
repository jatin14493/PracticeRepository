package com.java.se8.functionalInterface;

public class UseRunnable {

    public static void main(String []args){
      Runnable r1 = () -> System.out.println("Thread 1 is running");
      Runnable r2 = () -> System.out.println("Thread 2 is running");

      new Thread(r1).start();
      new Thread(r2).start();
    }
}
