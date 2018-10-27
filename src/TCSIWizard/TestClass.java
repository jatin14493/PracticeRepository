package TCSIWizard;

import java.io.*;
import java.util.*;


public class TestClass {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String S = br.readLine();
        int Q = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[Q];
        for(int i_arr=0; i_arr<Q; i_arr++)
        {
            arr[i_arr] = br.readLine();
        }

        Long[] out_ = helpPrivateRyan(S, arr);
        System.out.print(out_[0]);
        for(int i_out_=1; i_out_<out_.length; i_out_++)
        {
            System.out.print(" " + out_[i_out_]);
        }

        wr.close();
        br.close();
    }

    static Long[] helpPrivateRyan(String S, String[] arr){
        // Write your code here
        Long ar[] = new Long[arr.length];
        
        for(int i=0 ; i <arr.length; i++){
            String s = arr[i];
            Long answer =0L;

            for(int j=0; j<S.length(); j++) {

                String c = S.charAt(j) + "";
                if(s.contains(c)){
                    answer = answer + computeAnswer1(j);
                }
            }
            ar[i] = answer;

        }

        return ar;
    }

    private static Long computeAnswer1(int v) {
        Long val =1L;
        int mod = 1000000007;


        while(v-- > 0){
            val = (val%mod * 2)%mod;
        }

        return val;
    }

}