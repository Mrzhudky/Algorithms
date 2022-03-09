package com.zhudky.leetcode.test;

import java.util.Arrays;

public class Solution2055 {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        char[] sArray = s.toCharArray();
        int[] oRecord = new int[sArray.length];
        int sum = 0;
        for(int i=0; i < sArray.length; i++) {
            if (sArray[i] == '*') {
                sum += 1;
            }
            oRecord[i] = sum;
        }

        int[] lzLeft = new int[sArray.length];
        int lzNo = -1;
        for(int i=0; i < sArray.length; i++) {
            if (sArray[i] == '|') {
                lzNo = i;
            }
            lzLeft[i] = lzNo;
        }

        int[] lzRight = new int[sArray.length];
        lzNo = -1;
        for(int i=sArray.length -1 ; i >= 0; i--) {
            if (sArray[i] == '|') {
                lzNo = i;
            }
            lzRight[i] = lzNo;
        }

        int [] result = new int[queries.length];
        for(int i=0; i< queries.length; i++) {
            int leftIndex = lzRight[queries[i][0]];
            int rightIndex = lzLeft[queries[i][1]];
            if (leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
                result[i] = 0;
            } else {
                result[i] =   oRecord[rightIndex] - oRecord[leftIndex];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "**|**|***|";
        int[][] queries = new int[][]{{2,5},{5,9}};
        int[] r = platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(r));
    }
}
