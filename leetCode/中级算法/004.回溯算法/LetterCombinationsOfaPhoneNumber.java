package com.company;

import java.util.*;

/**
 * Created by zhu on 2018/8/30.
 * 电话号码的字母组合
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
         2:abc    3:def
 4:ghi   5:jkl    6:mno
 7:pqrs  8:tuv    9:wxyz

 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length()==0 || !isDigit(digits)){
            return list;
        }
        HashMap<Character,String> map = new HashMap<>(8);
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        char[] chars = new char[digits.length()];
        help(list,digits,map,chars,0);
        return list;
    }

    private boolean isDigit(String digits){
        int N = digits.length();
        for (int i = 0; i < N; i++) {
            char c = digits.charAt(i);
            if(c<'2' || c>'9'){
                return false;
            }
        }
        return true;
    }

    private void help(List<String> list,String digits,HashMap<Character,String> map,char[] chars,int i){
        if(i == digits.length()){
            list.add(new String(chars));
            return;
        }
        String letters = map.get(digits.charAt(i));
        int n = letters.length();
        for (int j = 0; j < n; j++) {
            chars[i] = letters.charAt(j);
            help(list,digits,map,chars,i+1);
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();

    }
}
