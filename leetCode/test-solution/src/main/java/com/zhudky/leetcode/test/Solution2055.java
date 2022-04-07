package com.zhudky.leetcode.test;

import java.util.stream.Stream;

public class Solution2055 {



    public static int[] platesBetweenCandles(String s, int[][] queries) {

        boolean findStart = false;
        int count = 0;
        char[] strArray = s.toCharArray();
        int[] record = new int[strArray.length];
        int left = 0;
        int right = strArray.length - 1;
        while (left < strArray.length) {
            if(strArray[left] == '|') {
                break;
            }
            left ++;
        }

        while (right >= 0) {
            if(strArray[right] == '|') {
                break;
            }
            right--;
        }

        for(int i = 0; i < strArray.length; i++ ) {
            char c = strArray[i];
            if (i < left) {
                record[i] = 0;
            } else if (i > right) {
                record[i] = record[i-1];
            } else if (c == '*') {
                count += 1;
                record[i] = record[i-1];
            } else if (c == '|') {
                record[i] = record[i-1] + count;
                count = 0;
            }
        }


        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = record[queries[i][1]] - record[queries[i][0]];
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] query = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        int[] r = platesBetweenCandles(s, query);
        Stream.of(r).forEach(e -> System.out.println( e));
    }
}
