package EdgeVerve;

import java.util.Scanner;

public class HockeyStickProblem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int len = s.nextInt();
        int n = rows + len;

        int T[][] = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j =0 ; j<=i ; j++){
                if(i==j || i==0 || j==0)
                    T[i][j] =1;
                else if(j==1)
                    T[i][j] = i;
                else
                    T[i][j] = T[i-1][j] + T[i-1][j-1];
            }
        }


        for(int i=0; i<n; i++){
            for(int j =0 ; j<=i ; j++){

                System.out.print(T[i][j] + "   ");
            }
            System.out.println();
        }


        //column for hockey end
        int startCol = n-len+1;
        //starting from row above.
        int startRow = n-2;
        System.out.println("Hockey Stick For :" + T[n-1][startCol]);

        String result = T[startRow][startCol-1] + "";
        int a = T[startRow][startCol];
        while(a>=1){
            startRow = startRow-1;
            result = result + "+" + T[startRow][startCol-1];
            a = T[startRow][startCol];
        }

        System.out.println(result);
    }
}
