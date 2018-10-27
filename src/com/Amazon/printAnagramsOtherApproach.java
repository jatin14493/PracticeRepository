package com.Amazon;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class printAnagramsOtherApproach {

    public static void main(String[] args) {

        String ar[] = {"cat", "dog", "tac", "god",
                "act", "gdo"};
        int size = ar.length;
        printAnagramsTogether(ar, size);
    }

    private static void printAnagramsTogether(String[] ar, int size) {

        int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
                97, 101 };

        LinkedHashMap<Integer, ArrayList<String>> h = new LinkedHashMap<>();

        for(int i = 0; i<ar.length; i++){
            int sum =1;
            for(int j=0; j<ar[i].length(); j++){
                int val = ar[i].charAt(j) - 'a';
                sum *= prime[val];

            }
            System.out.println(sum);

            ArrayList<String> g = h.get(sum);
            if(g==null){
                g = new ArrayList<String>();
            }

            g.add(ar[i]);
            h.put(sum, g);
        }

        for (Map.Entry<Integer, ArrayList<String> > e : h.entrySet()) {
            System.out.println(e.getValue());
        }
    }
}
