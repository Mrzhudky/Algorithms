package com.company;

import java.util.TreeMap;


/***
 * 题目：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */

public class Main {

    public int[] multiply(int[] A) {

        if(A == null || A.length < 2){
            return null;
        }
        int [] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        for (int i = A.length-1; i >=0 ; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        return B;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        int[] A = new int[]{1,2,3,4,2,5};
        int[] B = m.multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }


    }
}
