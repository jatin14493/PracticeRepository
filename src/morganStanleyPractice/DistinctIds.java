package morganStanleyPractice;

import java.util.*;

public class DistinctIds {

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int ar[] = new int[n];
            for(int i=0;i<n;i++){
                ar[i] = s.nextInt();
            }
            int m = s.nextInt();
            int answer = calculateDistinctId(ar,n,m);
            System.out.println("Answer of test case :" + answer);

            t--;
        }
    }

    private static int calculateDistinctId(int[] ar, int n, int m) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count =0;
        int size =0;

        for(int i=0;i<n;i++){
            if(map.containsKey(ar[i]) ==false){
                map.put(ar[i],1);
                size++;
            }else{
                int l = map.get(ar[i]);
                map.put(ar[i],l+1);
            }
        }// Map build from Array

        System.out.println(map.entrySet());
        
        sortByValues(map);

        /*
        //Flawed logic failed for test case : 1,1,1,2,3,1
        for(Map.Entry<Integer,Integer> mp : map.entrySet()){

            if (mp.getKey() <= m)
            {
                m -= mp.getKey();
                count++;
            }else
                return size-count;
        }*/
        return size - count;
    }

    private static void sortByValues(Map<Integer,Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

    }
}
