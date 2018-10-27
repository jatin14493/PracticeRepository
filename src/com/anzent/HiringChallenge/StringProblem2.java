package com.anzent.HiringChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringProblem2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder st = new StringBuilder(s.next());
        int  k = s.nextInt();
        int  n = st.length();
        String chk="";
        String answer = "";
        int count0 = 0;

        if(k==1) {
            answer = st.toString();
        }
        else if(k>=n){
            char []c  = st.toString().toCharArray();
            Arrays.sort(c);
            answer = String.valueOf(c);
        }
        else {
            while (n-- > 0) {

                int min_index =-1;
                int lc = 0;
                for (int i = 0; lc < k && count0 == n-k; i++) {
                    String vl = st.charAt(i) + "";

                    if (vl == null) {
                        continue;
                    }else if(chk ==null){
                        min_index = i;
                        chk = vl;
                        lc++;
                    }
                    else if (vl.compareTo(chk) < 0) {
                        min_index = i;
                        chk = vl;
                        lc++;
                    }
                }

                List t  = Arrays.asList(st);

                //t.foreach(()-> System.out.println(t.get( )));

                if (n >= k) {
                    answer = answer + chk;
                    chk = "";
                    st.setCharAt(0,'\0');
                } else {
                    char[] c = st.toString().toCharArray();  //O(k) operation
                    Arrays.sort(c); //O(klogk) on k elements
                    answer += String.valueOf(c);
                    break;
                }
                //else ends here

            }//while ends here
        }//outer else ends here
        System.out.println(answer);
    }
}

