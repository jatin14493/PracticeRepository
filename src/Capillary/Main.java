package Capillary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Double.*;

class Main{

    public static void process_data(String a, String b){

        int counter =0;
        boolean flag1 = false;
        boolean flag2 = false;
        try{
            double a1 = parseDouble(a);
        }catch (Exception ex){
            counter++;
            flag1 =true;
        }

        try{
            double a2 = parseDouble(b);
        }catch (Exception ex){
            counter++;
            flag2 = true;
        }

        if(counter ==2 || counter == 0){
            System.out.println("N");
        }

        else if(counter == 1){

            if(flag1){

                // if(a.length() >=1 && a.length()<=15){

                boolean atleastOneAlpha = a.matches(".*[a-zA-Z]+.*");

                // if(atleastOneAlpha){

                if(!b.startsWith("0")){
                    System.out.println("M");
                    return;
                }else{
                    System.out.println("N");
                    return;
                }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
                // }else{
                //     System.out.println("N");
                // }
            }
            else if(flag2){

                // if(b.length()>=1 &&  b.length()<=15){

                boolean atleastOneAlpha = b.matches(".*[a-zA-Z]+.*");

                // if(atleastOneAlpha){

                if(!a.startsWith("0")){
                    System.out.println("M");
                    return;
                }else{
                    System.out.println("N");
                    return;
                }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
                // }else{
                //     System.out.println("N");
                // }
            }
        }
    }

    public static void process_data(String a, String b, String c){

        int counter =0;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        try{
            double a1 = parseDouble(a);
        }catch (Exception ex){
            counter++;
            flag1 =true;
        }

        try{
            double a1= parseDouble(b);
        }catch (Exception ex){
            counter++;
            flag2 = true;
        }

        try{
            double a1 = parseDouble(c);
        }catch (Exception ex){
            counter++;
            flag3 = true;
        }

        if(counter == 3 || counter ==0 || counter ==2){
            System.out.println("N");
            return;
        }
        else if(counter == 1){

            if(flag1){

                // if(a.length() >=1 && a.length()<=15){

                boolean atleastOneAlpha = a.matches(".*[a-zA-Z]+.*");

                // if(atleastOneAlpha){

                if(!b.startsWith("0") && !c.startsWith("0")){
                    System.out.println("V");
                    return;
                }else{
                    System.out.println("N");
                    return;
                }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
                // }else{
                //     System.out.println("N");
                // }
            }
            else if(flag2){

                // if(b.length() >=1 && b.length()<=15){

                boolean atleastOneAlpha = b.matches(".*[a-zA-Z]+.*");

                // if(atleastOneAlpha){

                if(!a.startsWith("0") && !c.startsWith("0")){
                    System.out.println("V");
                    return;
                }else{
                    System.out.println("N");
                    return;
                }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
            }
            else if(flag3){

                // if(c.length()>=1 && c.length()<=15){

                boolean atleastOneAlpha = c.matches(".*[a-zA-Z]+.*");

                // if(atleastOneAlpha){

                if(!a.startsWith("0") && !b.startsWith("0")){
                    System.out.println("V");
                    return;
                }else{
                    System.out.println("N");
                    return;
                }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
                // }else{
                //     System.out.println("N");
                //     return;
                // }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCases; i++) {
            String line = br.readLine();
            String []token = line.split(" ");
            if(token.length == 2){
                process_data(token[0] , token[1]);
            }else if(token.length == 3){
                process_data(token[0] , token[1], token[2]);
            }else{
                System.out.println("N");
            }


        }


    }
}