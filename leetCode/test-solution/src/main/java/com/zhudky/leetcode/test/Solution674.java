package com.zhudky.leetcode.test;

import java.util.Arrays;

/**
 * Create in 2021/1/24 5:02 下午
 */
public class Solution674 {
    public static int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        if (nums == null || nums.length <= 0) {
            return maxLen;
        }
        int lastNum = nums[0];
        int lastLen = 0;
        for(int num : nums) {
            int preDiff = num - lastNum;
            if (preDiff > 0 ) {
                lastLen += 1;
            } else {
                lastLen = 1;
            }
            lastNum = num;
            maxLen = Math.max(maxLen, lastLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        int[] nums2 = new int[]{1,3,5,8};
        System.out.println(Arrays.toString(nums2));
        System.out.println(findLengthOfLCIS(nums2));
    }
}
