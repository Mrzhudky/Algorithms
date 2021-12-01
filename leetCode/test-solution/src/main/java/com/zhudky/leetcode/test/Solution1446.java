package com.zhudky.leetcode.test;

public class Solution1446 {

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int perLen = 1;
        int maxLen = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                perLen = perLen + 1;
            } else {
                perLen = 1;
            }
            maxLen = Math.max(maxLen, perLen);
        }

        return maxLen;
    }

}
