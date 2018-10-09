package com.company;

import java.util.*;

/**
 * 
将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

P   A   H   N
A P L S I I G
Y   I   R
之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

实现一个将字符串进行指定行数变换的函数:

string convert(string s, int numRows);
示例 1:

输入: s = "PAYPALISHIRING", numRows = 3
输出: "PAHNAPLSIIGYIR"
示例 2:

输入: s = "PAYPALISHIRING", numRows = 4
输出: "PINALSIGYAHRPI"
解释:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

public class Solution {

    public String convert(String s, int numRows) {
        if(numRows<=1 || numRows>= s.length()){
            return s;
        }
        int N = s.length()/(numRows + numRows-2);
        N *=1+numRows-2;
        if(s.length()%(numRows + numRows-2) > numRows){
            N += 1+numRows-2;
        }else if(s.length()%(numRows + numRows-2) > 0){
            N += 1;
        }

        char[][] chars = new char[numRows][N];
        boolean directionDown = true;
        int i = 0;
        int j = 0;
        for(char c : s.toCharArray()){
            if(directionDown && i<numRows){
                chars[i++][j] = c;
                if(i>=numRows){
                    directionDown = false;
                    i-=2;
                    j++;
                }
            }else if(i>=0 && j<N){
                chars[i--][j++] = c;
                if(i<0){
                    directionDown = true;
                    i=1;
                    j-=1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char[] str : chars){
            for(char c : str){
                if(c != 0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String re = solution.convert("PAYPALISHIRING",9);
        System.out.println(re);
    }


}
