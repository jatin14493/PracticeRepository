package com.anzent.HiringChallenge;


/*
Highest average
        Problem Statement :

        You are given an array A of length N. You have to choose a subset S from given array A, such that average of S is less than K. You need to print the maximum possible length of S.

        Input format :

        The first line of each input contains  N, length of array A.
        Next line contains N space separated elements of array A.
        Next line of input contains an integer Q, Number of queries.
        Each following Q  lines contains a single integer K.
        Output format :

        For each query, print single integer denoting the maximum possible length of the subset.
        Constraints :



        Sample Input
        5
        1 2 3 4 5
        5
        1
        2
        3
        4
        5
        Sample Output
        0
        2
        4
        5
        5
        Explanation
        In first query, there is no possible subset such that its average is less than 1.

        In second query, you can select the subset {1,2}.

        In third query, you can select the subset {1,2,3,4}.

        In fourth and fifth query, you can seelct the complete array {1,2,3,4,5}.

        Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.
*/


import java.util.Scanner;

class highestAverage {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int []ar = new int[n];
            Double []avg1 = new Double[n];
            int m = 1000000007;

                for(int i=0; i<n; i++){
                    ar[i] = s.nextInt();
                }

            sortArray(ar, 0, n-1);  //O(nlogn) : Avg Case


            long lsum =0;
            for(int i=0;i<n;i++){
                lsum = ((lsum % m) + (ar[i] % m))%m;
                long div = i+1;
                avg1[i] = Double.valueOf(lsum/div);
            }



            int t = s.nextInt(); // number of queries
                while(t-- > 0){
                    int val = s.nextInt();
                    double v = Double.valueOf(String.valueOf(val));
                    int ans = 0;
                    if(val ==0 )
                        System.out.println("0");
                    else{
                        int count =0;
                        for(int i=0;i<n;i++){
                            int compval = Double.compare(avg1[i], v);
                            if(compval<0){
                                count ++;
                            }else{
                                break;
                            }
                        }


                        System.out.println(count);

                    }
                }
        }

        private static void sortArray(int[] ar, int start, int end) {
            if(start<end){
                int pi  = partition(ar,start,end);
                sortArray(ar,start,pi-1);
                sortArray(ar,pi+1,end);
            }
        }

        private static int partition(int[] ar, int low, int high){
            int pivot = ar[high];
            int i = (low-1); // index of smaller element
            for (int j=low; j<high; j++)
            {
                // If current element is smaller than or
                // equal to pivot
                if (ar[j] <= pivot)
                {
                    i++;

                    // swap arr[i] and arr[j]
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            int temp = ar[i+1];
            ar[i+1] = ar[high];
            ar[high] = temp;

            return i+1;
        }

}



//Alternative Logic :

 /*
                        //main logic here
                        double avg = ar[0];
                        int start = ar[0];
                        if(val < start){
                            System.out.println("0");
                        }else{
                            int count =1;
                            int loopCount = 1;
                            double sum =ar[0];
                            while(avg < val && loopCount<n){

                                 sum = sum + ar[loopCount];
                                 avg = sum /(loopCount+1);
                                         if(avg<val){
                                            loopCount = loopCount+1;
                                            count++;
                                        }else{
                                             break;
                                }
                            }
                            if(loopCount==1) {
                                count = 0;
                            }
                            ans = count;
                        }*/



    /*Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int []ar = new int[n];
    double []avg1 = new double [n];

                for(int i=0; i<n; i++){
        ar[i] = s.nextInt();
        }

        sortArray(ar, 0, n-1);  //O(nlogn) : Avg Case
        //Arrays.sort(ar);


        int lsum =0;
        for(int i=0; i<n; i++){
        lsum = lsum + ar[i];
        double temp = lsum / (i+1);
        avg1[i] = temp;
        }



        int t = s.nextInt(); // number of queries
        while(t > 0){
        int val = s.nextInt();

        double v = Double.valueOf(String.valueOf(val));
        if(val == 0 || val == 1)
        System.out.println("0");
        else{
        int count =0;
        for(int i=0;i<n;i++){
        if(avg1[i] < v){
        count ++;
        }
        }

        System.out.println(count);
        }//else ends here
        t--;
        }
        */





//    static int binarySearch(int arr[], int low,
//                            int high, int x)
//    {
//        if (high >= low)
//        {
//            int mid = low + (high - low) / 2;
//            if (x == arr[mid])
//                return mid;
//            if (x > arr[mid])
//                return binarySearch(arr, (mid + 1),
//                        high, x);
//            else
//                return binarySearch(arr, low,
//                        (mid - 1), x);
//        }
//        return -1;
//    }
//
//
//
//    int count = 0, i;
//        Arrays.sort(arr);
//        for (i = 0; i < n - 1; i++)
//        if (binarySearch(arr, i + 1, n - 1,arr[i] + k) != -1)
//        count++;
//        return count;