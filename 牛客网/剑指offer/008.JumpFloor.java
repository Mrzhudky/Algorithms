package com.company;
/*
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 假设F(n)表示n层台阶的跳法种数，最后一步有跳一级和跳两级两种，
 * 由此，F(n) = F(n-1) + F（n-2）,即求第n+1项斐波那契数
 * */
import java.util.ArrayList;
class Solution {
    public int JumpFloor(int target){
        if(target<1){
            return 0;
        }
        if(target<3){
            return target;
        }

        int F1 = 1;    //n-2层跳法数
        int F2 = 2;    //n-1层跳法数
        int F = F1+F2; //n层跳法数
        for (int i = 2; i < target; i++) {
            F = F1 +F2;
            F1 = F2;
            F2 = F;
        }
        return F;
    }
}
