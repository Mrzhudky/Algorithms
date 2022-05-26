package com.zhudky.leetcode.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution689 {

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[]{0, 0, 0};
        int[] maxSum = new int[]{0, 0, 0};
        int[] sum = new int[]{0, 0, 0};
        int[] tempIndex = new int[]{0, 0, 0};
        int firstIndex = 0;
        int maxLen = nums.length - 2 * k;
        for (int i = 0; i < maxLen; i++) {
            sum[0] += nums[i];
            sum[1] += nums[i + k];
            sum[2] += nums[i + 2 * k];
            if (i < k - 1) {
                continue;
            }
            // 第一个窗口
            if (sum[0] > maxSum[0]) {
                maxSum[0] = sum[0];
                firstIndex = i - k + 1;
            }
            if (maxSum[0] + sum[1] > maxSum[1]) {
                maxSum[1] = maxSum[0] + sum[1];
                tempIndex[0] = firstIndex;
                tempIndex[1] = i + 1;
            }
            if (maxSum[1] + sum[2] > maxSum[2]) {
                maxSum[2] = maxSum[1] + sum[2];
                tempIndex[2] = i + k + 1;
                result[0] = tempIndex[0];
                result[1] = tempIndex[1];
                result[2] = tempIndex[2];
            }
            sum[0] -= nums[i- k + 1];
            sum[1] -= nums[i + 1];
            sum[2] -= nums[i + k + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,10,6,11,17,4,11,1,3};
        int k = 1;
        int[] r = maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.stream(r).boxed().collect(Collectors.toList()));
    }

}
