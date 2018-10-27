package com.jatin.blueoptima.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class FunRiddle {
    public static void main(String[] args) {
        int affinity[][] = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
        String items[] = { "Tiger", "Goat", "Grass" };
        int inputItems = items.length;
        FunRiddle(inputItems, affinity, items);
    }

    static void FunRiddle(int inputItems, int[][] affinity, String[] items) {
        LinkedList<String> shore1 = new LinkedList<String>();
        Collections.addAll(shore1, items);

        System.out.println(shore1);

        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        for (int i = 0; i < shore1.size(); i++)
            temp.put(shore1.get(i), i);

        temp.entrySet().forEach(Entry ->

                {
                    System.out.println("key :" + Entry.getKey() + " value :" + Entry.getValue());
                }
        );

        LinkedList<String> shore2 = new LinkedList<String>();

        while (!shore1.isEmpty()) {

            String Shore1Value = shore1.poll();

            boolean flag = checkStability(shore1, temp, affinity);
            if (flag == true) {
                shore1.offer(Shore1Value);
            } else {

                if (shore2.isEmpty()) {

                    shore2.offer(Shore1Value);
                    System.out.println("" + shore2.getLast() + " [From shore A to B]");
                    System.out.println("Empty [From shore B to A]");
                } else {

                    shore2.offer(Shore1Value);
                    System.out.println("" + shore2.getLast() + " [From shore A to B]");

                    if (shore1.isEmpty())
                        break;

                    flag = checkStability(shore2, temp, affinity);

                    if (flag) {

                        String shore2Value = shore2.poll();
                        shore1.offer(shore2Value);
                        System.out.println(shore2Value + " [From shore B to A]");
                    } else {

                        System.out.println("Empty [From shore B to A]");
                    }
                }

            }

        } // end while
    }

    static boolean checkStability(List<String> list, Map<String, Integer> map, int affinity[][]) {

        boolean flag = false;

        if (list.size() <= 1)
            return false;

        String key = list.get(0);
        System.out.println("key" + key);
        int index1 = 0, index2 = 0;
        index1 = map.get(key);
        System.out.println("index1 :" + index1);


        for (int i = 1; i < list.size(); i++) {
            String value = list.get(i);
            index2 = map.get(value);
            int data = affinity[index1][index2];
            if (data == 1)
                flag = true;
        }

        return flag;
    }

}
