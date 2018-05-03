package com.company;
import java.util.*;

/**
 *题目描述
 *一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 思路：
 * 利用两个相同的数异或得0的特性
 */

public class Main {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0){
            return;
        }
        int len = array.length;
        int twoNumXor = 0;
        for (int i = 0; i < len; i++) {
            twoNumXor ^= array[i];
        }
        int flag = 0x1;
        while ((flag & twoNumXor)==0){
            flag = flag << 1;
        }
        int numXor1 = 0,numXor2 = 0;
        for (int i = 0; i < len ; i++) {
            if((array[i] & flag)==0){
                numXor1 ^= array[i];
            }else{
                numXor2 ^= array[i];
            }
        }

        num1[0] = numXor1;
        num2[0] = numXor2;

    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] array = new int[]{2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int num2[] = new int[1];
        m.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0] + " ; " + num2[0]);

    }
}
