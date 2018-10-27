package whatFix;

import java.util.Scanner;

public class StringTokenizerPro {

    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        String str = s.nextLine();
        String result ="";
        boolean flag =  false;

        for(int i=0; i<str.length(); i++){
            char c  = str.charAt(i);
            if(c != ' ' && c!='"'){
                result += c;

                if(i==str.length()-1)
                    System.out.println(result);

            }else if(c ==' '){
                if(!flag){
                    System.out.println(result);
                    result = "";
                }else{
                    result += c;
                }
            }
            else{


                if(!flag){

                    flag = true;
                }
                else {

                    flag = false;
                }

                result += c;
                if(i==str.length()-1)
                    System.out.println(result);

            }
        }
    }
}
