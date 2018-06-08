package com.company;


import java.util.Arrays;

/***
 * 题目：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 * 0
 */

public class Main {

    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int index = 0;
        int flag = 1;
        if(str.charAt(index) == '+'){
            index++;
        }else if(str.charAt(index) == '-'){
            index++;
            flag = -1;
        }
        int num = 0;
        while (index < str.length()){
            char temp = str.charAt(index);
            if(Character.isDigit(temp)){
                num = num*10 + (temp - 48);
            }else{
                return 0;
            }
            index++;
        }
        num = num * flag;
        return num;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.StrToInt("++1"));

    }
}
