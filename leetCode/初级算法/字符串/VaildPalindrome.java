package com.company;

import java.util.*;


/**
 * 验证回文字符串
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 *
 * 思路：
 *
 */

public class Main {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length-1;

        while(i<j){
            if(!Character.isDigit(str[i]) && !Character.isLetter(str[i]) ){
                i+=1;
                continue;
            }
            if(!Character.isDigit(str[j]) && !Character.isLetter(str[j]) ){
                j--;
                continue;
            }
            if(str[i]>='a') {
                str[i] = (char) (str[i] - 32);
            }
            if(str[j]>='a') {
                str[j] = (char) (str[j] - 32);
            }
            if(str[i++] != str[j--]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }


}
