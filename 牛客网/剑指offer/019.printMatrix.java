package com.company;

import java.util.ArrayList;

/**
 * 问题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1  2  3  4
 *                          5  6  7  8
 *                          9  10 11 12
 *                          13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：不断缩减行列范围
 */



  class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        if(matrix == null){
            return result;
        }
        int row = matrix.length; //行
        int cloumn = matrix[0].length;//列
        if(row <1 || cloumn<1){
            return result;
        }
       int startX= 0;
        int endX = cloumn - 1;
        int startY = 0;
        int endY = row   - 1;
        while ((startX <= endX)&&(startY <= endY)){

            int i = startX;
            int j = startY + 1 ;
            while (i <= endX) {
                result.add(matrix[startY][i]);
                i++;
            }
            while (j < endY) {
                result.add(matrix[j][endX]);
                j++;
            }
            i = endX;
            while ((startY != endY)&&(i >= startX)) {
                result.add(matrix[endY][i]);
                i--;
            }
            j = endY-1;
            while ((startX != endX)&&(j > startY)) {
                result.add(matrix[j][startX]);
                j--;
            }
            startX++;endX--;
            startY++;endY--;
        }

        return result;
    }

}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] data1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int [][] data2 = {
                {1}
        };
        ArrayList<Integer> result;
        result  =  solution.printMatrix(data1);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
}
