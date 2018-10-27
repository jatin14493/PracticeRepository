package com.jatin.cracking.the.code.LinkedList;

import java.util.Stack;

public class sumList {
    ListNode n1, n2;
    public Stack<Integer>stack;

    public static void main(String[] args) {

        sumList s = new sumList();
        s.stack = new Stack<>();
        //617  716
        s.n1 = new ListNode(7);
        s.n1.next = new ListNode(1);
        s.n1.next.next = new ListNode(6);

        //395  593
        s.n2 = new ListNode(5);
        s.n2.next = new ListNode(9);
        s.n2.next.next = new ListNode(3);
        ListNode ns = addList(s.n1 , s.n2, 0);
        printList(ns,s.stack);


        //sum :  1012  1309
    }

    private static void printList(ListNode head, Stack stack) {


        while(head!=null){
            stack.push(head.getData());
            System.out.print(head.getData());
            head = head.getNext();

        }

        System.out.println("------------------------");
        //if numbers are reverse
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }

    }

    private static ListNode addList(ListNode n1, ListNode n2, int carry) {
        if(n1 == null && n2 == null && carry==0)
            return null;

        int value = carry;


        ListNode list = new ListNode();
        if(n1!=null){
            value+= n1.getData();
        }

        if(n2!=null){
            value+= n2.getData();
        }

        int val = value % 10;
        list.setData(val);

        if(n1!=null || n2!=null) {
            ListNode temp = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? 1 : 0);
            list.setNext(temp);
        }


        return list;
    }
}
