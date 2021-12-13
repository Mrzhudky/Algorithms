package com.zhudky.leetcode.test;

public class Solution794 {

    public static boolean validTicTacToe(String[] board) {
        // 1、X 数量要大于等于O
        // 2、X有三连，则X 数量大于O
        // 3、O有三连，则X 数量等于O

        char[][] cells = new char[3][3];
        cells[0] = board[0].toCharArray();
        cells[1] = board[1].toCharArray();
        cells[2] = board[2].toCharArray();

        int xNum = 0;
        int oNum = 0;
        int xThreeLink = 0;
        int oThreeLink = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 'X') {
                    xNum += 1;
                } else if (cells[i][j] == 'O') {
                    oNum += 1;
                }
            }

            if(cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                if (cells[i][0] == 'X') {
                    xThreeLink += 1;
                } else if (cells[i][0] == 'O') {
                    oThreeLink += 1;
                }
            }

            if(cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                if (cells[0][i] == 'X') {
                    xThreeLink += 1;
                } else if (cells[0][i] == 'O') {
                    oThreeLink += 1;
                }
            }
        }
        if (xNum != oNum && xNum != (oNum + 1)) {
            return false;
        }


        if (cells[1][1] == cells[0][0] && cells[1][1] == cells[2][2]) {
            if (cells[1][1] == 'X') {
                xThreeLink += 1;
            } else if (cells[1][1] == 'O') {
                oThreeLink += 1;
            }
        } else if (cells[1][1] == cells[0][2] && cells[1][1] == cells[2][0]) {
            if (cells[1][1] == 'X') {
                xThreeLink += 1;
            } else if (cells[1][1] == 'O') {
                oThreeLink += 1;
            }
        }
        if (xThreeLink == 0 && oThreeLink == 0) {
            return true;
        }
        if (xThreeLink >= 1 && xNum == (oNum + 1) && oThreeLink == 0) {
            return true;
        }
        if (xThreeLink == 0 && xNum == oNum && oThreeLink >= 1) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"X  ","   ","   "};
        boolean r = validTicTacToe(str);
        System.out.println(r);
    }

}
