package com.company;

import java.util.*;


/**
 *  最长公共前缀
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 *
 * 思路：
 *
 */

public class Main {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        int len = strs.length;
        String commonStr = strs[0];
        for(int i=0;i<len;i++){
            commonStr = getFromTwoString(commonStr,strs[i]);
            if(commonStr == ""){
                return "";
            }
        }
        return commonStr;
    }

    private String getFromTwoString(String last,String current){
        int len = Math.min(last.length(),current.length());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            if(last.charAt(i) == current.charAt(i)){
                sb.append(last.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }


}
