package com.company;


import java.util.Arrays;

/***
 * 题目：
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */

public class Main {

    public int Add(int num1,int num2) {
        if(num1 == 0 ){
            return num2;
        }
        if(num2 == 0){
            return num1;
        }

        int num = num1 ^ num2;
        int c = num1 & num2;

        return Add(num,c<<1);

    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.Add(10,12));

    }
}
