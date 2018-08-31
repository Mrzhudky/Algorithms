package com.zhudky;
import java.util.*;

/**
 *  岛屿的个数
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11000
00100
00011

输出: 3
 */

public class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        int re = 0;
        
        boolean[][] reached = new boolean[M][N];
        for (int i = 0; i < M; i++) {            
            for (int j = 0; j < N; j++) {
                if(!reached[i][j] && grid[i][j] == '1'){
                    dps(grid,reached,i,j);
                    re++;
                }
            }
        }
        return re;
    }
    
    private void dps(char[][] grid,boolean[][] reached,int i,int j){
        int M = grid.length;
        int N = grid[0].length;
        
        if(i<0 || i>=M || j<0 || j>=N){
            return;
        }
        if(grid[i][j] == '1' && !reached[i][j]){
            reached[i][j] = true;
            dps(grid,reached,i-1,j);
            dps(grid,reached,i+1,j);
            dps(grid,reached,i,j-1);
            dps(grid,reached,i,j+1);
        }
    }
}