package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n)
    {
        // write your code here
        if(n<7){
            return n;
        }
        int[] uglyNumbers = new int[n+1];
        uglyNumbers[0] = 1;
        int T2=0,T3=0,T5=0;
        for(int j=1;j<n+1;j++){
            int temp = uglyNumbers[T2]*2 < uglyNumbers[T3]*3 ? uglyNumbers[T2]*2 :uglyNumbers[T3]*3;
            uglyNumbers[j] = temp < uglyNumbers[T5]*5 ? temp : uglyNumbers[T5]*5;

            if(uglyNumbers[j] == uglyNumbers[T2]*2){
                T2++;
            }
            if(uglyNumbers[j] == uglyNumbers[T3]*3){
                T3++;
            }
            if(uglyNumbers[j] == uglyNumbers[T5]*5){
                T5++;
            }
        }
        return uglyNumbers[n-1];
    }

    //private static void main()
    public static void main(String[] args)
    {

        Main test = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int targetNum = test.nthUglyNumber(n);
        System.out.println(targetNum);

        for (int i = 1; i < n+1; i++) {
            System.out.println(test.nthUglyNumber(i));
        }
    }
}