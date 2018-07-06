package com.company;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/**
 链接：https://www.nowcoder.com/acm/contest/131/A
 来源：牛客网

 题目描述
 ZZT 创造了一个队列 Q。这个队列包含了 N 个元素，队列中的第 i 个元素用 Qi 表示。Q1 表示队头元素，QN 表示队尾元素。队列中的元素是 N 的一个全排列。

 ZZT 需要在这个队列上执行 P 次操作，操作分两种：
 FIRST X: 将元素 X 移到队头。
 LAST X: 将元素 X 移到队尾。

 在 P 次操作之后，ZZT 想知道队列中的元素的排列方式，由于他最近很忙，因此需要请你帮他解决这个问题。
 输入描述:
 第一行输入一个正整数 N，表示队列的大小。
 第二行输入 N 个正整数，Q1, Q2, Q3, ... ..., QN，Qi 表示队列中的第 i 个元素。保证这 N 个数是 N 的一个全排列。
 第三行输入一个正整数 P，表示接下来要进行的操作次数。
 接下来 P 行，第 i 行输入一个字符串 Si 以及一个正整数 Xi，表示一次操作。
 1 ≤ N ≤ 105.
 1 ≤ Qi ≤ N.
 1 ≤ P ≤  105.
 Si  { “FIRST”, “LAST” }.
 1 ≤ Xi ≤ 105.
 输出描述:
 输出 N 个正整数，表示 P 次操作之后的队列。
 示例1
 输入
 4
 4 2 1 3
 3
 FIRST 4
 LAST 2
 LAST 1
 输出
 4 3 2 1
 */
public class Main {


    public static void main(String[] args) {
        Main main = new Main();

        Scanner scaner = new Scanner(System.in);
        int N = scaner.nextInt();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> firstStack = new Stack<>();
        LinkedList<Integer> lastQueue = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            int temp = scaner.nextInt();
            queue.offer(temp);
        }
        int P = scaner.nextInt();
        scaner.nextLine();

        TreeSet<Integer> deleteNum = new TreeSet<Integer>();

        for (int i = 0; i < P; i++) {
            String tempStr = scaner.nextLine();
            if(tempStr.startsWith("FIRST")){
                int X = Integer.valueOf(tempStr.substring(6));
                firstStack.push(X);
                deleteNum.add(X);
            }else{
                int X = Integer.valueOf(tempStr.substring(5));
                lastQueue.offer(X);
                deleteNum.add(X);
            }
        }

        int size = firstStack.size();
        for (int i = 0; i < size; i++) {
            queue.offer(firstStack.pop());
        }

        for (int i = 0; i < N; i++) {
            int temp = queue.poll();
            if(!deleteNum.contains(temp)){
                queue.offer(temp);
            }
        }

        size = lastQueue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(lastQueue.poll());
        }

        System.out.print(queue.poll());
        for (int i = 1; i < N; i++) {
            System.out.print(" ");
            System.out.print(queue.poll());
        }
        System.out.println();

    }


}
