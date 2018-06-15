package com.company;
import java.util.*;

/**
 * 题目描述
 * 牛客模拟考2016、6、15
 * 牛牛把星星图看出一个平面，
 *
 * 思路:
 * 把有星星的平面看出稀疏矩阵，然后通过稀疏矩阵的表示方法来缩短查找的时间
 */
public class Main {

    public static void main(String[] args) {
//        XHead head = new XHead(0,0);
        TreeMap<Integer,TreeSet<Integer>> starTree = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tempX = sc.nextInt();
            int tempY = sc.nextInt();
            if(starTree.containsKey(tempX)){
                TreeSet<Integer> tempYTree = starTree.get(tempX);
                tempYTree.add(tempY);
            }else{
                TreeSet<Integer> tempYTree = new TreeSet<>();
                tempYTree.add(tempY);
                starTree.put(tempX,tempYTree);
            }
        }
        int m = sc.nextInt();
        int[] results = new int[m];
        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            results[i] =0;
            for (int j = x1; j <= x2; j++) {
                if(starTree.containsKey(j)){
                    TreeSet<Integer> tempYTree = starTree.get(j);
                    for (int k = y1; k <= y2; k++) {
                        if(tempYTree.contains(k)){
                            results[i]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(results[i]);
        }
    }
}
