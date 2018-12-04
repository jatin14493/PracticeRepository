package DelhiVery;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SortingUsingStacks {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.nextInt();
        int ar[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp= new Stack<>();

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
            stack.push(ar[i]);
        }



        //Sorting in Ascending Order

        while(!stack.isEmpty()){
            int val = stack.pop();

            while(!temp.isEmpty() && temp.peek()>val){
                stack.push(temp.pop());
            }

            temp.push(val);
        }

        int x = temp.size();

        for(int i=0; i<x; i++){
            System.out.print(temp.pop() + "->");
        }
    }
}
