package com.jatin.cracking.the.code.LinkedList;

public class linkedListPallindrome {

    ListNode head;

    public static void main(String[] args) {

        linkedListPallindrome llp = new linkedListPallindrome();
        llp.head = new ListNode(1);
        llp.head.next = new ListNode(2);
        llp.head.next.next = new ListNode(3);
        llp.head.next.next.next = new ListNode(3);
        llp.head.next.next.next.next = new ListNode(3);
        llp.head.next.next.next.next.next = new ListNode(2);
        llp.head.next.next.next.next.next.next = new ListNode(1);

        boolean isPallindrome = checkPallindrome(llp.head);

        System.out.println("Is this list a pallindrome :" + isPallindrome);

    }

    // Non -Recursive Approach
    private static boolean checkPallindrome(ListNode head) {
        ListNode p1=head,p2=head;
        if(head==null)
            return true;

        //1 -> 2 -> 1
        //1 -> 2 -> 2 -> 1

        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode revList = reverseList(p1);
        System.out.println("Reversed List below :");
        printList(revList);
        System.out.println();
        return isPallindrome(head, revList);
    }

    private static void printList(ListNode revList) {

        while(revList!=null){
            System.out.print(revList.getData() + " -> ");
            revList = revList.next;
        }
    }

    private static boolean isPallindrome(ListNode head, ListNode revList) {

        System.out.println("Head List below :");
        printList(head);
        System.out.println();

        while(head!=null && revList!=null){
            if(head.getData() == revList.getData()){
                head = head.next;
                revList = revList.next;
            }else{
                return false;
            }
        }


        if(head!=null){
            System.out.println("head data" + head.getData());
        }
        if(head==null && revList==null)
            return true;
        else
            return false;
    }

    private static ListNode reverseList(ListNode p1) {

        ListNode current = p1;
        ListNode prev = null;
        ListNode next = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
