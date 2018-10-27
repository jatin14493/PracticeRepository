package com.com.java.com.java.Sorocco;

import java.util.*;

public class stringDeduplication {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int chunk_size = s.nextInt();

        String dedupString = dedupe(line, chunk_size);

        System.out.println(dedupString);

        String redupString = redupe(dedupString,chunk_size);

        System.out.println(redupString);

    }

    private static String redupe(String dedupString, int chunk_size) {
        String answer ="";

        Map<Integer,String> hs = new TreeMap<Integer, String>();
        StringTokenizer keys = new StringTokenizer(dedupString ,",");
        while(keys.hasMoreTokens()){
            String b = (String) keys.nextToken();
            String hval= "";
            // System.out.println(b);
            StringTokenizer internalkeys = new StringTokenizer(b ,"-");
            while(internalkeys.hasMoreTokens()){
                int i= -1;
                String hkeys = (String) internalkeys.nextToken();
                try{
                    i = Integer.parseInt(hkeys);
                }catch(Exception e){
                    hval = hkeys;
                }
                if(i!=-1)
                hs.put(i,hval);
            }
        }

        Iterator i = hs.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry e = (Map.Entry) i.next();
            String temp = (String) e.getValue();
            answer += temp;
        }


        //hs.entrySet().stream().forEach(e-> System.out.println(e));
        return answer;
    }


    private static String dedupe(String line, int chunk_size) {
        Map<String,String>  hs = new TreeMap<String, String>();
        String answer ="";
        for(int i=0;i<line.length();i=i+chunk_size){
            String hashVal = createHash(line,i,i+chunk_size-1);
            //System.out.println("hashVal :" + hashVal);
            int offset = i/chunk_size;
            if(!hs.containsKey(hashVal)){
                hs.put(hashVal, hashVal+"-"+offset);
            }else{
                hs.put(hashVal, hs.get(hashVal) + "-" + offset);
            }
        }

        for(String value : hs.values()){
                answer = answer + value +",";
        }

        if(answer.lastIndexOf(",") == 0){
            answer = answer.substring(0,answer.length()-2).trim();
        }
        return answer;
    }

    private static String createHash(String line, int i, int i1) {
        String pattern = "";
        for(int j=i;j<=i1;j++){
            pattern = pattern + line.charAt(j);
        }
        return pattern;
    }

}






