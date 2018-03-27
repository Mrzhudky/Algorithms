package com.company;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 问题：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 * 思路：考虑时间复杂度O(1)
 */



  class Solution {
      Stack<Integer> dataStack = new Stack<>();
      Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }
        if(minStack.peek() > node){
            minStack.push(node);
        }else{
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        if(dataStack.isEmpty()){
            return;
        }
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [][] data1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        int [][] data2 = {
                {1}
        };
        ArrayList<Integer> result;
        result  =  solution.printMatrix(data1);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }
}
