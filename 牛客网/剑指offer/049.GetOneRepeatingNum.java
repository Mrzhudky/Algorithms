package com.company;

import java.util.TreeMap;


/***
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

public class Main {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length<1 || duplication == null){
            return false;
        }
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            if(treeMap.containsKey(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }
            treeMap.put(numbers[i],1);
        }
        return false;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        int[] nums = new int[]{1,2,3,4,2,5};
        int[] result = new int[1];
        System.out.println(m.duplicate(nums,nums.length,result));
        System.out.println(result[0]);

    }
}
