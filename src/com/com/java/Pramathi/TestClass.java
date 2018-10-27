package com.com.java.Pramathi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Contestant {

    private String name;
    private int id;
    private int count;

    Contestant(){
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


class ContestantChainedComparator implements Comparator<Contestant>{
    private List<Comparator<Contestant>> list;

    @SafeVarargs
    public ContestantChainedComparator(Comparator<Contestant>... comparators) {
        this.list = Arrays.asList(comparators);
    }

    @Override
    public int compare(Contestant con1, Contestant con2) {
        for (Comparator<Contestant> comparator : list) {
            int result = comparator.compare(con1, con2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}


class ContestantNameComparator implements Comparator<Contestant> {

    @Override
    public int compare(Contestant o1, Contestant o2) {
        return o1.getName().compareTo(o2.getName());
    }
}


class ContestantIdComparator implements Comparator<Contestant> {
    @Override
    public int compare(Contestant o1, Contestant o2) {
        return o1.getId() - o2.getId();
    }
}

class ContestantCountComparator implements Comparator<Contestant> {
    @Override
    public int compare(Contestant o1, Contestant o2) {
        return o2.getCount() - o1.getCount();
    }
}



class TestClass {

    public static void main(String args[] ) throws Exception {


        HashMap <String,Integer>count = new HashMap<>();
        HashMap <String, Integer> idValues = new HashMap<>();
        HashSet<String> hString = new HashSet<>();  //for storing unique keys
        List<Contestant> uniqueObjects = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        while(n--> 0){// Reading input from STDIN

            String line = br.readLine();
            String []tokens = line.split(" ");

            if(hString.add(tokens[0])){
                count.put(tokens[0],1);
                idValues.put(tokens[0], Integer.valueOf(tokens[1]));
            }else{
                int val = count.get(tokens[0]);
                count.put(tokens[0],val+1);

                int curr_val = idValues.get(tokens[0]);
                int sum = curr_val + Integer.valueOf(tokens[1]);
                idValues.put(tokens[0], sum);
            }

        }// Writing output to STDOUT



        //O(n^2) :
        Iterator iterator = hString.iterator();
        while(iterator.hasNext()){
            String name = (String) iterator.next();
            Contestant con = new Contestant();
            con.setCount(count.get(name));
            con.setId(idValues.get(name));
            con.setName(name);
            uniqueObjects.add(con);
        }



        Collections.sort(uniqueObjects, new ContestantChainedComparator(
                new ContestantCountComparator(),
                new ContestantIdComparator(),
                new ContestantNameComparator()));


        int i=0;
        for(;i<uniqueObjects.size(); i++){
            String name = uniqueObjects.get(i).getName();
            System.out.println(i+1 + " " + name);
        }

    }


}
