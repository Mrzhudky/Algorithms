package com.company;

import java.util.*;



public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String[] split = str.split(" ");
            LinkedHashSet<Integer> set = new LinkedHashSet<>(N);
            for (int j = 0; j < N; j++) {
                int temp = Integer.valueOf(split[N-1-j]);
                set.add(temp);
            }
            Iterator<Integer> iter = set.iterator();
            System.out.print(iter.next());
            while(iter.hasNext()) {
                System.out.print(" " + iter.next());
            }
            System.out.println();
        }

    }

}
