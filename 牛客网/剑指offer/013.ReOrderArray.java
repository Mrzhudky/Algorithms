package com.company;

/**
 *题目：
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */

class Solution {
    public void reOrderArray(int [] array) {
        int pOddNum = 0; //奇数
        int pEvenNum = 0;//偶数
        int len = array.length;
        while (pOddNum < len) {
            while((pOddNum<len) && 0 == (array[pOddNum] & 0x1)) pOddNum++;
            while((pEvenNum<len) && 1 == (array[pEvenNum] & 0x1) ) pEvenNum++;


            if((pOddNum<len) &&( pOddNum > pEvenNum)){
                int temp = array[pOddNum];
                for (int i = pOddNum; i > pEvenNum ; i--) {
                    array[i] = array[i-1];
                }
                array[pEvenNum] = temp;
            }
            pOddNum++;
        }
    }
}


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputData = new int[]{1,3,5,7,2,4,6};
        solution.reOrderArray(inputData);
        for (int data :inputData
             ) {
            System.out.print(data);
        }

    }
}
