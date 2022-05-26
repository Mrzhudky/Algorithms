package com.zhudky.leetcode.test;

import java.util.*;

public class Solution433 {
    public class Node {
        int step;
        char[] gens;
        boolean endStep;
        Set<Node> next;

        public Node(int s, char[] g, boolean e) {
            this.step = s;
            this.gens = g;
            this.endStep = e;
            this.next = new HashSet<>();
        }
    }


    public int minMutation(String start, String end, String[] bank) {
        return 0;


    }

    private int diffNum(char[] s1, char[] s2) {
        int diff = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                diff++;
            }
            if (diff > 1) {
                break;
            }
        }
        return diff;
    }

}
