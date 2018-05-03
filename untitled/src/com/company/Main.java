package com.company;
import java.sql.SQLOutput;
import java.util.ArrayList;
/***
 * 题目：
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

public class Main {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(sum <= 2){
            return result;
        }
        int curSum = 3;
        int small = 1;
        int big =2;
        while(big <= ((sum+1)/2)){
            if(curSum > sum){
                curSum -= small;
                small++;
            }else if(curSum < sum){
                big++;
                curSum += big;
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                result.add(list);
                curSum -=small;
                small++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        ArrayList<ArrayList<Integer>> result = m.FindContinuousSequence(9);
        System.out.println(result);

    }
}
