package com.company;


import java.util.Arrays;

/***
 * 题目：
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2-10为本身数字，A为1，J为11，Q为12，K为13，大小王可看成任意数字，以0表示。
 */

public class Main {

    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        Arrays.sort(numbers);
        int zeroNum = 0;
        int needNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                zeroNum++;
            }else{
                if( i>1){
                    int temp = numbers[i] - numbers[i-1];
                    if(temp == 0){
                        return false;
                    }else if(temp > 1){
                        needNum += temp - 1;
                    }
                }
            }
        }
        if((zeroNum - needNum) < 0){
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        int[] array = new int[]{1,3,5,4,2};
        System.out.println(m.isContinuous(array));

    }
}
