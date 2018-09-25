package com.zhudky;
import java.util.*;

/**
在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length-1;
        int mid= (left + right)/2;
        int p = -1;
        while(left<right){
            if(nums[mid]==target){
                p = mid;
                break;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
            mid= (left + right)/2;
        }
        if(nums[mid]!=target && p==-1){
            return new int[]{-1,-1};
        }
        int l = mid,r = mid;
        while(l>=0 &&nums[l]==target){
            l--;
        }
        while(r<nums.length && nums[r]==target){
            r++;
        }
        int[] re = new int[2];
        re[0] = l+1;
        re[1] = r-1;
        return re;
    }
}