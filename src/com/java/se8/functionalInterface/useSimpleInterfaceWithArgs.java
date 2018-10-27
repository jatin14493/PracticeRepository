package com.java.se8.functionalInterface;


public class useSimpleInterfaceWithArgs {

    public static void main(String []args){
        SimpleInterfaceWithArgs obj = (v1,v2) -> {
            int result = v1*v2;
            System.out.println("Say Something!!");
            System.out.println("Say Something BITCH!!");
            System.out.println("O/p of result :" + result);
            };
        obj.doSomething(10,5);
    }
}
