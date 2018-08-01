package com.zhudky;
import java.util.*;

/*
 *计数质数
统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 思路：
 * 筛选法
 */
public class Solution {
 public int countPrimes(int n) {
        if(n<4){
            return Math.max(0,n-2);
        }
        
        boolean[] noPrime = new boolean[n];
        for(int i=2;i<n;i++){
            while(i<n && noPrime[i]) i++;
            //int tmep = i;
            for(int j=i*2;j<n;j+=i){
                if(noPrime[j] == false){
                    noPrime[j] = true;     
                }
            }            
        }
        int sum = 0;
        for(int i=2;i<n;i++){
            if(noPrime[i] == false){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}