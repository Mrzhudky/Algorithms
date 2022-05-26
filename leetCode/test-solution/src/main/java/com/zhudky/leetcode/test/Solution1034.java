package com.zhudky.leetcode.test;

import java.util.*;

public class Solution1034 {

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int markColor = grid[row][col];
        int[][] markGrid = new int[grid.length][grid[0].length];
        markGrid[row][col] = -1;
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int count = 0;

            if (x - 1 >= 0 && grid[x-1][y] == markColor && markGrid[x-1][y] == markColor) {
                queue.offer(new int[]{x-1, y});
                count += 1;
            }
            if (x + 1 < grid.length && grid[x+1][y] == markColor) {
                queue.offer(new int[]{x+1, y});
                count += 1;
            }
            if (y-1>=0 && grid[x][y-1] == markColor) {
                queue.offer(new int[]{x, y-1});
                count += 1;
            }
            if (y + 1 < grid[0].length && grid[x][y+1] == markColor) {
                queue.offer(new int[]{x, y+1});
                count += 1;
            }
            if (count < 4) {
                grid[x][y] = color;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] r = colorBorder(grid, 1,1,2);
        System.out.println(r);
    }
}
