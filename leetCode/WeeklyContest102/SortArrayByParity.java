package com.zhudky;
import java.util.*;

/**
 *
905. 按奇偶校验排序数组
给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 

示例：

输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 

提示：

1 <= A.length <= 5000
0 <= A[i] <= 5000
 */
 
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length==0){
            return A;
        }
        int left = 0;
        int right = A.length-1;
        while(left<right){
            while(left<A.length && A[left]%2==0){
                left++;
            }
            while(right>=0 && A[right]%2!=0){
                right--;
            }
            if(left<right){
                int temp = A[left];
                A[left] =A[right];
                A[right] = temp;
            }
        }
        return A;
    }
}
 