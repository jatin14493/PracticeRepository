package EdgeVerve;

import java.util.Scanner;

public class program1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- >0){
            long n1 = s.nextLong();
            long n = 0l;
            int max = 1;

            if(n1<0)
             n = n1 * -1;

            System.out.println("n1 :"+ n1);


            for(int i=2; i<=Math.sqrt(n); i++){
            int answer = computeAnswer(i,n);
            if(answer > max){
                if(n1>0) {
                    max = answer;
                    break;
                }else{
                    if(answer%2 != 0){
                        max = answer;
                        break;
                    }
                }
            }

            }

            System.out.println("Answer :" + max);
        }
    }

    private static int computeAnswer(int b, long n) {
        long res = 1;
        int ans =0;
        int result =1;
        while(res < n){
            ans++;
            res = res * b;
            
            if(res == n){
                result = ans;
            }
        }

        return result;
    }
}
