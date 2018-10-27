package com.jatin.blueoptima.practice;

import java.util.*;

public class firstLastPath extends Thread{


    public static void main(String[] args) {



        firstLastPath ls = new firstLastPath();
        Thread t1 = new Thread(ls,"Jatin");
        Thread t2 = new Thread(ls,"Bharat");


        ls.runB();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();



        /*2.start();
        //throw new NullPointerException();


        Scanner s = new Scanner(System.in);
        ArrayList <String>list = new ArrayList<String>();
        int n = s.nextInt();
        int t =n;
        while(t-- >0){
            list.add(s.next());
        }

        list.forEach( str -> {
            System.out.println(str);
        });

        Map<String,String> map = createMap(list);
        boolean check = findLongestPathHierarchy(map);*/

    }

    @Override
    public void run() {
        //System.out.println("YESSSSSS");
        if(Thread.currentThread().getName().equals("Jatin")){
            runB();
        }else{
            runA();
        }
    }

    private void runA() {

        System.out.println("Bharat");

    }

    private void runB() {

        throw new NullPointerException();
    }

    private static boolean findLongestPathHierarchy(Map<String,String> map) {

        ArrayList<String> paths = new ArrayList<String>();


        int count =0 ;

        //Map.Entry entry = (Map.Entry) map.entrySet();


        if(count== map.size()){

            return true;
        }
        else {
            return false;
        }
    }

    private static Map<String, String> createMap(ArrayList<String> list) {
        Map<String,String> map = new HashMap<String, String>();
        Iterator itr = list.iterator();
        int i=0;
        while(itr.hasNext()){
            String val = (String) itr.next();
            int n = val.length();
           // System.out.println("length :" + n);
            String key = val.charAt(0) + "" + i;
           // System.out.println("key :" + key);
            String value = val.charAt(n-1) + "" + i;
           // System.out.println("value" + value);
            map.put(key,value);
            i++;
        }

//
//
//        map.forEach((key,value) -> {
//            System.out.println("key :" + key + " value :" + value) ;
//        });
//
//

        map.entrySet().forEach(
                Entry -> {
                System.out.println("key :" + Entry.getKey() + " value :" + Entry.getValue());
                }
                );
        return map;
    }




}
