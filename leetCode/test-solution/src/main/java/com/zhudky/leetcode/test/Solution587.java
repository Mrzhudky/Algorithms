package com.zhudky.leetcode.test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Solution587 {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        Arrays.sort(trees, (a, b) -> {
            return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
        });
        List<Integer> stack = new ArrayList<>();
        boolean[] used = new boolean[n];
        stack.add(0);
        stack.add(1);
        used[1] = true;
        for (int i = 2; i < n; i++) {
            while (stack.size() > 1 && cross(trees[stack.get(stack.size() - 2)], trees[stack.get(stack.size() - 1)], trees[i]) < 0) {
                used[stack.get(stack.size() - 1) ] = false;
                stack.remove(stack.size() - 1);
            }
            stack.add(i);
            used[i] = true;
        }
        int m = stack.size();
        for (int i = n-2; i >= 0; i--) {
            if (used[i]) {
                continue;
            }
            while (stack.size() > m && cross(trees[stack.get(stack.size() - 2)], trees[stack.get(stack.size() - 1)], trees[i]) < 0) {
                used[stack.size() - 1] =false;
                stack.remove(stack.size() - 1);
            }
            stack.add(i);
            used[i] = true;
        }
        stack.remove(stack.size() - 1);
        int[][] result = new int[stack.size()][2];
        for (int j = 0; j < stack.size(); j++) {
            result[j] = trees[stack.get(j)];
        }
        return result;
    }

    private int cross(int[] A, int[] B, int[] C) {
        return (A[0] - B[0]) * (B[1] - C[1]) - (A[1] - B[1]) * (B[0] - C[0]);
    }

    public static void main(String[] args) {
        Solution587 solution = new Solution587();
        int[][] trees = {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        int[][] r = solution.outerTrees(trees);

        for(int[] r1 : r) {
            System.out.println(Arrays.toString(r1));
        }
    }
}
