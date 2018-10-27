package com.java.se8.functionalInterface;


public class useSimpleInterface {

    public static void main(String []args){

        SimpleInterface obj = () -> {

            System.out.println("Say Something!!");
            System.out.println("Say Something BITCH!!");

        };

        obj.doSomething();

    }
}
