package com.zhudky;
import java.util.*;

/**
 *  三数之和
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

public class Solution {
    // you need to treat n as an unsigned value
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }

        Arrays.sort(nums);
        for(int i=0;i<nums.length-2 && nums[i]<1;i++){
            int size = list.size();
            if(size>0 && nums[i-1] ==  nums[i]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while (start<end){
                int temp = nums[start]+nums[end]+nums[i];
                if(temp>0){
                    end--;
                }else if(temp == 0){                   
                    
                    ArrayList<Integer> line = new ArrayList<>();
                    line.add(nums[i]);
                    line.add(nums[start]);
                    line.add(nums[end]);
                    list.add(line);
                    while((start<end) && (nums[start]==nums[start+1]) ) start++;
                    while((start<end) && (nums[end]==nums[end-1]) ) end--;
                    
                    start++;end--;
                }else{
                    start++;
                }
            }
        }
        return list;
    }
}