package com.com.java.com.java.Sorocco;

import java.util.HashSet;

public class arrayRangeCompacting {

    public static void main(String[] args) {
        int ar[] ={-3,-2,-1,5,6,7,9,11,12,13,15,16};
        String answer ="";
        answer = compactArrays1111(ar);
        System.out.println(answer);
    }

    private static String compactArrays1111(int[] ar) {
        String ans ="";
        HashSet<Integer>hs = new HashSet<Integer>(ar.length);
        for(int i =0; i<ar.length; i++){
            hs.add(ar[i]);
        }

        if(ar.length ==1){
            return ar[0]+"";
        }else if(ar.length==2){
            return ar[0]+","+ar[1];
        }else if(ar.length ==3){
            if((ar[2] -ar[1]) == 1 && (ar[1] -ar[0])==1 || (ar[2] -ar[1]) == -1 && (ar[1] -ar[0])== -1){
                return ar[0]+"-"+ar[2];
            }
        }else {

            boolean isflag = false;
            int start =0;
            for (int i = 0; i < ar.length-1; ){

                while(ar[i+1]-ar[i]==1 && i<=ar.length-1){
                    i= i+1;
                    try{
                        int t = ar[i+1] - ar[i];
                    }catch (Exception e){
                        isflag = true;
                        break;
                    }
                }
                //here i=2
                if(i-start >=2 ) {
                    ans = ans + ar[start] + "-" + ar[i] + ",";
                    i=i+1;
                    start =i;
                }else if(isflag){
                    ans = ans + ar[i-1] + "," + ar[i] + "," ;
                }else{
                    ans = ans + ar[i] + ",";
                    i=i+1;
                    start=i;
                }

                System.out.println("value : i : " + i);
            } /*{

                int diff = ar[i] - ar[start];
                while (diff == 1 && i < ar.length-1) {
                    i = i + 1;
                    diff = ar[i] - ar[i - 1];
                }
                System.out.println("value of i : " +i);
                System.out.println("value of start : " +start);

                if ((i-1) - start >= 2) {
                    ans = ans + ar[start] + "-" + ar[i - 1] + ",";
                    start = i;
                    i=i+1;
                } else {
                    ans = ans + ar[i] + ",";
                    i = i + 1;
                }


            }*/
        }
        ans = ans.substring(0,ans.length()-1).trim();




        return ans;
    }


}
