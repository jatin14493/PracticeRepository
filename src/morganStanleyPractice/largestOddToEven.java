package morganStanleyPractice;

import java.util.Scanner;

class largestOddToEven {

    public static void main(String []args){
    Scanner s = new Scanner(System.in);
    int T = s.nextInt();
        while(T>0){
        int swap_index = -1;
        int inp = s.nextInt();
        int check2DigitNum = inp/100;
        int lastDigit = inp%10;
        String val = inp + "";
        int temp =0;
        for(int i=0; i<val.length(); i++){
            String vl = val.charAt(i) + "";
            try {
                temp = Integer.parseInt(vl);
            }catch (NumberFormatException e){
                System.out.println("Not a proper number!!");
            }
            if(check2DigitNum==0 && temp%2==0){
                swap_index = i;
                break;
            }
            if(temp%2==0 && temp<lastDigit){
                swap_index = i;
                break;
            }
        }
        if(swap_index==-1){
            System.out.println(val);
        }else{
            String ans = "";

            String valIndex_i = val.charAt(swap_index)+"";
            for(int i=0; i<val.length();i++){
                if(i==swap_index){
                    ans += val.charAt(val.length()-1);
                }else if(i==val.length()-1) {
                    ans+= valIndex_i;
                }
                else {
                    ans += val.charAt(i);
                }
            }

            System.out.println(ans);


        }
        T--;
    }
}
}


//2nd Approach to rotate

