package com.company;


import java.util.Arrays;

/***
 * 题目：
 * 0到n-1这n个数字排成一个圆圈，从0开始数每次从这个圈中删除第m个数，
 * 然后从第m+1个数开始再次从0到m计数并删除第m个数，直至只剩下一个数，
 * 求这个数。
 */

public class Main {

    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.LastRemaining_Solution(10,5));

    }
}
