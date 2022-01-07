package com.zhudky.leetcode.test;

public class Solution1614 {
    public static int maxDepth(String s) {
        int noMatchLeft = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                noMatchLeft++;
                maxDepth = Math.max(maxDepth, noMatchLeft);
            } else if (cur == ')') {
                noMatchLeft--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String str = "8*((1*(5+6))*(8/6))";
        int depth = maxDepth(str);
        System.out.println(depth);

    }
}
