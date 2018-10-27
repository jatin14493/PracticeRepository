package TCSIWizard;

import java.util.HashSet;
import java.util.Scanner;

public class countVowel {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        HashSet<Character> hs = new HashSet<>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');

        int consonantsCount = 0;
        int vowelCount =0 ;
        Long answer = 0L;
        for(int i=0; i<s.length(); i++) {

            Character c = s.charAt(i);
            if (hs.contains(c)) {
                vowelCount++;
            } else {
                consonantsCount++;
            }
        }

            if(vowelCount == s.length())
                System.out.println(vowelCount);
            else{
                answer  =  computeAnswer(vowelCount, consonantsCount);
                System.out.println(answer);
            }

    }

    private static Long computeAnswer(int vowelCount, int consonantsCount) {
        Long val =1L;
        int mod = 1000000007;
        val = val * vowelCount;
        int startVal =2;

        while(consonantsCount-- > 0){
            val = (val%mod * 2)%mod;
        }

        return val;
    }
}
