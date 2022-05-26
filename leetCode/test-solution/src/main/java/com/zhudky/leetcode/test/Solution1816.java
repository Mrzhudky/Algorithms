package com.zhudky.leetcode.test;

public class Solution1816 {
    public static String truncateSentence(String s, int k) {
        int index = 0;
        int count =  0;
        for (char c : s.toCharArray()) {
            index += 1;
            if (c == ' ') {
                count += 1;
            }
            if (count >= k)  {
                break;
            }
        }
        if (index < s.length()) {
            index -= 1;
        }
        return s.substring(0, index);
    }

    public static void main(String[] args) {
        String str = "Hello how are you Contestant";
        int k = 5;
        String r = truncateSentence(str, k);
        System.out.println(r);
    }

}
