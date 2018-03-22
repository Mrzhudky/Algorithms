/*
 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0
 * 重复此步骤，直至该整数变为零，可得到1的个数
 **/
public class Solution {
        int i=0;
       while(n!=0){
           n=n&(n-1);
           i++;
       }
        return i;
    }
        
}