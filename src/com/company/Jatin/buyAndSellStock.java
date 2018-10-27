package com.company.Jatin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Interval
{
    int buy, sell;
}

class buyAndSellStock {
    
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int []ar  = new int[n];
        for(int i = 0; i<n;i++){
            ar[i] = s.nextInt();
        }

        buyAndSellStock s1 = new buyAndSellStock();
        s1.computeBuyAndSell(ar,n);

    }

    private void computeBuyAndSell(int[] ar, int n) {
        List<Interval> list = new ArrayList<Interval>();
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();

        // Traverse through given price array
        int i = 0;
        while (i < n - 1)
        {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (ar[i + 1] <= ar[i]))
                i++;

            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;

            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima


            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (ar[i] >= ar[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i-1;
            sol.add(e);

            // Increment number of buy/sell
            count++;
        }

        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);

        return;

    }
}
