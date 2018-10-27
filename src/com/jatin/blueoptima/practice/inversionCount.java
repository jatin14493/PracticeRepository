package com.jatin.blueoptima.practice;


/*Logical Explanation :

        to get number of inversions,
        we need to add number of inversions in left subarray, right subarray and merge().

        In merge process, let i is used for indexing left sub-array and j for right sub-array.
        At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions.
        because left and right subarrays are sorted,
        so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j]*/

public class inversionCount {

    public static void main(String[] args) {

        int [] ar = new int []{1, 20, 6, 4, 5};
        System.out.println("Number of inversions are " + mergeSort(ar, 5));
    }

    private static int mergeSort(int[] ar, int n) {
        int [] temp  = new int [n];
        return _mergeSort(ar, temp , 0 , n-1);
    }

    private static int _mergeSort(int[] ar, int[] temp, int left, int right) {
        int mid = 0;
        int inversionCount = 0;

        if(left < right){
            mid = left + (right - left)/2;
            inversionCount = _mergeSort(ar,temp,left,mid);
            inversionCount += _mergeSort(ar, temp,mid+1,right);
            inversionCount += merge(ar,temp,left,mid+1,right);
        }

        return inversionCount;

    }

    private static int merge(int[] ar, int[] temp, int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;

        i = left;
        j = mid;
        k = left;

        while((i<=(mid-1)) && j<=right ){
            if(ar[i] <= ar[j]){
                temp[k++] = ar[i++];
            }else{
                temp[k++] = ar[j++];

                inv_count = inv_count + (mid-i);
            }
        }

        while(i<=mid-1){
            temp[k++] = ar[i++];
        }

        while (j <= right) {
            temp[k++] = ar[j++];
        }

        for (i=left; i <= right; i++)
            ar[i] = temp[i];

        return inv_count;
    }
}
