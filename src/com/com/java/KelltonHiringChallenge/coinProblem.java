package com.com.java.KelltonHiringChallenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class coinProblem {



    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        boolean isFlag = false;
        int n = s.nextInt();
        ArrayList<Integer>list = new ArrayList<Integer>(n);
        int []ar = new int[n];  //sorted array will be created
        for(int i=0;i<n;i++){
            list.add(s.nextInt());
        }
        //sort the collection
        //Collections.sort(list);

        int mid = n/2;
        int lhalf = 0;
        int rhalf = 0;
        for(int i=0; i<n ; i++){
            ar[i] = list.get(i);
            if(i<mid){
                lhalf += ar[i];
            }else {
                rhalf += ar[i];
            }
        }

        rhalf =  rhalf - ar[mid];

        while(mid>0 && mid<n){
            if(lhalf > rhalf){
                rhalf = rhalf + ar[mid];
                lhalf = lhalf - ar[mid-1];
                mid = mid-1;

            }else if(lhalf < rhalf){
                lhalf = lhalf + ar[mid];
                rhalf = rhalf - ar[mid+1];
                mid = mid+1;
            }else{
                isFlag = true;
                break;
            }
        }

        if(isFlag)
            System.out.println("YES");
        else
            System.out.println("NO");



    }

}
