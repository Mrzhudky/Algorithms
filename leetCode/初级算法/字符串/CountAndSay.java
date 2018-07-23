package com.company;

import java.util.*;


/**
 *  数数并说
 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n ，输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。

 示例 1:

 输入: 1
 输出: "1"
 示例 2:

 输入: 4
 输出: "1211"
 *
 * 思路：
 *
 */

public class Main {

    public String countAndSay(int n) {
        String start = "1";
        if(n==1){
            return start;
        }else {
            n--;
        }
        while(n>0){
            StringBuilder builder = new StringBuilder();
            char lastChar = start.charAt(0);
            int charNum = 0;
            for(int i=0;i<start.length();i++){
                if(start.charAt(i) == lastChar){
                    charNum++;
                }else{
                    builder.append(charNum);
                    builder.append(lastChar);
                    charNum =1;
                    lastChar = start.charAt(i);
                }
            }
            builder.append(charNum);
            builder.append(lastChar);
            start = builder.toString();
            n--;
        }
        return start;
    }

    public static void main(String[] args) {

    }


}
