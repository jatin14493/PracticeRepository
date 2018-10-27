package com.com.HotstarHiringChallenge;

/*Festivals
        Alice likes festivals a lot as we all do. He also likes spending money on these festivals.
        He spends money in buying various things on these festivals. But he has problem of forgetting.
        He only remembers his top three maximum spendings for any festival.
        For eg, on Holi he spends 25 units on colors, 50 units on water sprays, 100 units on gifts, 150 units on sweets but he remebers only his top 3 spendings ,i.e., 50, 100 & 150.
        Now as the year ends he wants to know the festival on which he spent most of his money that he can remember.

        Input Format

        First line contains an integer T, denoting number of test cases.
        Second line contains an integer N, denoting number of spendings in a year.
        Each of the next N lines contain a string S and an integer X denoting festival name and spending on one of the events of that festival.

        Output Format

        For each test case, print a single line containing the festival name and its total spending that he remembers.
        If there are more than 1 festival with the maximum spending, print the one which has lexiographically smallest name.

        Constraints

        S will consist of lowercase and/or uppercase English aplhabets



        Hint: Hash Tables


        Sample Input
        2
        6
        B 20
        A 2
        A 10
        A 10
        B 30
        A 30
        3
        abc 10
        xyz 15
        oop 8
        Sample Output
        A 50
        xyz 15
        Explanation
        Test Case 1 :

        Festival : A, He forgets 2 as he can remember only three max spendings. So he remembers 10 + 10 + 30 = 50

        Festival : B, He spent only two times i.e with 20 and 30 units. So he remembers 50 .

        Since total spending for both fetivals is same, we have to chose the festival with lexicographically smallest name. So, our answer is 'A 50'.

        Test Case 2:

        Festival: abc - Amount spent - 10

        Festival: xyz - Amount spent - 15

        Festival: oop - Amount spent - 8

        As spendings on xyz are highest. So answer is 'xyz 15'.


        //Solution :
        A = 42 freq =4 , B = 40 freq = 2
        H1 : key -> festival value -> total
        H2 : key -> festival value -> frequency

        Totalval_freq_min_

        */



import java.util.*;

class obj{
    private String keys;
    private int val;

    public void forEach(Object o) {
    }

    public String getKeys() {
        return keys;
    }

    public int getVal() {
        return val;
    }

    public obj(String keys, int val) {
        this.keys = keys;

        this.val = val;
    }
}


class ObjectChainedComparator implements Comparator<obj> {



    private List<Comparator<obj>> list;

    @SafeVarargs
    public ObjectChainedComparator(Comparator<obj>... comparators) {
            this.list = Arrays.asList(comparators);
        }

        @Override
        public int compare(obj con1, obj con2) {
            for (Comparator<obj> comparator : list) {
                int result = comparator.compare(con1, con2);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }



}


class ObjectKeyComparator implements Comparator<obj> {


    @Override
    public int compare(obj o1, obj o2) {
        return o1.getKeys().compareTo(o2.getKeys());

    }
}


class ObjectValueComparator implements Comparator<obj> {

    @Override
    public int compare(obj o1, obj o2) {
        return o2.getVal() - o1.getVal();

    }
}


public class Festivals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0){
            int n =s.nextInt();
            List<obj> list = new ArrayList<obj>(n);
            int i=0;
            while(i<n) {
                i++;
                String key = s.next();
                int val = s.nextInt();
                obj o = new obj(key, val);

                list.add(o);
            }
            Collections.sort(list, new ObjectChainedComparator(
                    new ObjectKeyComparator(),
                    new ObjectValueComparator())
            );

            Map<String,String> hm = new TreeMap<String,String>();
            for(int j=0; j<list.size(); j++){
                obj o1 = (obj)list.get(j);
                String key = o1.getKeys();
                int val = o1.getVal();
                int freq =0;
                if(!hm.containsKey(key)){
                    freq =1;
                    String concat = val+"_"+freq;
                    hm.put(key,concat);
                }else{
                     String concat = hm.get(key);
                     int val1 =0;
                     try {
                         val1 = Integer.valueOf(concat.substring(0, concat.indexOf("_")));
                         freq = Integer.valueOf(concat.substring(concat.indexOf("_")+1,concat.length()));
                     }catch (Exception e){
                     }
                    if(freq<3) {
                        val = val + val1;
                        freq = freq + 1;
                        concat =  val+"_"+freq;
                        hm.put(key,concat);
                    }

                }
            }//Map constructed with values

            //Collection c = hm.entrySet();
            /*Iterator itr = hm.entrySet().iterator();
            int max =-1;
            String ans ="";

            while(itr.hasNext()){
                int vl =0;
                Map.Entry entry = (Map.Entry) itr.next();
                String key = (String)entry.getKey();
                String concat = (String) entry.getValue();
                try{
                 vl = Integer.valueOf(concat.substring(0,concat.indexOf("_")));
                }catch (Exception e){

                }
                if(vl > max){
                    max = vl;
                    ans = key;
                }
            }*/

            Set<Map.Entry<String, String>> set = hm.entrySet();
            List<Map.Entry<String, String>> list1 = new ArrayList<Map.Entry<String, String>>(set);
            Collections.sort( list1, new Comparator<Map.Entry<String, String>>()
            {
                public int compare( Map.Entry<String, String> o1, Map.Entry<String, String> o2 )
                {
                    String a =o2.getValue().substring(0,o2.getValue().indexOf("_"));
                    String b = o1.getValue().substring(0,o1.getValue().indexOf("_"));
                    return (a).compareTo(b);
                }
            } );

            String ans ="";
            int max =-1;

            for(Map.Entry<String, String> entry:list1){
                int vl =0;
                String key = (String)entry.getKey();
                String concat = (String) entry.getValue();

                try{
                    vl = Integer.valueOf(concat.substring(0,concat.indexOf("_")));
                }catch (Exception e){

                }
                ans = key;
                max =vl;
                System.out.println(ans + " " + max);
                break;
            }

            System.out.println(ans + " " + max);
            }//while ends here
        }

}
