package com.company;

import java.util.*;

/*
最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */

public class Main {


    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                map.get(key).add(str);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length()==0){
            return "";
        }
        int len = s.length();
        //插入#后的字符串
        char[] T = new char[len*2+1];
        //记录以i为中心的最长回文串长度
        int[] P = new int[len*2+1];
        T[0] = '#';
        //构建新的字符串:babad -> #b#a#b#a#d
        for (int i = 0; i < len ; i++) {
            T[i*2 + 1] = s.charAt(i);
            T[i*2 + 2] = '#';
        }
        int center = 0;
        int right = 0;
        int maxLen = 0;
        int start = 0;
        for (int i = 1; i < (len*2+1); i++) {
            int mirror = 2*center-i;
            P[i] = (right>i) ? Math.min(right-i,P[mirror]) : 0;
            while((i-P[i]-1 >= 0) && (i+P[i]+1 < len*2+1) && (T[i+P[i]+1] == T[i-P[i]-1])){
                P[i]++;
            }
            if(i+P[i] > right){
                center = i;
                right = i+P[i];
            }
            if(P[i]>maxLen){
                start  = (i - P[i])/2;
                maxLen = P[i];
            }
        }


        return s.substring(start,start+maxLen);
    }
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcdbbfcba"));

    }






}
