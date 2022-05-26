package com.zhudky.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution699 {
    public List<Integer> fallingSquares(int[][] positions) {
        int[][] max = new int[positions.length][3];
        for (int i = 0; i < positions.length; i++) {
            max[i][0] = positions[i][0];
            max[i][1] = positions[i][0] + positions[i][1];
            max[i][2] = 0;
        }
        List<Integer> high = new ArrayList<>(positions.length);
        int maxHigh = 0;
        for (int i = 0; i < positions.length; i++) {
            int end = positions[i][0] + positions[i][1];
            for (int j = 0; j < max.length; j++) {
                if (j == i) {
                    continue;
                }
                if((max[j][0] <= positions[i][0] && max[j][1] > positions[i][0])
                        || (max[j][0] < end && max[j][1] >= end)
                        || (max[j][0] >= positions[i][0] && max[j][1] <= end)) {
                    max[i][2] = Math.max(max[i][2], max[j][2] + positions[i][1]);
                }
            }
            max[i][2] = Math.max(max[i][2], positions[i][1]);
            maxHigh = Math.max(maxHigh, max[i][2]);
            high.add(maxHigh);
        }

        return high;
    }

    public static void main(String[] args) {
        Solution699 solution = new Solution699();
        List<Integer> high = solution.fallingSquares(new int[][]{{9,1},{6,5},{6,7}});
        System.out.println(Arrays.toString(high.toArray()));
    }
}
