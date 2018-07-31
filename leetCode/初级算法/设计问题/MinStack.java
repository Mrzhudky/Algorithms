package com.zhudky;
import java.util.*;

public class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minVal;
    /** initialize your data structure here. */
    public MinStack() {
        values = new Stack<Integer>();
        minVal = new Stack<Integer>();
    }

    public void push(int x) {
        if(values.isEmpty() || minVal.isEmpty()){
            minVal.push(x);
        }else{
            int temp = minVal.peek();
            minVal.push(Math.min(temp,x));
        }
        values.push(x);
    }

    public void pop() {
        values.pop();
        minVal.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minVal.peek();
    }
}
