package com.company;

import java.util.*;


/**
 * 旋转图像
 给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 *
 * 思路：
 * 对于90度的翻转有很多方法，一步或多步都可以解，我们先来看一种直接的方法，对于当前位置，计算旋转后的新位置，然后再计算下一个新位置，第四个位置又变成当前位置了，所以这个方法每次循环换四个数字，如下所示：

1  2  3                 7  2  1                  7  4  1

4  5  6      -->      4  5  6　　 -->  　 8  5  2　　

7  8  9                 9  8  3　　　　　 9  6  3
 */

public class Main {
    public void rotate(int[][] matrix) {
        int n = matrix.length -1;
        //对角旋转
        for(int i=0;i<n;i++){
            for (int j = 0; j < n-i; j++) {
                swapDiagonal(matrix,i,j);
            }
        }
        //行翻转
        for (int i = 0; i <= n/2; i++) {
            for (int j = 0; j <= n; j++) {
                swapRow(matrix,i,j);
            }
        }
    }

    private void swapDiagonal(int[][] matrix,int i,int j){
        int n = matrix.length -1;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-j][n-i];
        matrix[n-j][n-i] = temp;
    }

    private void swapRow(int[][] matrix,int i,int j){
        int n = matrix.length -1;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-i][j];
        matrix[n-i][j] = temp;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Main().rotate(matrix);

        System.out.println(matrix);

    }


}
