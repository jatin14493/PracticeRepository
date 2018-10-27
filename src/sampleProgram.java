import java.util.ArrayList;
import java.util.List;

//Write a function sum, which could accept a List of an Integer, Double, Long or Float and return its sum
public class sampleProgram {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            list.add(i);
        }

        Double sum = doSomething(list,5);
        System.out.println(sum);


        List<Long> list1 = new ArrayList<>();
        for(int i=0; i<5; i++){
            list1.add(2L);
        }

        Double sum1 = doSomething(list1,5);
        System.out.println(sum1);


        List<Float> list2 = new ArrayList<>();
        for(int i=0; i<5; i++){
            list2.add(0.1f);
        }

        Double sum3 = doSomething(list2,5);
        System.out.println(sum3);
    }

    private static Double doSomething(List<? extends Number> list, int size) {
        double sum = 0;


        for(int i=0; i<size; i++){

            double number = list.get(i).doubleValue();
            sum+= number;
        }
        return  sum;
    }
}
