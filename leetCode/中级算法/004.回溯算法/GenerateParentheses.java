package com.zhudky;
import java.util.*;

/**
 *  生成括号
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        char[] chars = new char[n*2];
        help(list,chars,n,n,0);
        return list;
    }
    
    private void help(List<String> list,char[] chars,int left,int right,int i){
        if(left == 0 && right == 0 && i == chars.length){
            list.add(new String(chars));
            return;
        }
        else if(right == 0 || i == chars.length){
            return;
        }
    
        
        if(left>0){
            chars[i] = '(';
            help(list,chars,left-1,right,i+1);
        }
        if(right>0 && left<right){
            chars[i] = ')';
            help(list,chars,left,right-1,i+1);
        }
    }
}