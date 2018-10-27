package com.Amazon;

public class powerSet {

    public static void main(String[] args) {
        char []set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }

    private static void printPowerSet(char[] set, int no) {
        int n = 1 << no;
        System.out.println(n);
        n = 1 << n;
        System.out.println(n);

        for(int j=0; j < (1 << no); j++){
            System.out.print("{");
        for (int v = 0; v < no; v++) {
            int s = 1 << v;

            int t = j&s;

            if(t>0){
                System.out.print(set[v] + " ");
            }
        }
            System.out.println("}");
    }

    }

}
