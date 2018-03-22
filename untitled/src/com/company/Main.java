package com.company;

class Solution {
    /*
    * 常规解法
    * */
    public double Power(double base, int exponent) throws Exception {
        if(( base > -0.0000001) && (base < 0.0000001) && (exponent < 0)){
            throw new Exception ("wrong!");
        }
        if(exponent == 0){
            return 1;
        }
        double value = 1;
        if(exponent>0){
            for(int i=0;i<exponent;i++){
                value *= base;
            }
        }
        if(exponent<0){
            for(int i=0;i>exponent;i--){
                value *=base;
            }
            value =  1/value;
        }
        return value;

    }

    /*
    *最优解：用递归以及位运算简化乘法运算次数，
    * 核心思想：a_n = a_n/2 * a_n/2 ,n为偶数
    *               = a_(n-1)/2 * a_(n-1)/2 * a,n为奇数    *
    * */
    public double PowerII(double base,int exponent) throws Exception {
        if(( base > -0.0000001) && (base < 0.0000001) && (exponent < 0)){
            throw new Exception ("wrong!");
        }
        if(exponent == 0){
            return 1;
        }
        double value = 1;
        if(exponent>0){
            value = PowerWithUnsignedExponent(base,exponent);
        }
        if(exponent<0){
            value = PowerWithUnsignedExponent(base,-exponent);
            value =  1/value;
        }
        return value;
    }

    public double PowerWithUnsignedExponent(double base,int exponent){
        if(exponent == 0) return 1;
        if(exponent == 1) return base;
        double value = PowerWithUnsignedExponent(base,exponent>>1);
        value *=value;
        if( (exponent & 1) == 1){
            value *= base;
        }
        return value;
    }
}


public class Main {

    public static void main(String[] args) {

    }
}
