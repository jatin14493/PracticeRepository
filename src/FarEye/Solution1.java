package FarEye;

import java.io.IOException;
import java.util.*;

public class Solution1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int votesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] votes = new String[votesCount];

        for (int i = 0; i < votesCount; i++) {
            String votesItem = scanner.nextLine();
            votes[i] = votesItem;
        }

        String res = electionWinner(votes);

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }

    private static String electionWinner(String[] votes) {
        String ans="";
       Map<String,Integer> hmap = new TreeMap<>(
               new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }
);

        ArrayList <Map.Entry>list = new ArrayList<Map.Entry>(votes.length);



        for(int i=0; i<votes.length; i++){
            if(!hmap.containsKey(votes[i]))
                hmap.put(votes[i], 1);
            else
            {
                int val = hmap.get(votes[i]);
                hmap.put(votes[i],val+1);
            }
        }


        hmap.entrySet().forEach(t -> {
            System.out.print("key :" + t.getKey() + "val: " + t.getValue());
            list.add(t);
            System.out.println();
        });

        list.sort(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                int val1 = (Integer) o1.getValue();
                int val2 = (Integer) o2.getValue();
                return val2 - val1;
            }
        });

        list.forEach(t -> {
            System.out.println(t);
        });
        ans = (String) list.get(0).getKey();
        return ans;
    }

    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }
}


class ValueComparator implements Comparator<String>{

    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ValueComparator(HashMap<String, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {

//        if(map.get(s2) >= map.get(s1)){
//            return -1;
//        }else{
//            return 1;
//        }

        return s2.compareTo(s1);

    }
}