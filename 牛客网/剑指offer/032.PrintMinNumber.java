package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目：
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 思路：
 * 《剑指offer》P180
 * 定义规则：数据m与n ，
 * 当 mn拼接 > nm拼接 时，认为 m ‘大于’ n ；反之，mn拼接 < nm拼接 时，认为 m ‘小于’ n ；
 * 当 mn拼接 = nm拼接 时，认为 m ‘等于’ n
 * 当 数组的元素按该规则升序排序后，依次拼接即为 最小的一个
 */

class Solution {

    //方案二：使用Comparator
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        int len = numbers.length;
        //方案二：
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list,c);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();

    }
    static Comparator<String> c = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            String m = (String)o1;
            String n = (String)o2;
            StringBuffer mnStrBuf = new StringBuffer(m);
            mnStrBuf.append(n);
            String mnString = mnStrBuf.toString();

            StringBuffer nmStrBuf = new StringBuffer(n);
            nmStrBuf.append(m);
            String nmString = nmStrBuf.toString();

            int result =  mnString.compareTo(nmString);
            return result;
        }
    };


}

//方案一：实现Comparable接口
/*
public String PrintMinNumber(int [] numbers) {
    if(numbers == null || numbers.length == 0){
        return "";
    }
    int len = numbers.length;
    ArrayList<IntForJoint> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
        IntForJoint transport = new IntForJoint(numbers[i]);
        list.add(transport);
    }
    Collections.sort(list);
    StringBuilder stringBuilder = new StringBuilder();
    for (IntForJoint s:list) {
        stringBuilder.append(s.getContent());
    }
    return stringBuilder.toString();
}
class IntForJoint implements Comparable<IntForJoint> {
    private int value;
    private String content;

    IntForJoint(){
        value =0;
        content = "0";
    }
    IntForJoint(int val){
        this.value = val;
        this.content = String.valueOf(val);
    }
    public void setValue(int val){
        this.value = val;
        this.content = String.valueOf(val);
    }

    public String getContent() {
        return content;
    }

    @Override
    public int compareTo(IntForJoint o) {
        StringBuffer mnStrBuf = new StringBuffer(this.content);
        mnStrBuf.append(o.getContent());
        String mnString = mnStrBuf.toString();

        StringBuffer nmStrBuf = new StringBuffer(o.getContent());
        nmStrBuf.append(this.content);
        String nmString = nmStrBuf.toString();

        int result =  mnString.compareTo(nmString);
        return result;
    }
}
*/

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{3,32,321};//{1,11,111};
        String result = solution.PrintMinNumber(array);
        System.out.println(result);
    }
}
