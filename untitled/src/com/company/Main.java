package com.company;
import java.util.Scanner;
/**
 * 题目名称：最长公共子串
 *输入描述：随机输入两个字符串，都是英文字母，不区分大小写
 *
 *输出描述：输出“resullt=?”，没有匹配到返回“”，匹配到返回“slfl”字样
 *示例1
 *输入
 *afhelk afdzhelos
 *输出
 *resullt=hel
 */




public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.next("\\w+").toCharArray();
        char[] str2 = sc.next("\\w+").toCharArray();

        int[][] dp = new int[str1.length][str2.length];
        int maxLen = 0;
        int endI = 0;
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if(str1[i] == str2[j]){
                    if(i>0 && j>0){
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                    else{
                        dp[i][j] = 1;
                    }
                }
                if(dp[i][j]>maxLen){
                    maxLen = dp[i][j];
                    endI = i;
                }
            }
        }
        System.out.print("result=");
        for (int i = endI - maxLen +1; i <= endI; i++) {
            System.out.print(str1[i]);
        }
        System.out.println();


    }
}
