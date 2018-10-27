package Rndom;

public class keyPress {

    public static void main(String[] args) {

        //for(int i=1; i<=20; i++){

            int k = findOptimal(7);

            System.out.println("value of k at " + 7 + "th iteration : " + k);
        //}



    }

    private static int findOptimal(int n) {

        if(n<=6)
            return n;

        int max = 0;

        for(int b = n-3; b>=1 ; b--){

            System.out.println("For b : " + b);

            int temp = (n-b-1) * findOptimal(b);

            System.out.println("For temp :" + temp);
            if(temp > max){
                max = temp;
            }

        }
        return max;
    }
}
