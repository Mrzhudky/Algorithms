package com.company;
import java.util.Scanner;
/**
 * 题目名称：孪生质数
 *时间限制：3000ms
 *题目描述：数学中有很多奇特的现象，孪生质数就是一种(孪生素数就是指相差2的质数对，例如3和5，5和7，11和13…)，现在要求输出所有在m和n范围内的孪生质数
 *
 *输入描述：输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）
 *
 *输出描述：对于每个测试实例，要求输出所有在给定范围内孪生质数，就是说，输出的孪生质数必须大于等于m,并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开 ; 如果给定的范围内不存在孪生指数，则输出 “no” ; 每个测试实例的输出占一行
 *示例1
 *输入
 *100 150
 *输出
 *101 103 107 109 137 139
 */




public class Main {

    public static boolean IsPrimeNumber(int n){
        double n_sqrt;
        if(n==2 || n==3) return true;
        if(n%6!=1 && n%6!=5) return false;
        n_sqrt=Math.floor(Math.sqrt((double) n));
        for(int i=5;i<=n_sqrt;i+=6)
        {
            if(n%(i)==0 | n%(i+2)==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerLimit = 0;
        lowerLimit = sc.nextInt();
        int upperLimit = 0;
        upperLimit = sc.nextInt();

        int testNum = (lowerLimit/6)*6 + 6;
        int totalOutput = 0;
        int leftNum = testNum-1;
        int rightNum = testNum+1;
        if(leftNum<lowerLimit){
            leftNum +=6;
            rightNum +=6;
        }
        while (rightNum <= upperLimit){
            if(IsPrimeNumber(leftNum) && IsPrimeNumber(rightNum)){
                if(totalOutput != 0){
                    System.out.print(" ");
                }
                System.out.print(leftNum + " " + rightNum);
                totalOutput += 2;
            }
            leftNum += 6;
            rightNum += 6;
        }

        if(totalOutput == 0){
            System.out.print("no");
        }
        System.out.println();


    }
}
