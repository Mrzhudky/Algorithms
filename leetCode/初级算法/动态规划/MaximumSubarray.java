package com.company;

import java.util.*;


/**
 *  最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 思路：
 * 1、先求出每个最大子序列的和F(n),即F(n) = max{F(n-1)+nums[n],nums[n]};
 * 2、然后比较当然和与历史最大和的大小，记录较大者，即 maxSum = max{maxSum,F(n)}
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
