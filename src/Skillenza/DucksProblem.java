package Skillenza;

import java.util.*;

public class DucksProblem {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- >0){
            int n = s.nextInt();
            int []ar = new int[n];
            LinkedList <Integer>stack = new LinkedList<>();
            Stack <Integer> st = new Stack<>();


            for(int i=0;i<n;i++){
                ar[i] = s.nextInt();
            }

            if(n==1)
                System.out.println("1");
            else if(n==2){
                if(ar[0] > ar[1]){
                    System.out.println("2 1");
                }else if(ar[1] > ar[0]){
                    System.out.println("1 2");
                }else{
                    System.out.println("1 1");
                }
            }else{
                //main logic here!!
               List<Integer> list = new ArrayList<>();
                int prev = ar[0];
                int prev_val = 1;
                if(ar[0] < ar[1]){
                    //stack.push(1);
                    st.push(prev_val);
                    prev_val += 1;
                    //list.add(1);
                }else{
                    stack.add(prev_val);
                    prev_val = prev_val+1;
                    //list.add(2);

                }
                for(int i=1; i<n-1; i++){
                    if(ar[i]>prev){

                        while(!st.isEmpty()){
                            list.add(st.pop());
                        }
                        stack.add(prev_val);
                        prev_val = prev_val+1;

                       //list.add(prev_val);

                    }else if(ar[i]>ar[i+1]){
                        while(!stack.isEmpty()){
                            list.add(stack.removeFirst());
                        }

                        st.push(prev_val);
                        prev_val += 1;

                    }else{

                        if(!stack.isEmpty()){
                        while(!stack.isEmpty()){
                            list.add(stack.removeFirst());
                        }

                        prev_val = 1;
                        stack.add(prev_val);
                        }else{
                            while(!st.isEmpty()){
                                list.add(st.pop());
                            }

                            prev_val = 1;
                            st.push(prev_val);
                        }
                        //list.add(prev_val);

                    }
                    prev = ar[i];
                }

                if(ar[n-1] > ar[n-2]){

                    stack.add(prev_val);
                    while(!stack.isEmpty()){
                        list.add(stack.removeFirst());
                    }


                }else{
                    st.push(prev_val);

                    while(!st.isEmpty()){
                        list.add(st.pop());
                    }


                }





                list.forEach(str -> {
                    System.out.print(str + " ");
                });
                System.out.println();
            }
        }
    }
}


//2 1 2 1 2 3 1 2 1 2 1
//2 1 2 1 2 3 1 2 1 2 1


//1 2 1 1 2 3 1 1 2 3 1 1 1 1 2 3 1 2 3 1 2 3 1 2 3 1 1 2 1 2 1 2 3 1 1
//1 2 1 1 3 2 1 1 3 2 1 1 1 1 2 2 1 2 2 1 2 3 1 2 2 1 1 2 1 2 1 3 2 1 1
