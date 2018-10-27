package com.Amazon;

/*
Given a Singly Linked list, Update the second half of the list such that n-th element becomes sum(1st + nth) element,
        (n-1)st element becomes sum(2nd + n-1st) element and so on. Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
*/

import java.util.Stack;

class Node{
    int data;
    Node next =null;
    public Node(int data){
        this.data = data;
        next = null;
    }
}

public class ListProblem {

    Node head;
    public static void main(String[] args) {
        ListProblem listProblem = new ListProblem();
        listProblem.head = new Node(2);
        listProblem.head.next = new Node(3);
        listProblem.head.next.next = new Node(4);
        listProblem.head.next.next.next = new Node(5);
        listProblem.head.next.next.next.next = new Node(6);
        //listProblem.head.next.next.next.next.next = new Node(7);
        printlist(listProblem.head);
        listProblem.head = modifyList(listProblem.head);

        printlist(listProblem.head);
    }

    private static void printlist(Node head) {
        while(head!=null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    private static Node modifyList(Node head) {
        Stack<Node> s = new Stack<>();
        Node slowPtr = head;
        Node fastPtr = head.next;
        s.add(slowPtr);

        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            s.add(slowPtr);
        }

        //handle even length linked list
        if(fastPtr!=null)
            slowPtr = slowPtr.next;

        while(!s.isEmpty() && slowPtr!=null){
            Node temp = s.pop();
            slowPtr.data = slowPtr.data + temp.data;
            slowPtr = slowPtr.next;
        }
        return head;
    }
}
