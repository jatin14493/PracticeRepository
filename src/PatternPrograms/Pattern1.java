package PatternPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pattern1 {

    public static void main(String[] args) {

        int n;
        String ans = PrintPattern(1, n=7);
        System.out.println(ans);
    }

    private static String PrintPattern(int val, int n) {
        String str = val + "";
        String answer ="";
        for(int i = 0; i<n-1 ; i++){
        LinkedHashMap <Character,Integer>hs = new LinkedHashMap<>();
        for(int j=0; j<str.length(); j++){
            if(!hs.containsKey(str.charAt(j))){
                hs.put(str.charAt(j), 1);
            }else{
                int value = hs.get(str.charAt(j));
                value+= 1;
                hs.put(str.charAt(j),value);
            }
        }

        String finalA ="";
            for(Map.Entry<Character,Integer> h : hs.entrySet()){
                //System.out.print( "h.getValue :" + h.getValue() + " h.getKey()" + h.getKey());
                answer += h.getValue() + "" +  h.getKey();
            }
            System.out.println(answer);
            str = answer;
            answer ="";
            //System.out.println(str);
            hs = null;
        }

        return str;
    }
}
