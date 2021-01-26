package com.zhudky.leetcode.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create in 2021/1/26 11:22 下午
 */
public class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int totalNum = 0;
        for(int[] domino : dominoes) {
            int index = domino[0] > domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            totalNum += count[index];
            count[index] += 1;
        }
        return totalNum;
    }
}
