package com.company;

import java.util.*;


/**
 *  爬楼梯
假设你正在爬楼梯。需要 n 步你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 步 + 1 步
2.  2 步
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 步 + 1 步 + 1 步
2.  1 步 + 2 步
3.  2 步 + 1 步
 *
 * 思路：
 * F(n) = F(n-1) + F(n-2) ,转变为求斐波那契数列问题
 */

public class Main {

    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        if(n<=3){
            return n;
        }
        int num1 = 1;
        int num2 = 2;
        while(n>4){
            int temp = num2 + num1;
            num1 = num2;
            num2 = temp;
            n--;
        }
        return 2*num2 + num1;
    }
	
	
    public static void main(String[] args) {


    }


}
