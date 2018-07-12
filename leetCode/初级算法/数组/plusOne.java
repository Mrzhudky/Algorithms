package com.company;

import java.util.*;


/**
 * 加一
 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 *
 * 思路：
 */

public class Main {

    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for(int i=len-1;i>=0;i--){
            digits[i] += 1;
            if((digits[i]>9)&&(i>0)){
                digits[i]=digits[i]%10;
            }else{
                break;
            }
        }
        if(digits[0]>9){
            digits[0] %= 10;
            int[] result =new int[len+1];
            result[0]=1;
            System.arraycopy(digits,0,result,1,len);
            return result;
        }
        return digits;
    }


    public static void main(String[] args) {


    }


}
