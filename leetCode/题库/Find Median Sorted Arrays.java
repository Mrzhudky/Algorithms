package com.zhudky;

import java.util.*;

/*
4、两个排序数组的中位数

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。

请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。

你可以假设 nums1 和 nums2 不同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

中位数是 (2 + 3)/2 = 2.5
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums1 == null && nums2 == null){
            return 0.0d;
        }

        int N = nums1.length + nums2.length + 1;
        int midLeft = N/2;
        int midRight = midLeft + N%2;
        if(nums1== null ||  nums1.length == 0){
            double re = (nums2[midLeft-1] + nums2[midRight-1])/2.0;
            return re;
        }
        if(nums2 == null || nums2.length == 0){
            double re = (nums1[midLeft-1] + nums1[midRight-1])/2.0;
            return re;
        }

        int p1 = 0;
        int p2 = 0;
        int curNum = Math.min(nums1[0],nums2[0]);
        int mid = nums1[0];
        for (int i = 0; i < midRight; i++) {
            if(p1<nums1.length && p2< nums2.length){
                if(nums1[p1]<nums2[p2]){
                    curNum = nums1[p1++];
                }else{
                    curNum = nums2[p2++];
                }
            }else if(p1<nums1.length){
                curNum = nums1[p1++];
            }else{
                curNum = nums2[p2++];
            }

            if(i == (midLeft-1)){
                mid = curNum;
            }
        }
        double re = (mid + curNum)/2.0d;
        return  re;
    }
}