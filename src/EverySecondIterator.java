import com.Amazon.ListProblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EverySecondIterator<T> implements Iterator<T> {
    int size;
    int currentPointer = 0;
    List<T> iterator;

    public EverySecondIterator(List<T> target) {
        this.iterator =target;
        this.size = target.size();
    }

    @Override

    public boolean hasNext() {
        return (currentPointer<size);
    }

    @Override

    public T next() {

        if(!hasNext())
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }


            T val = (T) iterator.get(currentPointer);
        currentPointer += 2;
        return val;

    }

    @Override

    public void remove() {

//You can ignore this method

        throw new RuntimeException("Not implemented");

    }


    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        EverySecondIterator<Integer> everySecondIterator = new EverySecondIterator<>(arrayList);

        while(everySecondIterator.hasNext()){
            System.out.println(everySecondIterator.next());
        }

    }

}