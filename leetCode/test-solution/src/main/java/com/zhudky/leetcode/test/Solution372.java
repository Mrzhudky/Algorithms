package com.zhudky.leetcode.test;

public class Solution372 {


    private static final int DIVISOR = 1337;
    public int superPow(int a, int[] b) {
        int bottom = a % DIVISOR;
        int[] factors = tenBottom(bottom);
        int tenModNum = modPow(10, factors);
        Integer lastMod = 1;
        for(int e : b) {
             lastMod = (lastMod *  modPow(e, factors)) % DIVISOR;
        }
        return lastMod;

    }

    private int[] tenBottom(int bottom) {
        int[] factors = new int[4];
        factors[0] = bottom;
        for (int i = 1; i < 4; i++) {
            factors[i] = (factors[i-1] * factors[i-1]) % DIVISOR;
        }
        return factors;
    }

    private int modPow(int exp, int[] factors) {
        int modNum = 1;
        for (int i = 0; i < 4; i++) {
            if (exp <= 0) {
                break;
            }
            int bitNum = exp & 0x1;
            exp = exp >> 1;
            if (bitNum == 0x1) {
                modNum = (modNum * factors[i]) % DIVISOR;
            }
        }
        return modNum;
    }

    /**
     * 示例 1：
     *
     * 输入：a = 2, b = [3]
     * 输出：8
     * 示例 2：
     *
     * 输入：a = 2, b = [1,0]
     * 输出：1024
     * 示例 3：
     *
     * 输入：a = 1, b = [4,3,3,8,5,2]
     * 输出：1
     * 示例 4：
     *
     * 输入：a = 2147483647, b = [2,0,0]
     * 输出：1198
     */
    public static void main(String[] args) {
        int a = 2;
        int[] b = new int[]{1,0};
        Solution372 solution372 = new Solution372();
        int r = solution372.superPow(a, b);
        System.out.println(r);

    }

}
