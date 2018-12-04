package adobe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestSubArray0s1s {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ="";

        try {
                line = br.readLine();
                int t = Integer.parseInt(line);

                while(t-->0){
                    line = br.readLine();
                    int n = Integer.parseInt(line);
                    int ar[] = new int[n];
                    line = br.readLine();
                    String[] str= line.split(" ");

                    for(int i=0; i<n; i++){
                        int val = Integer.parseInt(str[i]);
                        ar[i]= val;
                    }

                    int result = calculateMaxLen(ar, n);

                    System.out.println("Answer :" + 2*result);
                }

        }finally {
            br.close();
        }

    }

    private static int calculateMaxLen(int[] ar, int n) {

        int sum =0;
        for(int i = 0; i<n; i++){
            sum = sum + ar[i];
        }
        return (sum>(n-sum)?(n-sum):sum);
    }
}
