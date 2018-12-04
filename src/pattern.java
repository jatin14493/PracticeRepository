public class pattern {

    public static void main(String[] args) {

        int n = 6;
        System.out.println("Pattern1 : ");
        printTriangle(n);
        System.out.println();
        System.out.println("Pattern2 : ");
        printTriangleFromRight(n);
        System.out.println();
    }

    private static void printTriangleFromRight(int n) {
        {


            int k = 1;
            for(int i =0 ; i<n; i++){

                for(int j=n-i; j>1; j--){
                    System.out.print(" ");
                }

                for(int j=0; j<=i; j++){
                    System.out.print((k));
                }

                System.out.println();
                k++;
            }
        }
    }

    private static void printTriangle(int n) {


        int k = 1;
        for(int i =0 ; i<n; i++){

            for(int j=n-i; j>1; j--){
                System.out.print(" ");
            }

            for(int j=0; j<=i; j++){
                System.out.print((k)+ " ");
            }

            System.out.println();
            k++;
        }
    }
}
