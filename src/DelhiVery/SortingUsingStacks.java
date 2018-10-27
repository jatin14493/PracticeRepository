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
        Stack<Integer> st= new Stack<>();

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
        }

        //Sorting in Ascending Order

        for(int i=0; i<n; i++){
            if(st.isEmpty()){
                st.push(stack.pop());
            }else{

            }
        }
    }
}
