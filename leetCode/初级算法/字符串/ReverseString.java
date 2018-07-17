package com.company;

import java.util.*;


/**
 * 反转字符串
 请编写一个函数，其功能是将输入的字符串反转过来。

 示例：

 输入：s = "hello"
 返回："olleh"

 *
 * 思路：
 *
 */

public class Main {

    public String reverseString(String s){

        char[] str = s.toCharArray();
        int i=0;
        int j=str.length -1;
        while (i<j){
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        return new String(str);
    }

    public static void main(String[] args) {

    }


}
