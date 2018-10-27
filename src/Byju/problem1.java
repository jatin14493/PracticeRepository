package Byju;

import java.util.Scanner;

public class problem1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long []ar = new long[n];
        long []tr = new long[n];

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
            tr[i] = ar[i];
        }

        int q = s.nextInt();

        // Array sorted in ascending order
        //Arrays.sort(ar);

        sortArray(ar, 0, n-1);  //O(nlogn) : Avg Case



        int val = n;
        long []cumilative = new long[n];
        long prev =0;

        for(int i= 0; i<n ; i++){

            tr[i] = ar[i];

            //storing previous value
            prev = ar[i];

            if(i==0)
                cumilative[i] = prev;
            else
                cumilative[i] = cumilative[i-1] + tr[i];

            //update the value
            if(i==0)
                ar[i] = (val * tr[i]);
            else
            ar[i] = (val * tr[i]) + cumilative[i-1];

            //decrement val
            val--;

        }




        while(q-- > 0){

            long k = s.nextLong();

            if(k<n){
                System.out.println("1");
                continue;
            }

            if(k > ar[n-1]){
                System.out.println("-1");
                continue;
            }

            long answer = -1l;

            int index;
            for(index=0; index < n ;){
                if(ar[index] > k)
                    break;
                else if(ar[index] == k){
                    answer = tr[index];
                    break;
                }
                index++;
            }


            long diff = 0l;

            if(index!=0)
                diff = (int) (tr[index] - tr[index-1]);
            else
                diff = (int)(tr[index]);

            int i=1;

            while((diff-- > 0) || answer ==-1){

                long currVal  = ar[index];
                long check = (tr[index] -i);
                long multiplyFactor = (n+1 - index);
                long chkVal = multiplyFactor *i;
                currVal = currVal -chkVal;
                if(currVal >= k)
                    answer = check;
                else
                    break;
                i++;

            }


            if(index >= n)
                System.out.println("-1");
            else if(answer!=-1)
                System.out.println(answer);
            else {
                System.out.println(tr[index]);
            }

        }
    }

    private static void sortArray(long[] ar, int start, int end) {
        if(start<end){
            int pi  = partition(ar,start,end);
            sortArray(ar,start,pi-1);
            sortArray(ar,pi+1,end);
        }
    }

    private static int partition(long[] ar, int low, int high){
        long pivot = ar[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (ar[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                long temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        long temp = ar[i+1];
        ar[i+1] = ar[high];
        ar[high] = temp;

        return i+1;
    }

}






//Submitted Solution



/*

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long []ar = new long[n];
        long []tr = new long[n];

        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
            tr[i] = ar[i];
        }

        int q = s.nextInt();

        // Array sorted in ascending order
        Arrays.sort(ar);

        //sortArray(ar, 0, n-1);  //O(nlogn) : Avg Case



        int val = n;
        long []cumilative = new long[n];
        long prev =0;

        for(int i=0; i<n ; i++){

            tr[i] = ar[i];

            //storing previous value
            prev = ar[i];

            if(i==0)
                cumilative[i] = prev;
            else
                cumilative[i] = cumilative[i-1] + tr[i];

            //update the value
            if(i==0)
                ar[i] = (val * tr[i]);
            else
                ar[i] = (val * tr[i]) + cumilative[i-1];

            //decrement val
            val--;

        }

        //Answering the Queries
        while(q-- > 0){

            //input
            long k = s.nextLong();
            long answer = -1l;

            if(k<n){
                System.out.println("1");
                continue;
            }

            if(k > ar[n-1]){
                System.out.println("-1");
                continue;
            }

            if(k == ar[n-1]){
                System.out.println(tr[n-1]);
                continue;
            }



            int index;
            for(index=0; index < n ;){
                if(ar[index] > k)
                    break;
                else if(ar[index] == k){
                    answer = tr[index];
                    break;
                }
                index++;
            }


            long diff = 0l;

            if(index!=0)
                diff = tr[index] - tr[index-1];
            else
                diff = tr[index];

            int i=1;
            while((diff-- > 0) || answer ==-1){

                long currVal  = ar[index];
                long check = (tr[index] -i);
                long multiplyFactor = (n - index) + 1;
                long chkVal = multiplyFactor * i;
                currVal = currVal -chkVal;

                if(currVal > k)
                    answer = check;
                else if(currVal == k){
                    answer = check;
                    break;
                }
                else
                    break;

                i++;
            }


            if(index > n)
                System.out.println("-1");
            else if(answer!=-1)
                System.out.println(answer);
            else {
                System.out.println(tr[index]);
            }

        }
    }

    private static void sortArray(long[] ar, int start, int end) {
        if(start<end){
            int pi  = partition(ar,start,end);
            sortArray(ar,start,pi-1);
            sortArray(ar,pi+1,end);
        }
    }

    private static int partition(long[] ar, int low, int high){
        long pivot = ar[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (ar[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                long temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        long temp = ar[i+1];
        ar[i+1] = ar[high];
        ar[high] = temp;

        return i+1;
    }

*/
