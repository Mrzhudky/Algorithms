package com.company;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目：
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

class Solution {

    //方法一：复杂度O(nlogk),利用容器TreeSet的有序，不改变原数组
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if(input == null || k<1 || input.length < k){
            return  result;
        }
        TreeSet<Integer> tree = new TreeSet<>();

        for (int i = 0; i < input.length; i++) {
            if(i<k){
                tree.add(input[i]);
            }
            else{
                if(tree.last() > input[i]){
                    tree.remove(tree.last());
                    tree.add(input[i]);
                }
            }
        }

        for (int n : tree) {
            result.add(n);
        }
        return result;
    }

   

}



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = solution.GetLeastNumbers_Solution(array,4);
        System.out.println(result);
    }
}
