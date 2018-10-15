package com.zhudky;

import java.util.*;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    private int closestSum;
    private long minDistance;

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 4){
            int re = 0;
            for (int i = 0; i < nums.length; i++) {
                re += nums[i];
            }
            return re;
        }

        long left = target - Integer.MIN_VALUE;
        long right = Integer.MAX_VALUE - target;
        closestSum = left>right ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        minDistance = left>right ? left : right;

        help(nums,target,0,0,0);
        return closestSum;

    }

    private void help(int[] nums,int target,int sum,int order,int start){
        if(start>=nums.length && order<3){
            return;
        }
        if(order >2){
            long tempDis  = Math.abs(target - sum);
            if(tempDis < minDistance){
                minDistance = tempDis;
                closestSum = sum;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            help(nums,target,sum + nums[i],order+1,i+1);
        }

    }
}