package Epsilon;

import java.util.LinkedList;
import java.util.Scanner;

public class HarryAndString {

    public static void main(String[] args) {



        Scanner s1 = new Scanner(System.in);
        int t = s1.nextInt();

        while(t-- > 0){

            Boolean good = false, worst =false;
            String s = s1.next();
            LinkedList<Integer> list = new LinkedList<>();
            int curr = 0;
            int prev = 0;
            String prevUpdate ="";
            int count =0;
            char ar[] = s.toCharArray();


            for(int i=0; i<s.length(); i++){
                //char temp = s.charAt(i);
                if(ar[i] == 'a' || ar[i] == 'e' || ar[i] == 'i' || ar[i] == 'o' || ar[i] == 'u'){
                    int val = ar[i] - 'a';
                    curr = val;
                    list.add(val);

                    if(count==0){
                        //Base Case
                        prev = val;
                        curr = val;

                    }else{

                        if(prev == curr){
                            if(prevUpdate == "good"){
                                good = true;
                                prevUpdate = "good";

                            }else if(prevUpdate == "worst"){
                                worst = true;
                                prevUpdate = "worst";
                            }else if(prevUpdate == "same"){
                                good = true;
                                worst = true;

                            }
                        }

                        else if(curr > prev){
                            good = true;

                            if(prevUpdate =="same"){
                                worst = false;
                            }
                            prevUpdate = "good";
                        }

                        else if(prev > curr){
                            worst = true;
                            if(prevUpdate =="same"){
                                good = false;
                            }
                            prevUpdate = "worst";
                        }
                    }

                    if(good && worst)
                        break;

                    count++;

                    prev = curr;



                }
            }



            if(count==0){
                System.out.println("Good");
            }else if(count == list.size() && good){
                System.out.println("Good");
            }else if(count == list.size() && worst){
                System.out.println("Worst");
            }else if(good && worst && count!=list.size()){
                System.out.println("Bad");
            }else{
                //In case String contains only 1 type of vowel
                System.out.println("Good");
            }

        }



    }
}






    /*Scanner s1 = new Scanner(System.in);
    int t = s1.nextInt();

        while(t-- > 0){
                Boolean good = false, worst =false;
                String s = s1.next();
                LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
        char temp = s.charAt(i);
        if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){

        list.add(val);
        }
        }

        if(list.size()==0){
        System.out.println("Good");
        }else{

        int i=0;
        for(int j=1; j<list.size(); j++){


        if(list.get(i) <= list.get(j)){
        good = true;
        }else if(list.get(j) <= list.get(i)){
        worst = true;
        }

        if(good && worst)
        break;

        i++;
        }


        if(i== list.size()-1 && good){
        System.out.println("Good");
        }else if(i == list.size()-1 && worst){
        System.out.println("Worst");
        }else{
        System.out.println("Bad");
        }
        }

        }


    */