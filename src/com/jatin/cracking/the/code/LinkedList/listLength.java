package com.jatin.cracking.the.code.LinkedList;

public class listLength {
    ListNode head;

    public static void main(String[] args) {
        listLength l = new listLength();
        l.head = new ListNode(4);
        l.head.setNext(new ListNode(5));
        l.head.getNext().setNext(new ListNode(6));
        l.head.getNext().getNext().setNext(new ListNode(7));
        l.head.getNext().getNext().getNext().setNext(new ListNode(8));
        l.head.getNext().getNext().getNext().getNext().setNext(new ListNode(9));
        l.head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(10));

        ListNode lNode = l.head;

        while(lNode!=null){
            System.out.print(lNode.getData()+ " -> ");
            lNode = lNode.getNext();
        }

        int n = calculateLength(l.head);
        System.out.println("Length of Linked List :"+n);

    }

    private static int calculateLength(ListNode lNode) {
        int len =0;

        while(lNode!=null){
            //System.out.print(lNode.getData()+ " -> ");
            len++;
            lNode = lNode.getNext();
        }
        return len;
    }
}
