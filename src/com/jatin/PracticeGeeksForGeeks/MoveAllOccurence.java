package com.jatin.PracticeGeeksForGeeks;

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }

}

public class MoveAllOccurence {

    static Node root;

    public static void main(String[] args) {


            root = new Node(2);
            root.next = new Node(5);
            root.next.next = new Node(2);
            root.next.next.next = new Node(7);
            root.next.next.next.next = new Node(2);
            root.next.next.next.next.next = new Node(2);
            root.next.next.next.next.next.next = new Node(2);

            int key = 2;
            System.out.println("Linked List before operations :");
            display(root);
            System.out.println("\nLinked List after operations :");
            root = keyToEnd(root, key);
            display(root);

    }

    private static Node keyToEnd(Node root, int key) {

        Node tail= root; //second last pointer

        while(tail.next!=null){
            tail =  tail.next;
        }

        Node last = tail;

        Node prev =null;
        Node prev2 =null;
        Node current = root;
        while(current!=tail){   // travesral for entire list.

            if(current.data == key && prev2 == null){
                prev = current;
                current = current.next;
                root = current;
                last.next = prev;
                last = last.next;
                last.next = null;
                prev = null;
            }else{
                if(current.data == key && prev2!= null){
                    prev = current;
                    current = current.next;
                    prev2.next =current;
                    last.next = prev;
                    last = last.next;
                    last.next = null;
                }else{
                    prev2 = current;
                    current = current.next;
                }

            }

        }

        return root;
    }

    private static void display(Node root) {
        Node temp = root;
        while(temp.next.next!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        temp = temp.next;
        System.out.println(temp.data);
    }
}
