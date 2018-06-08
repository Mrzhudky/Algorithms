package com.company;
/***
 * 题目：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class Main {

    public String ReverseSentence(String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        String[] words = str.split("\\s");
        int len = words.length;
        if(len <= 0){
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = len -1 ; i > 0; i--) {
            stringBuffer.append(words[i]);
            stringBuffer.append(" ");
        }

        stringBuffer.append(words[0]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        String str = "I am a student.";
        System.out.println(m.ReverseSentence(" "));

    }
}
