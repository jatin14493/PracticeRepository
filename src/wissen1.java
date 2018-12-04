import java.util.*;

public class wissen1 {

    //private static HashMap<Character , Integer> hashMap = new HashMap<>();
    static int max_ref;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();

        char []ar = str.toCharArray();
        int []a = new int[n];

        char y;

        for(int i=0; i<n; i++){
            y = ar[i];
            int y1 = y -'a';
            a[i] = y1;
        }

        int q = s.nextInt();
        while(q-- >0){

            String[] st = s.nextLine().split(" ");
            if(st.length==1){
                //call method
                System.out.println(lis(a, n));

            }else{
                int val = Integer.parseInt(st[1]);
                val = val - 1;
                char digit = st[2].charAt(0);
                int v = digit - 'a';
                a[val] = v;
            }

        }

    }



    static int lis(int arr[], int n)
    {

        int lis[] = new int[n];
        int i,j,max = 0;

        /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

        /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }
}
