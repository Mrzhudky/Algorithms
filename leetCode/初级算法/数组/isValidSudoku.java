package com.company;

import java.util.*;


/**
 * 有效的数独
 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
 数独部分空格内已填入了数字，空白格用 '.' 表示。

 示例 1:

 输入:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 输出: true
 *
 * 思路：
 * 在一个循环中，分别对行列做判断，当（i,j）位置位于3x3方块的左上角时，对方块区域进行判断。
 */

public class Main {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] col = new boolean[9];
            boolean[] row = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(col[board[i][j]-'1']){
                        return false;
                    }
                    col[board[i][j]-'1']=true;
                }
                if(board[j][i] != '.'){
                    if(row[board[j][i]-'1']){
                        return false;
                    }
                    row[board[j][i]-'1']=true;
                }
                if((i%3==0) && (j%3==0)){
                    if(checkBlock(board,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private  boolean checkBlock(char[][] board,int startX,int startY){
        boolean[] block = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[startX + i][startY + j] != '.'){
                    int val = board[startX + i][startY + j] - '1';
                    if(block[val]){
                        return true;
                    }
                    block[val] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[9][];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            board[i] = sc.nextLine().toCharArray();
        }
        Main main = new Main();
        boolean re = main.isValidSudoku(board);
        System.out.println(re);


    }


}
