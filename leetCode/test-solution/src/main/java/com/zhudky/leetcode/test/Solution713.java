package com.zhudky.leetcode.test;

import java.util.concurrent.PriorityBlockingQueue;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        long prod = nums[0];
        int count = 0;
        long k2 = k;
        while(right < nums.length && left <= right) {
            if (nums[right] >= k2) {
                right++;
                left = right;
                if (left < nums.length) {
                    prod = nums[left];
                }
            } else if(prod < k2) {
                count += right - left + 1;
                right++;
                if (right < nums.length) {
                    prod *= nums[right];
                }
            } else {
                prod /= nums[left];
                left++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution713 solution713 = new Solution713();
        int[] nums = new int[]{57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int count = solution713.numSubarrayProductLessThanK(nums, 18);
        System.out.println(count);
    }
}
