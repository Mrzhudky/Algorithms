package com.company;


import java.util.Arrays;

/***
 * 题目：
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Main {

    public int Sum_Solution(int n) {
        int result = n;
        boolean ans =  (result!=0) && ((result += Sum_Solution(n-1))!=0);
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.Sum_Solution(10));

    }
}
