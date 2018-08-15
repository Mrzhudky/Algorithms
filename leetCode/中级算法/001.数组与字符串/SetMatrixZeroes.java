package com.zhudky;
import java.util.*;

/**
 *  矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 */

public class Solution {
    // you need to treat n as an unsigned value
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        
       boolean row = false; //设置标记[0,0]的0代表行
       boolean column = false;//设置标记[0,0]的0代表列
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j]=0;
                    if(i==0 && !row){
                        row = true;
                    }
                    if(j==0 && !column){
                        column = true;
                    }
                }                
            }
        }
        
        for(int i=1;i<M;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<N;j++){                
                    matrix[i][j]=0;
                }                
            }           
        }
        
        for(int j=1;j<N;j++){
            if(matrix[0][j] == 0){
                for(int i = 1;i<M;i++){                
                    matrix[i][j]=0;
                }                
            }           
        }
        
        if(column){
            for(int i=0;i<M;i++){           
                    matrix[i][0]=0;           
            }         
        
        }    
        if(row){
            for(int j=0;j<N;j++){           
                    matrix[0][j]=0;           
            }         
        
        }   

        
    }
}