package EdgeVerve;

public class binCoffRecursive {

    public static void main(String[] args) {
        int n =10;
        int r =4;

        int val = calculateFunc(n,r);
        System.out.println("value :" + val);
    }

    private static int calculateFunc(int n, int r) {
        if(n==1 || r==0 || n==r)
            return 1;

//        if(n==1 && r==1)
//            return n;

        int val = calculateFunc(n-1,r) + calculateFunc(n-1,r-1);
        return val;
    }
}
