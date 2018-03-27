package com.company;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 问题：输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：用一个辅助栈，来模拟入栈和出栈过程，逐一匹配popA的值出栈，若最终辅助栈为空，则说明可以按该顺序出栈
 */



  class Solution {
      public boolean IsPopOrder(int [] pushA,int [] popA){
          Stack<Integer> dataStack = new Stack<>();

          if(pushA == null || popA==null){
              return false;
          }
          int pushNum = 0;
          for (int popNum = 0;popNum<popA.length ;popNum++){
              while (dataStack.empty() || dataStack.peek() != popA[popNum]){
                  if(pushNum+1>pushA.length) {
                      break;
                  }
                  dataStack.push(pushA[pushNum++]);
              }
              if(dataStack.peek() != popA[popNum]){
                  return false;
              }
              dataStack.pop();

          }
          return dataStack.empty();
      }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
