package com.zhudky.leetcode.test;

public class Solution807 {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowLen  = grid.length;
        int columnLen = grid[0].length;
        int[] rowMax = new int[rowLen];
        int[] columnMax = new int[columnLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                int maxHigh = Math.min(rowMax[i], columnMax[j]);
                sum += maxHigh - grid[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[][] grip = { {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0} };
        int r = maxIncreaseKeepingSkyline(grip);
        System.out.println(r);
    }
}
