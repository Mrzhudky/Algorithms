package com.zhudky.leetcode.test;

import java.util.PriorityQueue;

public class Solution1005 {
    /**
     * @param nums 1 <= nums.length <= 10^4, -100 <= nums[i] <= 100
     * @param k    1 <= k <= 10^4
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length);
        for(int num: nums) {
            minHeap.add(num);
        }
        for (int i = 0; i < k; i++) {
            int minNum = minHeap.poll();
            minHeap.add(-1 * minNum);
        }
        int total = 0;
        while (!minHeap.isEmpty()) {
            total += minHeap.poll();
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,-3,-1,5,-4};
        int k = 2;
        int total = largestSumAfterKNegations(nums, k);
        System.out.println("结果=" + total + ", 正确性：" + (total == 13));
    }

    /**
     * 示例 1：
     *
     * 输入：nums = [4,2,3], k = 1
     * 输出：5
     * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
     * 示例 2：
     *
     * 输入：nums = [3,-1,0,2], k = 3
     * 输出：6
     * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
     * 示例 3：
     *
     * 输入：nums = [2,-3,-1,5,-4], k = 2
     * 输出：13
     * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
