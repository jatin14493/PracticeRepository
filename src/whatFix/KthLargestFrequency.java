package whatFix;

import java.util.*;
import java.util.stream.Collectors;

public class KthLargestFrequency {

    public static void main(String[] args) {
        String str = "aabbcbcd";
        char val = kthMostFrequent(str,3);
        if(val=='1')
            System.out.println("-1");
        else
            System.out.println("val :" + val);
    }


    public static Character kthMostFrequent(String strings, int k) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        for(int i=0; i<strings.length(); i++){
            char c = strings.charAt(i);
            Integer x = map.get(c);
            if (x == null) x = 0;
            map.put(c, ++x);
        }

        List<Map.Entry> list = new ArrayList(map.entrySet());

        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                Integer v1 = (Integer) ((Map.Entry) o1).getValue();
                Integer v2 = (Integer) ((Map.Entry) o2).getValue();
                return v2.compareTo(v1);
            }
        });


        int count = (Integer) list.get(0).getValue();
        int check =0;
        for(int i=1; i<list.size(); i++){
            int val = (Integer) list.get(i).getValue();
            if(val < count){
                check ++;
                count = val;
            }

            if(check ==k){
                return (Character) (list.get(i)).getKey();
            }
        }
        return '1';
    }
}
