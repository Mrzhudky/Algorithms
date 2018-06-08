package com.company;
import java.util.*;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * 思路：
 * 利用最大堆的性质
 */

public class Main {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length <size || size<1){
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); //自定义Comparator函数将小顶堆转换为大顶堆
        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        }
        list.add(maxHeap.peek());
        for (int i = size; i < num.length; i++) {
            maxHeap.remove(num[i-size]);
            maxHeap.add(num[i]);
            list.add(maxHeap.peek());
        }
        return list;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] array = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> list =  m.maxInWindows(array,3);
        System.out.println(list);

    }
}
