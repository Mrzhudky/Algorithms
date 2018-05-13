package com.company;
import java.util.ArrayList;
/***
 * 题目：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class Main {

    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0){
            return "";
        }
        StringBuffer strBuffer = new StringBuffer(str);
        int leftLength = n%str.length();
        String leftStr = strBuffer.substring(0,leftLength);
        strBuffer.delete(0,leftLength);
        strBuffer.append(leftStr);
        return strBuffer.toString();
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        String str = "abcXYZdef";
        System.out.println(m.LeftRotateString(str,3));

    }
}
