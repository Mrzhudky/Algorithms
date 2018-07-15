package com.company;

import java.util.*;


/**
 *  二进制间距
给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 

如果没有两个连续的 1，返回 0 。
1 <= N <= 10^9

示例 1：

输入：22
输出：2
解释：
22 的二进制是 0b10110 。
在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
第一对连续的 1 中，两个 1 之间的距离为 2 。
第二对连续的 1 中，两个 1 之间的距离为 1 。
答案取两个距离之中最大的，也就是 2 。
示例 2：

输入：5
输出：2
解释：
5 的二进制是 0b101 。
示例 3：

输入：6
输出：1
解释：
6 的二进制是 0b110 。
示例 4：

输入：8
输出：0
解释：
8 的二进制是 0b1000 。
在 8 的二进制表示中没有连续的 1，所以返回 0 。


 *
 * 思路：
 * 在一个循环中，分别对行列做判断，当（i,j）位置位于3x3方块的左上角时，对方块区域进行判断。
 */

public class Main {
    public int binaryGap(int N) {
        int[] bits = new int[34];
        int i = 0;
        while(N!=0){
            int bit = N&0x1;
            N=N>>1;
            bits[i++]=bit;
        }
        int result = 0;
        for (int j = 0; j < i; j++) {
            if(bits[j]==1){
                if(bits[j+1]==1){
                    result = Math.max(1,result);
                }
                while (j<i && bits[j]==1) ++j;
                int tempLen =0;
                while (j<i && bits[j]==0) {
                    tempLen++;j++;
                }
                if(bits[j]==1){
                    result = Math.max(tempLen+1,result);
                    j--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int re = new Main().binaryGap(N);
        System.out.println(re);

    }


}
