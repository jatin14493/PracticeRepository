package com.jatin.blueoptima.practice;


/*
Find the Longest path hierarchy in a given file
        Ram:Hari
        Bharat:Krishan
        Hari:Raja
        Krishan:Vivek
        Pramod:Abdul
        Abdul:Lalit
        Raja:Raju
        Raju:Jaga

        out put : Ram -> Hari -> Raja -> Raju -> Jaga
*/

import java.util.*;

public class longestHierarchy {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("Ram","Hari");
        map.put("Bharat", "Krishan");
        map.put("Hari", "Raja");
        map.put("Krishan", "Vivek");
        map.put("Pramod", "Abdul");
        map.put("Abdul", "Lalit");
        map.put("Raja", "Raju");
        map.put("Raju", "Jaga");
        findLongestPathHierarchy(map);

    }

    private static void findLongestPathHierarchy(Map<String,String> map) {
        String path = "";
        ArrayList<String> entrypoint = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>(map.values());
        Set<String > keys = map.keySet();
        Iterator iterator = keys.iterator();
        while(iterator.hasNext()){
            String key = (String)iterator.next();
            if(!list.contains(key)){
                entrypoint.add(key);
            }
        }


        //paths
        ArrayList<String> paths = new ArrayList<String>();

        for(int i=0; i<entrypoint.size(); i++){
            String key = entrypoint.get(i);
            String value = map.get(key);
            path = key + " -> ";
            while(map.containsKey(value)){
                path = path + value + " -> ";
                value = map.get(value);
            }
            path = path + value;

            //Add path to the arraylist
            paths.add(path);
            path = "";
        }


        System.out.println(paths);

        int size = 0;
        int index = -1;

        for(int i=0; i<paths.size(); i++){

            String val = paths.get(i);
            String []tokens = val.split(" -> ");
            int localSize = tokens.length;
            if(localSize > size){
                size = localSize;
                index = i;
            }

        }

        System.out.println("Longest Hierarchy :" + paths.get(index));
    }
}
