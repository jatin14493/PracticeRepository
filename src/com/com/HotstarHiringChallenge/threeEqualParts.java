package com.com.HotstarHiringChallenge;

/*
25/100
Three Equal parts
        You will be given a binary array A of length N. (Array filled with 0s and/or 1s)

        You need to divide the array in three parts (that is , three subarrays) in such a way that all these parts represent same value in decimal.

        If it is possible to divide the array, output the common decimal value modulo 1000000007 else output -1.

        See Sample test-case for better understanding.

        Note - Here binary to decimal conversion is done using standard conversion method, i.e., right to left( Example - 1010 is 10 not 5).


        Input format:

        First line represents the number of test-cases T.

        For each case:

        First line represent the number N, size of the array.

        Next line consists of N numbers either 0 or 1.


        Output format:

        For each case, output the required answer in new line.


        Constraints:






        Hint: Think greedily.

        Sample Input
        2
        5
        1 0 1 0 1
        5
        1 1 0 1 1
        Sample Output
        1
        -1
        Explanation
        In first case: array can be divided as: [1], [0 1], [0 1]. All these 3 parts represent common value '1' in decimal. Output 1

        In second case: array cannot be divided in 3 parts such that they can have common value in decimal. Output -1.*/


import java.util.Scanner;

public class threeEqualParts {



    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- >0){
            int n = s.nextInt();
            int []ar = new int[n];
            int counti =0;
            String val ="";
            //input done
            for(int i=0;i<n;i++){
                ar[i] = s.nextInt();
                val = val + ar[i];
                if(val.charAt(i)=='1'){
                    counti = counti + 1;
                }
            }

            if(counti%3!=0){
                //Basic Edge Case
                System.out.println("-1");
            }else if(counti == 0){
                System.out.println("0");
            }
            else if(ar[n-1] ==1 && counti==3 ){
                System.out.println("1");
            }else{
                //Main Logic here
                int number1s = counti/3;
                int size = 0;
                while (number1s != 0) {
                    size++;
                    if (val.charAt(n - size) == '1') {
                        number1s--;
                    }
                }


                int chk = 0;
                String pattern = val.substring(val.length() - size, val.length());
                int plen = pattern.length();
                int vlen = val.length();


                if((plen*3) > vlen)
                    System.out.println("-1");
                else {


                    for (int i = 0; i < vlen; ) {
                        int hashVal = createHash(pattern, val, i, i + plen - 1);
                        if (hashVal == 1) {
                            chk++;
                            i = i + plen;
                        } else {
                            i = i + 1;
                        }
                    }
                    if (chk == 3)
                        System.out.println(decimalNotation(pattern));
                    else
                        System.out.println("-1");
                }

            }
        }

    }

    private static String decimalNotation(String pattern) {

        long result =0l;
        long m = 1000000007;
        int pl =pattern.length();
        for(int i=0; i<pl; i++){
            int a =0;
            try{
                if(pattern.charAt(i) == '1')
                    a = Integer.parseInt(pattern.charAt(i)+"");
            }catch (Exception e){

            }
            if(a==1) {
                //long v =  Math.pow(2, pl - i - 1) % m;
                long v = (long)computePower(2,pl-i-1,m);
                long prod = ( ( a % m) * ( (long)v % m ) ) % m;
                result = ( ( result % m ) + ( prod % m ) ) % m;
            }

        }
        return result+"";

    }

    private static long computePower(long x, long y, long m) {
        long res = 1l;
        x = x % m;

        while (y > 0)
        {
            if((y & 1)==1)
                res = ( ( res % m) * ( x % m ) ) % m;  //(res*x) % m;

            y = y >> 1;
            x = ( ( x % m) * ( x % m ) ) % m; //(x*x) % m;
        }
        return res;
    }

    private static int createHash(String pattern, String line, int start, int i1) {
        int vl =0;
        for(int j=start ; j<i1; j++){

            if(line.charAt(j) == pattern.charAt(vl)){
                vl++;
            }else
            {
                return -1;
            }
        }
        return 1;
    }




}


//HackerEarth Working Code



/*
public class <className>
{
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- >0){
            int n = s.nextInt();
            int []ar = new int[n];
            int counti =0;
            String val ="";
            //input done
            for(int i=0;i<n;i++){
                ar[i] = s.nextInt();
                val = val + ar[i];
                if(ar[i]==1){
                    counti = counti + 1;
                }
            }

            if(counti%3!=0){
                //Basic Edge Case
                System.out.println("-1");
            }else if(counti == 0){
                System.out.println("0");
            }else{
                //Main Logic here
                int number1s = counti/3;
                int size = 0;
                while (number1s != 0) {
                    size++;
                    if (ar[n - size] == 1) {
                        number1s--;
                    }
                }

                int chk = 0;
                String pattern = val.substring(val.length() - size, val.length());
                int plen = pattern.length();
                int vlen = val.length();
                for (int i = 0; i < vlen; ) {
                    int hashVal = createHash(pattern, val, i, i + plen - 1);
                    if (hashVal == 1) {
                        chk++;
                        i = i + plen;
                    } else {
                        i = i + 1;
                    }
                }
                if (chk == 3)
                    System.out.println(decimalNotation(pattern));
                else
                    System.out.println("-1");

            }
        }
    }

    private static String decimalNotation(String pattern) {
        long result =0l;
        long m = 1000000007;
        int pl =pattern.length();
        for(int i=0; i<pl; i++){
            int a =0;
            try{
                if(pattern.charAt(i) == '1')
                    a = Integer.parseInt(pattern.charAt(i)+"");
            }catch (Exception e){

            }
            if(a==1) {
                //(long) Math.pow(2, pl - i - 1) % m;
                long v = (long)computePower(2,pl-i-1,m);
                long prod = ( ( a % m) * ( v % m ) ) % m;
                result = ( ( result % m ) + ( prod % m ) ) % m;
            }

        }
        return result+"";
    }

    private static long computePower(long x, long y, long m) {
        long res = 1;
        x = x % m;

        while (y > 0)
        {
            if((y & 1)==1)
                res = ( ( res % m) * ( x % m ) ) % m;  //(res*x) % m;

            y = y >> 1;
            x = ( ( x % m) * ( x % m ) ) % m; //(x*x) % m;
        }
        return res;
    }

    private static int createHash(String pattern, String line, int start, int i1) {
        int vl =0;

        for(int j=start;j<i1;j++){

            if(line.charAt(j) == pattern.charAt(vl)){
                vl++;
            }else
            {
                return -1;
            }
        }
        return 1;
    }

}*/
