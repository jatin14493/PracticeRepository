package cars24;


/*Number formation
        You are given an array  of  integers. Each integer is a single digit number in the range . You are also given a number . Now, you need to count how many subsequences of the array  exist such that they form a  digit valid number.

        A subsequence of size  is called a valid number if there are no leading zeros in the number formed.

        Notes:

        A subsequence of an array is not necessarily contiguous.
        Suppose the given array is , then if you choose subsequence to be , then it is not a valid  digit number. Also, it will not be considered as a single digit number. A valid  digit number in the array is . Please go through the sample I/O for better understanding.
        Input Fomat

        The first line contains an integer  as input denoting the size of the array.
        Next line contains  space separated integers that denote elements of the array.
        Next line contains an integer .

        Output Format

        In the output, you need to print the count of valid  digit numbers modulo .

        Constraints



        Sample Input
        5
        1 1 0 1 0
        3
        Sample Output
        9
        Explanation
        In the given sample following are the possible subsequences that form a valid  digit number.*/


import java.util.Scanner;

public class NumberFormation {

    public static void main(String[] args) {



        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n];
        int mod = 720720;
        int zeroCount = 0;

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
            if(ar[i]==0)
                zeroCount = zeroCount + 1;
        }

        int k = s.nextInt();

        //preprocessingFunction(n,k);

        if(n < k){
            System.out.println(0);
        }
        else {



            int answer = 0;

            for(int j=0; j<n-1; j++) {

                for (int i = j+1; i < n - k; i++) {
                    if (ar[i] == 0) {
                        //do nothing
                    } else {
                        int temp = n-i-1;
                        answer = (answer + temp) % mod;
                    }
                }

            }
            System.out.println(answer);
        }


    }



}
