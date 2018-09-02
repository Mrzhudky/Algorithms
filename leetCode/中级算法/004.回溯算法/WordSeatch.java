package com.zhudky;
import java.util.*;

/**
  单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.

 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null){
            return false;
        }
        
        int M = board.length;
        int N = board[0].length;
        boolean[][] reached = new boolean[M][N];
        
        boolean re = false;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == word.charAt(0)){
                    if( dfs(board,reached,word,0,i,j) ){                    
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board,boolean[][] reached,String word,int l,int i,int j){
        if(l == word.length()){
            return true;
        }
        int M = board.length;
        int N = board[0].length;
        if(i<0 || i>=M || j<0 || j>=N){
            return false;
        }

        
        if(word.charAt(l) == board[i][j]  && !reached[i][j]){
            reached[i][j] = true;
                     
            if( dfs(board,reached,word,l+1,i-1,j) ){
                return true;
            }
            
            if( dfs(board,reached,word,l+1,i+1,j) ){
                return true;
            }

            if( dfs(board,reached,word,l+1,i,j-1) ){
                return true;
            }
            
            if( dfs(board,reached,word,l+1,i,j+1) ){
                return true;
            }       
            reached[i][j] = false;
        }
        return false;
    }
}