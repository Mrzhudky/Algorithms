package com.zhudky;
import java.util.*;

/**
 *全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
 
 class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =new  ArrayList<>();
        if(nums == null){
            return list;
        }
        help(list,nums,0);
        return list;
    }
    
    private void help(List<List<Integer>> list,int[] nums,int i){
        if(i == nums.length){
            List<Integer> tempList = new ArrayList<Integer>(nums.length);
            for(int j=0;j<nums.length;j++){
                tempList.add(nums[j]);
            }
            list.add(tempList);
            return;
        }
        for(int j=i;j<nums.length;j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            help(list,nums,i+1);
            nums[j] = nums[i];
            nums[i] = temp;            
        }
    }
}

    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        int re = 0;
        
        boolean[][] reached = new boolean[M][N];
        for (int i = 0; i < M; i++) {            
            for (int j = 0; j < N; j++) {
                if(!reached[i][j] && grid[i][j] == '1'){
                    dps(grid,reached,i,j);
                    re++;
                }
            }
        }
        return re;
    }
    
    private void dps(char[][] grid,boolean[][] reached,int i,int j){
        int M = grid.length;
        int N = grid[0].length;
        
        if(i<0 || i>=M || j<0 || j>=N){
            return;
        }
        if(grid[i][j] == '1' && !reached[i][j]){
            reached[i][j] = true;
            dps(grid,reached,i-1,j);
            dps(grid,reached,i+1,j);
            dps(grid,reached,i,j-1);
            dps(grid,reached,i,j+1);
        }
    }
}