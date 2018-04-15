package com.company;


/**
 * 题目：
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

class Solution {
    //一种奇妙的方法：不一样的数相抵消，即使最后差的情况，超过半数的数和所有其他数相抵消，剩下的也是超过半数的数
    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int num = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            } else {
                times--;
            }
            if (times == 0) {
                times = 1;
                num = array[i];
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) times++;
        }

        if (times * 2 > array.length) {
            return num;
        } else {
            return 0;
        }
    }

    //剑指office的方法，利用快排的思想进行切分，当切分的点刚好为中点时，认为该位置上的数为目标数
//    public int MoreThanHalfNum_Solution(int [] array) {
//        if(array == null  || array.length == 0){
//            return 0;
//        }
//        int middle = array.length/2;
//        int left =0;
//        int right = array.length-1;
//        int index = partition(array,left,right);
//        while(index != middle){
//            if(index > middle){
//                right = index-1;
//                index = partition(array,left,right);
//            }else{
//                left = index+1;
//                index = partition(array,left,right);
//            }
//        }
//        int times = 0;
//        for (int i = 0; i <= right; i++) {
//            if(array[i] == array[middle]){
//                times++;
//            }
//        }
//        if(times > middle){
//            return array[index];
//        }else{
//            return 0;
//        }
//    }
//
//    int partition(int [] array,int lo,int hi){
//        if(lo >= hi) return 0;
//
//        int i = lo;
//        int j = hi +1;
//        int v = array[lo];
//        while (true){
//            while ( (i<=hi) && (array[++i] < v) );
//            while ( (j>=lo) && (array[--j] > v) );
//            if(i>=j)break;
//
//            int temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//
//        }
//        int temp = array[lo];
//        array[lo] = array[j];
//        array[j] = temp;
//
//        return j;
//    }
}



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        int result = solution.MoreThanHalfNum_Solution(array);
        System.out.println(result);
    }
}
