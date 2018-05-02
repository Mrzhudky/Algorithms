package com.company;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目：
 *输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 * 递归，将第一个值与之后的各个位置的值互换，用TreeSet结构完成结果的字典序排序
 */



class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();

        if(str == null || str.length() == 0){
            return result;
        }
        if(str.length()<=1){
            result.add(str);
            return result;
        }

        char[] arrayStr = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        PermutationHelp(arrayStr,0,set);
        for (String s:set) {
            result.add(s);
        }
        return result;
    }
    void PermutationHelp(char[] array,int startIndex,TreeSet<String> set){
        if(startIndex == (array.length-1)){
            set.add(String.valueOf(array));
            return;
        }
        for (int i = startIndex; i < array.length; i++) {
            Swap(array,startIndex,i);
            PermutationHelp(array,startIndex+1,set);
            Swap(array,startIndex,i);
        }
    }

    void Swap(char[] array,int i,int j){
        if(i != j){
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}



public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> list;
        list = solution.Permutation("abc");
        for (String s:list
             ) {
            System.out.println(s);
        }


    }
}
