package com.jatin.cracking.the.code.LinkedList;

import java.util.HashSet;

public class deleteDuplicatesLinkedList {

    ListNode head;

    public static void main(String[] args) {

        deleteDuplicatesLinkedList l = new deleteDuplicatesLinkedList();
        l.head = new ListNode(5);
        l.head.setNext(new ListNode(4));
        l.head.getNext().setNext(new ListNode(6));
        l.head.getNext().getNext().setNext(new ListNode(7));
        l.head.getNext().getNext().getNext().setNext(new ListNode(4));
        l.head.getNext().getNext().getNext().getNext().setNext(new ListNode(9));
        l.head.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(8));
        l.head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(5));

        ListNode lNode = l.head;
        printList(lNode);
        System.out.println();

        int k =3;
        printKToLast(l.head,k);
        System.out.println("********************************************");

        //when buffer is allowed.
        //deleteDuplicates(l.head);
        //when buffer is not allowed.
        //deleteDuplicateWithoutBuffer(l.head);

        deleteMiddleElement(l.head);
        System.out.println("Printing list after deletions:");
        printList(l.head);

    }

    private static void deleteMiddleElement(ListNode head) {
        if(head == null)
            return;
        else{
            ListNode p1=head,p2=head;
            while(null!= p2.next.next){
                p1 = p1.next;
                p2 = p2.next.next;
            }
            p1.next = p1.next.next;
        }

    }

    private static void printList(ListNode head) {

        while(head!=null){
            System.out.print(head.getData()+ " -> ");
            head = head.getNext();
        }
    }


    private static void printKToLast(ListNode head, int k) {
        /*
         * Recursively print kth Node to Last
         * */
          printRecursively(head,k);

        /*
         * Non - Recursive approach to  print kth Node to Last
         * */
          printNonRecursive(head,k);

    }

    private static void printNonRecursive(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        // Move p1 k steps
        for(int i=0; i<k; i++){
            p1 = p1.next;
        }

        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println("Kth Node from last :" + p2.getData());
    }

    private static int printRecursively(ListNode head, int k) {

        if(head== null)
            return 0;

        int count = printRecursively(head.next,k) +1;

        if(count == k)
            System.out.print(head.getData() + " -> ");

        return count;
    }

    private static void deleteDuplicateWithoutBuffer(ListNode head) {
        ListNode temp = head;
        while(temp!=null){

            ListNode runner = temp;
            while(runner.next!=null){

                if(runner.next.getData() == temp.getData()){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }

            temp = temp.next;

        }
    }

    //using hashset : when buffer is allowed
    private static void deleteDuplicates(ListNode head) {
        ListNode temp = null;
        HashSet<Integer> hs = new HashSet<>();
        while(head!=null){
            if(hs.add(head.getData())){
                temp = head;
            }else{
                temp.next =head.next;
            }

            head = head.next;
        }
    }
}
