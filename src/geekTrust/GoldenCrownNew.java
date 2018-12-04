package geekTrust;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GoldenCrownNew {

    private static HashMap<String, String> hashMap;

    static {
        hashMap = new HashMap<>();
        hashMap.put("LAND","panda");
        hashMap.put("WATER","octopus");
        hashMap.put("SPACE","gorilla");
        hashMap.put("ICE","mammoth");
        hashMap.put("AIR","owl");
        hashMap.put("FIRE","dragon");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int t = 0;

        try{
             t = Integer.parseInt(reader.readLine());
        }catch (Exception ex){
            System.out.println("Exception occured!");
        }

        while(t-->0){

        }
    }

}
