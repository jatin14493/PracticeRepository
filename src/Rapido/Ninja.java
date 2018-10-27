package Rapido;

import java.util.Scanner;

public class Ninja {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- >0){
            String str = s.next();
            long result = 0l;
            if(str.contains("+")){
                long a  = Long.parseLong(str.substring(0, str.indexOf("+")));
                long b = Long.parseLong(str.substring(str.indexOf("+") +1 , str.length()));
                result = addNumber(a,b);
            }else if(str.contains("-")){
                long a  = Long.parseLong(str.substring(0, str.indexOf("-")));
                long b = Long.parseLong(str.substring(str.indexOf("-") +1 , str.length()));
                result = subtractNumber(a,b);
            }else if(str.contains("/")){
                long a  = Long.parseLong(str.substring(0, str.indexOf("/")));
                long b = Long.parseLong(str.substring(str.indexOf("/") +1 , str.length()));
                result = divideNumber(a,b);
            }else if(str.contains("*")){
                long a  = Long.parseLong(str.substring(0, str.indexOf("*")));
                long b = Long.parseLong(str.substring(str.indexOf("*") +1 , str.length()));
                result = multiplyNumber(a,b);
            }

            System.out.println(result);
        }
    }

    private static long multiplyNumber(long a, long b) {
        long val = a * b;
        String chk = val + "";
        if(chk.contains("8")){
            val = subtractNumber(val+1,1);
        }
        return val;
    }

    private static long divideNumber(long a, long b) {
        long val = 0l;
        String temp = a + "";
        if(temp.contains("9"))
            temp = temp.replaceAll("9","8");

        a = Integer.parseInt(temp);
        val = a/b;
        temp = temp + val;
        if(temp.contains("8")){
            val = subtractNumber(val+1, 1);
        }

        return val;
    }

    private static long subtractNumber(long a, long b) {
        long val = 0l;
        val = a - b;
        String chk = val + "";
        while(chk.contains("8")){
            int len = chk.substring(chk.indexOf("8"),chk.length()).length();
            long num = (long) Math.pow(10 , len)-1;
           // if(num > val)
           //     num = num/10;
            val = val - num;
            chk = val + "";
        }

        return val;
    }

    private static long addNumber(long a, long b) {
        long val = 0l;
        val = a+b;
        String chk = val + "";
        while(chk.contains("8")){
            int len = chk.substring(chk.indexOf("8"),chk.length()).length();
            long num = (long) Math.pow(10 , len-1);
            val = val + num;
            chk = val + "";
        }

        return val;
    }
}
