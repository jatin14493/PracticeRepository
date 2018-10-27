package cars24;

import java.util.Scanner;

public class HiddenNumber {

    public static void main(String[] args) {

            //Scanner
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();

            while(t-- > 0){

                int n = s.nextInt();
                long []ar = new long[n];
                long sum = 0L;


                for(int i=0; i<n; i++){

                    ar[i] = s.nextLong();
                    sum += ar[i];

                }

                long answer = sum / n;
                Double answer1 = (double)sum / n;

                Double diff = answer - answer1;
                //System.out.println(diff);

                if(diff == 0.0)
                    System.out.println(answer);
                else
                    System.out.println("-1");

            }



    }
}
