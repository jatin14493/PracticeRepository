package RangDe;

import java.util.*;

//Asumption :
//Input received from user in Standard form i.e. sorted in terms of degree

public class TestClass {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String eq = s.nextLine();
        int x = s.nextInt();
        Map<Integer, Integer> hashMap = new TreeMap<>();
        Stack<Character> stack = new Stack<>();
        //degree  : coefficient


        //2x 3 - 6x 2 + 2x - 1
        //2x3 - 6x2 - 1 - 2x
        eq = eq.replaceAll(" ", "");
        System.out.println(eq);

        String temp = eq;
        boolean flag = false;
        Boolean allFalse = false;

        int coeff = 1;
        int degree = 0;
        int factor = 1;

        //For constant +ve and -ve checking
        char lastScannedChar = '\0';
        char prev = '\0';

        int count =0;
        for(int i=0; i<eq.length(); i++){
            if(eq.charAt(i) == '-'){
                count ++;
            }
        }

        String [] split = eq.split("-");
        if(count == split.length){
            allFalse = true;
        }

        if (temp.length() == 1) {
            if(temp.charAt(0) == 'x')
                hashMap.put(1,1);
            else
                hashMap.put(0,1);
        }else if(!temp.contains("x")){
            try{
            int num = Integer.parseInt(temp);
            hashMap.put(0,num);
            }catch (Exception e){

            }
        }else{



        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);

            if (c == 'x' || c == '+' || c == '-') {
                //c == x || c== '+'


                //Base case for polynomial staring with x
                if(c=='-' && i==0)
                    factor = -1;



                //String containing x and starting with -ve sign(i.e. Co-efficient of highest degree is negative)
                if(c=='-')
                    factor =-1;


                // For Constant not coming at the end
                else if (prev == 'x' && flag) {
                    degree = 1;
                    flag = false;
                    hashMap.put(degree, coeff);
                    coeff = 1;
                    degree = 0;
                }


                else {

                    String num = "";

                    if (stack.isEmpty() && num == null) {
                        num = "1";
                    } else {
                        while (!stack.isEmpty()) {
                            char val = stack.pop();
                            num = val + num;
                        }
                    }

                    if (!flag) {
                        try {
                            coeff = Integer.parseInt(num);
                        } catch (Exception e) {
                            System.out.println("Break1");
                            //coeff =-1;

                        }

                        if (factor == -1) {
                            coeff = coeff * factor;
                            factor = 1;
                        }

                        flag = true;

                    } else {
                        try {
                            degree = Integer.parseInt(num);
                        } catch (Exception e) {
                            System.out.println("Break2");
                            //break;
                        }

                        flag = false;
                    }


                    //after completing 2 iterations
                    if (!flag) {
                        hashMap.put(degree, coeff);
                        coeff = 1;
                        degree = 0;
                    }

                }
            } else {

                stack.push(c);
            }

            prev = c;
        }
    }

            String num ="";
            if(!stack.isEmpty()){
                while (!stack.isEmpty()) {
                    char val = stack.pop();
                    num = val + num;
                }


                try {
                    coeff = Integer.parseInt(num);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(lastScannedChar =='-')
                    coeff = coeff *-1;

                hashMap.put(0,coeff);
            }else if(flag && prev =='x'){
                hashMap.put(1,coeff);
            }


        hashMap.entrySet().forEach(entry -> System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue()));

    }
}
