package Epsilon;

import java.util.HashSet;
import java.util.Scanner;

public class BinaryCoefficient {

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);
        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');


        int t = s1.nextInt();

        while(t-- > 0){

            String s = s1.next();
            int N = s.length();

            Long sum=0L;

            char []ar1 = s.toCharArray();

//            int i=0;
//           for(Character c : ar1){
//
//                    if(!hs.add(c)){
//                        Long val = Long.valueOf((i+1)*(N-i));
//                        sum = sum + val;
//                    }
//                    else{
//                        hs.remove(c);
//                    }
//                    i++;
//            }

            for(int i=0; i<N; i++){

                if(hs.add(ar1[i])){
                    hs.remove(ar1[i]);
                }else{
                    int val =N-i;
                    //System.out.println( "N-i : " + val);
                    sum =  sum + val;
                }
                //System.out.println("sum before entering loop :" + sum);

                int prev =0 ;
                for(int j = i+1; j<N; j++){

                    if(hs.add(ar1[j])){
                        hs.remove(ar1[j]);
                    }else{
                        prev = prev + 1;
                    }

                    if(prev!=0){
                        sum = sum + prev;
                    }

                }

                //System.out.println("sum after exiting loop :" + sum);

            }

            System.out.println(sum);

        }
    }
}
