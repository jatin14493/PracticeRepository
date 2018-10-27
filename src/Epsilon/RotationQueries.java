package Epsilon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//1 -> anticlockwise
//2 -> clockwise
//3 -> print
public class RotationQueries {

    public static void main(String[] args) {

        Scanner s1  = new Scanner(System.in);
        int t = s1.nextInt();

        while(t--> 0){
            int n = s1.nextInt();
            int ar[] = new int[n];
            ArrayList<Integer> list = new ArrayList<>(n);
            for(int i=0; i<n; i++){
               list.add(s1.nextInt());
            }

            int q = s1.nextInt();
            while(q-- >0){
                int a = s1.nextInt();
                int b = s1.nextInt();

                if(a==1)
                    list = rotateArray(list, a, b);
                else if(a==2)
                    list = rotateArray(list, a,b);
                else {
                    System.out.println(list.get(b));
                }
            }
        }
    }

    private static ArrayList<Integer> rotateArray(ArrayList<Integer> ar, int a, int b) {
        if(a==1)
        {
            Collections.rotate(ar,-b);
        }
        else{
            Collections.rotate(ar,b);
        }
        return ar;
    }
}
