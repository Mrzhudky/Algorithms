package com.zhudky.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class Solution782 {

    static Set<Integer> checkSet = new HashSet<>();

    static {
        int[] ziShu = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        for(int c : ziShu) {
            checkSet.add(c);
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++) {
            int x = i;
            x = (x & 0x55555555) + ((x >>> 1) & 0x55555555);
            x = (x & 0x33333333) + ((x >>> 2) & 0x33333333);
            x = (x & 0x0f0f0f0f) + ((x >>> 4) & 0x0f0f0f0f);
            x = (x & 0x00ff00ff) + ((x >>> 8) & 0x00ff00ff);
            x = (x & 0x0000ffff) + ((x >>> 16) & 0x0000ffff);
            if (checkSet.contains(x)) {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution782 s = new Solution782();

        int r = s.countPrimeSetBits(6,10);
    }
}
