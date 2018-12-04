import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Planet{

    String planet1;
    String planet2;

    public Planet(String planet1, String planet2){
        this.planet1 = planet1;
        this.planet2 = planet2;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Planet) {
            Planet pp = (Planet) obj;
            return (pp.planet1.equals(this.planet1) && pp.planet2.equals(this.planet2));
        } else {
            return false;
        }

    }
    @Override
    public int hashCode() {
        int result =0;
        result = 31 * result + (planet1 != null ? planet1.hashCode() : 0);
        result = 31 * result + (planet2 != null ? planet2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return "Planet1 :" + this.planet1 + " - " + "Planet2 :" + this.planet2;
    }

}

public class exotel {

    static HashMap<String, Integer> lookUp = new HashMap<>();

    static {
        lookUp.put("Mercury" , 0);
        lookUp.put("Venus" , 1);
        lookUp.put("Earth" , 2);
        lookUp.put("Mars" , 3);
        lookUp.put("Jupiter" , 4);
        lookUp.put("Saturn" , 5);
        lookUp.put("Uranus" , 6);
        lookUp.put("Neptune" , 7);
        lookUp.put("Pluto" , 8);
    }

    static HashMap<Integer, String> revlookUp = new HashMap<>();

    static {
        revlookUp.put(0,"Mercury");
        revlookUp.put(1,"Venus");
        revlookUp.put(2,"Earth");
        revlookUp.put(3,"Mars");
        revlookUp.put(4,"Jupiter");
        revlookUp.put(5,"Saturn");
        revlookUp.put(6,"Uranus");
        revlookUp.put(7,"Neptune");
        revlookUp.put(8,"Pluto");
    }



    public static void main(String[] args) {
        String csvFile = "/Users/B0205328/Desktop/planet.csv";
        BufferedReader br = null;
        String line = "";

        // Hashmap having distances
        HashMap<Planet, Integer> hashMap = new HashMap<>();

        try {


            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] Planets = line.split(",");
                String p1 = Planets[0].trim();
                System.out.println(p1);
                String p2 =Planets[1].trim();
                hashMap.put(new Planet(p1,p2),Integer.parseInt(Planets[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        hashMap.entrySet().forEach(t -> {
//            System.out.print("key :" + t.getKey() + " -> " + "value :" + t.getValue());
//            System.out.println();
//        });


        Scanner s = new Scanner(System.in);

        // T is the number of test case here
        int t = s.nextInt();

        while(t-- > 0){
            String fromPlanet = s.next();
            String toPlanet = s.next();

            int distance = computeDistance(fromPlanet,toPlanet,hashMap);
            System.out.println(distance);
        }

    }

    private static int computeDistance(String fromPlanet, String toPlanet, HashMap<Planet,Integer> hashMap) {
        int answer = 0;

        int startingOffset = lookUp.get(fromPlanet);
        int endingOffset = lookUp.get(toPlanet);

        //Reverse like from  Pluto to Mercury
        if(startingOffset > endingOffset){
            startingOffset = startingOffset + endingOffset;
            endingOffset = startingOffset - endingOffset;
            startingOffset = startingOffset-endingOffset;
        }

        //Base Case
        if(endingOffset - startingOffset == 1){
            Planet p = new Planet(fromPlanet,toPlanet);
           return hashMap.get(p);
        }

        for(int i=startingOffset; i<endingOffset; i++){
            String planet1 = revlookUp.get(i);
            String planet2 = revlookUp.get(i+1);
            Planet p = new Planet(planet1,planet2);
            int val = hashMap.get(p);
            answer = answer + val;
        }


        return answer;
    }

}
