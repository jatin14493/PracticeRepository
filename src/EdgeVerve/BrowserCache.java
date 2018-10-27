package EdgeVerve;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class BrowserCache {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int cSize = s.nextInt();
        String inputString = s.next();

        // ABC!DEAFBE!AB!
        // EIOIO!


        HashSet hashSet = new HashSet();

        LinkedList <Character>list = new LinkedList<>();
        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) != '!'){
                if(hashSet.size()<cSize){
                    if(hashSet.add(inputString.charAt(i))){
                        list.add(inputString.charAt(i));
                    }else{
                        //do nothing as element is already in the list.
                    }

                }else{
                    if(list.contains(inputString.charAt(i))){
                        //Do nothing
                    }else{
                        char removed = list.removeFirst();
                        //System.out.println("element removed from cache :" + removed);
                        hashSet.remove(removed);
                        hashSet.add(inputString.charAt(i));
                        list.add(inputString.charAt(i));
                    }
                }
            }else{
                list.forEach(str -> System.out.print(str));
                System.out.print(" ");
            }
        }
    }
}
