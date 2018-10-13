package com.zhudky;

import java.util.*;

/*

给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。


示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
8 |     |              |
7 |     |--------------|-----|
6 |     |--|-----------|-----|
5 |     |--|-----|-----|-----|
4 |     |--|-----|--|--|-----|
3 |     |--|-----|--|--|-----|
2 |     |--|-----|--|--|--|--|
1 |     |--|--|--|--|--|--|--|
0 |__|__|__|__|__|__|__|__|__|__\
     1  8  6  2  5  4  8  3  7  /
图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。



说明：你不能倾斜容器，且 n 的值至少为 2。
*/
class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int temp = Math.min(height[left],height[right])*(right - left);
            maxArea = Math.max(maxArea,temp);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}