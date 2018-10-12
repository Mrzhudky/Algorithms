package com.zhudky;

import java.util.*;

/*
给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
*/
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] exp = p.toCharArray();
        boolean[][] dp = initMatchMap(str,exp);

        for (int i = str.length-1; i >=0 ; i--) {
            for (int j = exp.length-2; j >=0 ; j--) {
                if(exp[j+1] != '*'){
                    if(str[i] == exp[j] || exp[j] == '.'){
                        //dp[i][j] = true;
                        dp[i][j] = dp[i+1][j+1];
                    }
                }
                else{
                    int tempI = i;
                    while (tempI<str.length && (str[tempI] == exp[j] || exp[j] == '.')){
                        if(dp[tempI][j+2]){
                            dp[i][j] = true;
                            break;
                        }
                        tempI++;
                    }
                    if(!dp[i][j] ){
                        dp[i][j] = dp[tempI][j+2];
                    }
                }
            }
        }
        return dp[0][0];

    }

    private boolean[][] initMatchMap(char[] str,char[] exp){
        int slen = str.length;
        int plen = exp.length;
        boolean[][] matched = new boolean[slen+1][plen+1];

        matched[slen][plen] = true;

        //最后一行
        for (int i = plen-2; i >=0 ; i-=2) {
            if(exp[i] != '*' && exp[i+1] == '*'){
                matched[slen][i] = true;
            }else{
                break;
            }
        }

        //倒数第二列
        if(slen>0 && plen>0){
            if(str[slen-1] == exp[plen-1] || exp[plen-1] == '.'){
                matched[slen-1][plen-1] = true;
            }
        }
        return matched;
    }
}