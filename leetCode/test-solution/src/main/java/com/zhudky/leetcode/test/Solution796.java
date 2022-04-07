package com.zhudky.leetcode.test;

public class Solution796 {

    /**
     * 没考虑到  S+S即可包含 goal 的思路。
     */
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }

}
