package com.zhudky.leetcode.test;

public class Solution190 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int m = 0;
        for(int i=0;i<32;i++) {
            int bit = n & 0x1;
            n = n >> 1;
            m = m << 1;
            m += bit;
        }
        return m;
    }
}
