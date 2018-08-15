package com.zhudky;
import java.util.*;

/**
 *  无重复字符的最长子串
给定一个字符串，找出不含有重复字符的最长子串的长度。

示例：

给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */

public class Solution {
    // you need to treat n as an unsigned value
    public int lengthOfLongestSubstring(String s) {
               
        int[] map = new int[256];
        Arrays.fill(map,-1);
        int maxLen = 0;
        int pre = -1;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i);
            pre = Math.max(pre,map[index]);
            int len = i - pre;
            maxLen = Math.max(maxLen,len);
            map[index] = i;

        }
        return maxLen;
    }
}