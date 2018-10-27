package TCSIWizard;


import java.util.Scanner;

public class mininmumSumSubArray {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        Long sumNBy2 = 0L;
        int counter = 0;

        int []ar = new int[n];

        for(int i=0; i<n; i++){

            ar[i] = s.nextInt();
            if(counter< n/2){
                sumNBy2 = sumNBy2 + ar[i];
                counter++;
            }
        }

        Long min = sumNBy2;

        for(int i=0; i<n; i++){
            //use as index instead of i
            int k = (counter + i) % n;
            //System.out.println("k value:" + k);
            Long minsum = sumNBy2 - ar[i] + ar[k];
            if(minsum < min){
                min = minsum;
            }

            sumNBy2 = minsum;
        }

        System.out.println(min);


    }


}
