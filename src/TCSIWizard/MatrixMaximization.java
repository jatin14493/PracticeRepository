package TCSIWizard;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MatrixMaximization {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        long [][]ar = new long[n][m];

        PriorityQueue<Long> row = new PriorityQueue<>();  //for rows
        PriorityQueue<Long> column = new PriorityQueue<>(); //for columns

        for(int i=0; i<n; i++){
            long rowSum = 0L;
            for(int j= 0 ; j<m; j++){
                ar[i][j] = s.nextInt();
                rowSum += ar[i][j];
            }
            row.add(rowSum);
        }



        for(int i=0; i<m; i++){

            long colSum = 0L;

            for(int j=0; j<n; j++){
                colSum = colSum + ar[j][i];
            }

            column.add(colSum);

        }

        long rowSum = row.stream().mapToLong(a->a).sum();
        long colSum = column.stream().mapToLong(a->a).sum();
        long rowSumExcluding = rowSum - row.poll();
        long columnSumExcluding = colSum - column.poll();

        long maxRowSum = (rowSum>rowSumExcluding)?rowSum:rowSumExcluding;
        long maxColSum = (colSum > columnSumExcluding)?colSum:columnSumExcluding;

        long answer = maxColSum>maxRowSum?maxColSum:maxRowSum;
        System.out.println(answer);


    }
}
