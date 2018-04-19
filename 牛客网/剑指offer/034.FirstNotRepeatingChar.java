package com.company;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目：
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */

class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()==0){
            return -1;
        }
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        char[] s = str.toCharArray();
        for(int i=0;i<s.length;i++){
            if(map.containsKey(s[i])){
                int temp = map.get(s[i]);
                map.put(s[i],temp+1);
            }else{
                map.put(s[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                char c = entry.getKey();
                return str.indexOf(c);
            }
        }

        return 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] array = new int[]{3,32,321};//{1,11,111};
        int result = solution.FirstNotRepeatingChar("google");
        System.out.println(result);
    }
}
