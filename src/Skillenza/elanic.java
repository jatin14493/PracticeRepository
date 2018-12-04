package Skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class elanic {


    static final int MAX_CHAR = 26;

    static int factorial(int n)
    {
        int val = 1;
        for (int i = 2; i <= n; i++)
            val = val * i;
        return val;
    }

    static int countDistinctPermutations(String str)
    {
        int len = str.length();

        int[] freq = new int[MAX_CHAR];

        for (int i = 0; i < len; i++)
            if (str.charAt(i) >= 'a')
                freq[str.charAt(i) - 'a']++;


        int val = 1;
        for (int i = 0; i < MAX_CHAR; i++)
            val = val * factorial(freq[i]);

        return factorial(len) / val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            String str = br.readLine();
            System.out.println(countDistinctPermutations(str));
        }
    }
}
