package Barclays;


/*Eating Chocolate
        There is a chocolate bar of length  meters. Two friends Alice and Bob decided to play a game of eating the chocolate.
        Alice eats from the left side of the bar and Bob from the right side. In  move each person eats  amount of chocolate from their end.
        A person loses if he is unable to eat chocolate in his move i.e if the remaining chocolate piece is less than the amount  in that particular step.
        You need to decide the winner of the game.

        Input
        First line contains an integer  that denotes total number of test cases.
        Each testcase contains an integer  as input denoting the length of chocolate bar for that test case.

        Output
        If in a test case, Alice wins then print "A" or else print "B" in a new line.

        Input Constraints

        Sample Input
        2
        5
        6
        Sample Output
        B
        A
        Explanation
        In the first test case N = 5 so Alice eats 1 meter of chocolate and remaining chocolate length is 4. Bob eats 2 length of chocolate and remaining length is 2.
        Now Alice can't eat chocolate of size 3 in her turn so winner is Bob and hence output is B.*/

import java.util.Scanner;

public class EatingChocolate {

    public static void main(String[] args) {



        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        while(T-- > 0){
            long num = s.nextLong();
            long turn = 0;
            long rem = 2 * num;

            Double val = Math.sqrt(rem);
            //Double val1 = rem/val;
            long chk  = val.longValue();
            long chkProduct = chk*(chk+1);

            if(chkProduct > rem){
                turn = chk-1;
            }else{
                turn = chk;
            }




            if(turn%2 == 0)
                System.out.println("B");
            else
                System.out.println("A");
        }

    }
}
