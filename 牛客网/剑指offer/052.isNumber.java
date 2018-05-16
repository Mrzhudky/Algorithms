package com.company;

import java.util.Scanner;
import java.util.TreeMap;


/***
 * 题目：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Main {

    public boolean isNumeric(char[] str) {

        if(str == null || str.length == 0){
            return false;
        }
        boolean permitSign = true;
        boolean permitE = false;
        boolean permitPoint = true;

        for (int i = 0; i < str.length; i++) {
            char temp = str[i];
            if(i == 1){
                permitE = true;
            }

            if(Character.isDigit(temp)){
                if(permitSign){
                    permitSign =false;
                }
                continue;
            }else if(temp == '-' || temp == '+'){
                if(permitSign){
                    permitSign = false;
                    continue;
                }else{
                    return false;
                }
            }else if(temp == 'e' || temp == 'E'){
                if(permitE){
                    permitE = false;
                    permitSign = true;
                    permitPoint =false;
                    continue;
                }else{
                    return false;
                }
            }else if(temp == '.'){
                if(permitPoint){
                    permitPoint = false;
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        char lastChar = str[str.length-1];
        if(lastChar == 'e' || lastChar == 'E'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(m.isNumeric(str.toCharArray()));
    }
}
