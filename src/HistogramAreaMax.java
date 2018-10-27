import java.util.Scanner;
import java.util.Stack;

public class HistogramAreaMax {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n];
        for(int i=0; i<n; i++){
            ar[i] = s.nextInt();
        }

        int val = maxArea(ar,n);
        System.out.println("Max Area :" + val);
    }

    private static int maxArea(int[] ar, int n) {
        int maxArea = 0;
        int areaWithTop;
        int top; // For top of stack
        Stack<Integer> s = new Stack<>();

        int i=0;
        while(i<n){

            if(s.empty() || ar[s.peek()] <= ar[i]){
                s.push(i++);
            }else{
                 top= s.peek();
                 s.pop();
                System.out.println("value at top :" + top);
                areaWithTop = ar[top] * (s.empty()? i : i-s.peek()-1);

                System.out.println("areaWithTop in " + i + "th iteration : "+ areaWithTop );

                if(maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while(s.empty()==false){

            top = s.peek();
            s.pop();
            System.out.println("value at top :" + top);
            areaWithTop = ar[top] * (s.empty()? i : i-s.peek()-1);

            if(maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
        }


}
