package com.company;

import java.util.*;



public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        String[] times = new String[T];
        for(int i=0;i<T;i++){
            times[i] = sc.nextLine();
        }
        for(int i=0;i<T;i++){
            int hh = Integer.valueOf(times[i].substring(0,2));
            int mm = Integer.valueOf(times[i].substring(3,5));
            int ss = Integer.valueOf(times[i].substring(6,8));
            StringBuilder sb = new StringBuilder();
            if(hh>23){
                sb.append(0);
                sb.append(times[i].substring(1,3));
            }else{
                sb.append(times[i].substring(0,3));
            }
            if(mm>59){
                sb.append(0);
                sb.append(times[i].substring(4,6));
            }else{
                sb.append(times[i].substring(3,6));
            }
            if(ss>59){
                sb.append(0);
                sb.append(times[i].substring(7,8));
            }else{
                sb.append(times[i].substring(6,8));
            }
            System.out.println(sb.toString());
        }
    }

}
