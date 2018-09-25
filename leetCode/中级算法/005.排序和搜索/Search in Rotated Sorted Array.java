package com.zhudky;
import java.util.*;

/**
33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1


 */
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return otherSearch(nums,target,left,right);
    }
    
    private int binarySearch(int[] nums,int target,int left,int right){
        int mid = 0;
        while(left<=right){
            mid = (left + right)>>1;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        
        return -1;
    }
    
    private int otherSearch(int[] nums,int target, int left, int right){
        if(left> right){
            return -1;
        }
        int mid = (left + right)>>1;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[left] == target){
            return left;
        }
        else if(nums[right] == target){
            return right;
        }
        
        if(nums[left]<target && target < nums[mid]){
            return binarySearch(nums,target,left+1,mid-1);
        }
        else if(nums[mid]<target && target < nums[right]){
            return binarySearch(nums,target,mid+1,right-1);
        }
        else if(nums[left]<nums[mid]){
            return otherSearch(nums,target,mid+1,right-1);
        }else{
            return otherSearch(nums,target,left+1,mid-1);
        }
    }
}