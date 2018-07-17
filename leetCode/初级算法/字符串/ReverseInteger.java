package com.company;

import java.util.*;


/**
 * 颠倒整数
 给定一个 32 位有符号整数，将整数中的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储 32 位有符号整数，
 其数值范围是 [−2^31,  2^31 − 1]。
 根据这个假设，如果反转后的整数溢出，则返回 0。

 *
 * 思路：
 *
 */

public class Main {

    //原思路，受本题所在归类影响，用了字符串反转的方法，提交后发现并非最优
  /*  public int reverse(int x){
        String string = new String(Integer.toString(x));
        char[] str = string.toCharArray();
        int i=0;
        int j=str.length -1;
        if(x<0){
            i=1;
        }
        while (i<j){
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
        String result = new String(str);
        if((x>0) && (str.length==10) && (result.compareTo("2147483647")>=0)){
            return 0;
        }
        if((x<0) && (str.length==11) && (result.compareTo("-2147483648")>=0)){
            return 0;
        }
        return Integer.valueOf(result);
    }
*/
  //参考排名靠前的答案后更新了思路
    public int reverse(int x) {
        double result = 0.0d;
        while(x!=0){
            result =x%10 + result*10.0;
            x = x/10;
        }
        if(x<0){
            result *= -1.0;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
    public static void main(String[] args) {

    }


}
