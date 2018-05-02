package com.company;


/**
 * 题目：
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 思路：
 *以2、3、5为因子依次推
 */

class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        if(index <7 ){
            return index;
        }
        int curUgly = 1;

        int[] uglys = new int[index+1];
        uglys[0] = 1;
        int factorIndex2 = 0;
        int factorIndex3 = 0;
        int factorIndex5 = 0;
        for (int i = 1; i < index; i++) {
            curUgly = minThree(uglys[factorIndex2]*2,uglys[factorIndex3]*3,uglys[factorIndex5]*5);
            uglys[i] = curUgly;
            if(curUgly == (uglys[factorIndex2]*2)){

                factorIndex2++;
            }
            if(curUgly == (uglys[factorIndex3]*3)){
                factorIndex3++;
            }
            if(curUgly == (uglys[factorIndex5]*5)){
                factorIndex5++;
            }
        }
        return uglys[index-1];
    }
    public int minThree(int twoFactor,int threeFactor,int fiveFactor){
        int min = twoFactor;
        if(threeFactor < min){
            min = threeFactor;
        }
        if(fiveFactor < min){
            min = fiveFactor;
        }
        return min;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] array = new int[]{3,32,321};//{1,11,111};
        int result = solution.GetUglyNumber_Solution(8);
        System.out.println(result);
    }
}
