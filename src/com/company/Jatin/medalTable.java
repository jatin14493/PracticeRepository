package com.company.Jatin;

import java.io.IOException;
import java.util.*;


class Country{

    private int gold;
    private int silver;
    private int bronze;
    private String name;

    public Country(String name,int gold, int silver, int bronze) {
        this.name = name;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    public String getName() {
        return name;
    }



}

class CountryChainedComparator implements Comparator<Country>{
    private List<Comparator<Country>> list;

    @SafeVarargs
    public CountryChainedComparator(Comparator<Country>... comparators) {
        this.list = Arrays.asList(comparators);
    }

    @Override
    public int compare(Country con1, Country con2) {
        for (Comparator<Country> comparator : list) {
            int result = comparator.compare(con1, con2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}

class medalTable {

    public static void main(String []args) throws IOException {
        //To Do

        List<Country> list = new ArrayList<Country>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int numOfEntries = line.

        Country con1 = new Country("India" , 5,5, 3);
        Country con2 = new Country("Pakistan", 1, 3,4);
        Country con3 = new Country("China",6,3,4);
        Country con8 = new Country("Russia",2,0,1);
        Country con4 = new Country("USA", 6,4,4);
        Country con5 = new Country("Australia",5,5,3);
        Country con6 = new Country("Argentina",1,3,7);
        Country con7 = new Country("Spain",2,3,1);


        list.add(con1);
        list.add(con2);
        list.add(con3);
        list.add(con4);
        list.add(con5);
        list.add(con6);
        list.add(con7);
        list.add(con8);
//Collections.sort(list, new Comparator<Country>() {
//    @Override
//    public int compare(Country o1, Country o2) {
//        if(o2.getGold()>o1.getGold())
//        {
//            return 1;
//        }else if(o2.getGold()<o1.getGold())
//        {
//            return -1;
//        }
//        else if(o2.getSilver()>o1.getSilver())
//        {
//            return 1;
//        }else if(o2.getSilver()<o1.getSilver())
//        {
//            return -1;
//        } else if(o2.getBronze()>o1.getBronze())
//        {
//            return 1;
//        }else if(o2.getBronze()<o1.getBronze())
//        {
//            return -1;
//        }
//        return 0;
//    }
//});
       Collections.sort(list, new CountryChainedComparator(
                new CountryGoldComparator(),
                new CountrySiverComparator(),
                new CountryBronzeComparator(),
                new CountryNameComparator())
        );

        System.out.print("Country\t\tGold\t\tSilver\t\tBronze");
        System.out.println();

        for(Iterator li = list.iterator(); li.hasNext();){
            Country temp = (Country) li.next();
            printDetails(temp);
        }
    }

    private static void printDetails(Country temp) {
        System.out.println(temp.getName()+"\t \t"+temp.getGold()+"\t \t"+temp.getSilver()+"\t \t"+temp.getBronze());
    }
}
