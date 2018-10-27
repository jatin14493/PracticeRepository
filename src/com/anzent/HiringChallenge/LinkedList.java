package com.anzent.HiringChallenge;

import java.util.LinkedList;

class Linkedlist {

//    public static void main(String[] args) {
//        LinkedList obj = new LinkedList();
//        obj.add("A");
//        obj.add("B");
//        obj.add("C");
//        obj.addFirst("D");
//        System.out.println(obj);
//    }

    static int count =0;

    Linkedlist(){
        count++;
    }


    public static void main(String[] args) {
        Linkedlist l1 = new Linkedlist();
        Linkedlist l2 = new Linkedlist();
        Linkedlist l3 = new Linkedlist();
        System.out.println("Total: " + count +"objects created");
    }
}
