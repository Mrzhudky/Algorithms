package com.company;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目：
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个字数组。求所有数组的和的最大值
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 */

class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length ==0){
            return 0;
        }
        int curSum = 0;
        int maxSum = 0x80000000;//考虑到最大值为负值的情况
        for (int i = 0; i < array.length; i++) {
            if(curSum < 0){
                curSum = array[i];
            }else{
                curSum += array[i];
            }
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return  maxSum;
    }


}



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{6,-3,-2,7,-15,1,2,2};
        int result = solution.FindGreatestSumOfSubArray(array);
        System.out.println(result);
    }
}
