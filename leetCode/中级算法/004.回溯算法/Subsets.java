package com.zhudky;
import java.util.*;

/**
 *子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 
 */
 class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        if(nums == null){
            return list;
        }

        int len = 0;
        List<Integer> nullList = new ArrayList<>();
        list.add(nullList);
        int[] sub = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>();
                List<Integer> cur = list.get(j);
                for (int k = 0; k < cur.size(); k++) {
                    temp.add(cur.get(k));
                }
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        return list;
    }


}