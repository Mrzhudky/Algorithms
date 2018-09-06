package com.zhudky;
import java.util.*;

/**
前K个高频元素
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

 */
 class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freMap.put(nums[i],freMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Set<Map.Entry<Integer, Integer>> set = freMap.entrySet();
        for(Map.Entry<Integer, Integer> entry : set){
            heap.offer(entry);
            if(heap.size()>k){
                heap.poll();
            }
        }

        List<Integer> re = new ArrayList<>(k);
        for(Map.Entry<Integer, Integer> entry : heap){
            re.add(entry.getKey());
        }

        return re;
    }
}