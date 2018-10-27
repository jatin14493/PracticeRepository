package Skillenza;

import java.util.Scanner;

public class cars24 {



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-->0){

            int n= s.nextInt();

            Integer ar[] = new Integer[n];

            for(int i=0; i<n; i++){

                ar[i] = s.nextInt();
            }

            sortArray(ar,0,n-1);

            if(n==1)
                System.out.println(ar[0]);
            else{
                long sum = 0;
                int val = n-1;
                long startIndex = 0;
                while(val >= 0){

                    long temp = 2*startIndex + ar[val];
                    sum += temp;
                    startIndex += ar[val];
                    val--;

                }

                System.out.println(sum);
            }

        }
    }

    private static void sortArray(Integer[] ar , int low , int high) {

        if (low < high)
        {
            int pi = partition(ar, low, high);
            sortArray(ar, low, pi-1);
            sortArray(ar, pi+1, high);
        }
    }

    private static int partition(Integer[] ar, int low, int high) {

        int pivot = ar[high];
        int i = (low-1);

        for (int j=low; j<high; j++)
        {
            if (ar[j] <= pivot)
            {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        int temp = ar[i+1];
        ar[i+1] = ar[high];
        ar[high] = temp;
        return i+1;
    }
}
