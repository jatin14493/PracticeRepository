package whatFix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class A{
    public final int getMethod(int a, int b){
        return 0;
    }
}



class Program1 {

    public static void main(String[] args) {
        String s1 = "java";
        String s2= "java";
        String s3 = "JAVA";
        s2.toUpperCase();
        s3.toUpperCase();
        boolean b1 = s1==s2;
        boolean b2 = s2==s3;
        System.out.println(b1);
        System.out.println(b2);


        Set h = new HashSet();
        h.add("One");
        h.add("Two");
        h.add("Three");
        h.add("Four");
        h.add("One");
        h.add("Four");

        List l = new ArrayList();
        l.add("One");
        l.add("Two");
        l.add("Three");
        h.retainAll(l);
        System.out.println( ""  + l.size() + h.size());


            try
            {
                badMethod();
                System.out.print("A");
            }
            catch (Exception ex)
            {
                System.out.print("B");
            }
            finally
            {
                System.out.print("C");
            }
            System.out.print("D");




    }

    public static void badMethod() {
        //throw new Error();
    }
}
