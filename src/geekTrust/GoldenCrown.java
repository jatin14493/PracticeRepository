package geekTrust;

import com.sun.tools.internal.ws.wsdl.document.Output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoldenCrown {

    public static void main(String[] args) throws IOException {


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("LAND","panda");
        hashMap.put("WATER","octopus");
        hashMap.put("SPACE","gorilla");
        hashMap.put("ICE","mammoth");
        hashMap.put("AIR","owl");
        hashMap.put("FIRE","dragon");




        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = "None";   //Reference for Null
        List <String> allies= new ArrayList<>(); //For Storing List of Allies

        System.out.println("Who is the ruler of Southeros?");
        System.out.println("Output:" + result);
        System.out.println("Allies of Ruler?");
        if(allies.isEmpty()){
            System.out.println("Output:" + " None");
        }


        System.out.println("Input Messages to kingdoms from King Shan:");
        HashMap<String, String>inputHashmap = new LinkedHashMap<>();

        String line ="NONE";
        while(!line.equals("\n") || !line.equals("EOF") || line.equals("")){
            if(line.equals("\n") || line.equalsIgnoreCase("eof") || line.equalsIgnoreCase(""))
                break;
            line = reader.readLine();
            //System.out.println(line.contains("”"));
            if(line.contains("”") || line.contains("“")){
                line = line.replace("”","").trim();
                line = line.replace("“","").trim();
            }
            String []token = line.split(",");
            if(!line.equalsIgnoreCase(""))
                inputHashmap.put(token[0].trim(),token[1].trim());
        }



        Iterator <Map.Entry<String,String>> iterator = inputHashmap.entrySet().iterator();

        while(iterator.hasNext()){

            Map.Entry<String, String> str = iterator.next();
            String key = str.getKey();
            String value = str.getValue().toLowerCase().trim();
            String keySearch =key.toUpperCase();
            String valueFromStaticMap = hashMap.get(keySearch);
            Boolean flag = checkAllies(valueFromStaticMap,value);

            if(flag)
                allies.add(key);
        }


        /*

        Output Below:

        */

        String ruler ="";
        System.out.println("Who is the ruler of Southeros?");
        if(allies.size()>=3){
            System.out.println("Output:" + "King Shan");
            ruler = "King Shan";
        }else{
            System.out.println("Output:" + result);
        }

        System.out.println("Allies of " + ruler + " ?");
        if(allies.isEmpty()){
            System.out.println("Output:" + " None");
        }else{
            result = "";
            for(String l : allies){
                result += l + ", ";
            }
            result = result.substring(0,result.lastIndexOf(",")).trim();
            System.out.println("Output:" + result);
        }



    }

    private static Boolean checkAllies(String orgStr, String str) {
        char a1[] = orgStr.toCharArray();
        char a2[] = str.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        orgStr = String.valueOf(a1);
        str = String.valueOf(a2);

        int len = LongestCommonSubsequence(orgStr,str);
        if(len == orgStr.length()-1){
            return true;
        }
        return false;
    }



    private static int LongestCommonSubsequence(String orgStr, String str) {
        int ans = 0;
        if(str.contains(orgStr))
            return orgStr.length()-1;
        else{
            int [][]ar = new int [orgStr.length()+1][str.length()+1];
            for(int i =0 ; i<orgStr.length(); i++){
                for (int j=0; j<str.length(); j++){
                    if(i==0 || j==0){
                        ar[i][j] = 0;
                    }
                    else if(orgStr.charAt(i) == str.charAt(j)){
                        ar[i][j] = ar[i-1][j-1] +1;
                    }else{
                        ar[i][j] = Math.max(ar[i-1][j], ar[i][j-1]);
                    }
                }
            }
            ans = ar[orgStr.length()-1][str.length()-1];
        }
        return ans;
    }
}
