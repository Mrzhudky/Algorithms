/*
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 简单递推一下，会发现，F(n) = 2^(n-1),用移位实现
 * */
import java.util.ArrayList;
class Solution {
    public int JumpFloor(int target){
        if(target<1){
            return 0;
        }
        int N =1;
        N = N<<(target-1);
        return  N;

    }
}