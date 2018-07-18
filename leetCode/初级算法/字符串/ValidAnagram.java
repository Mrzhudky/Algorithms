package com.company;

import java.util.*;


/**
 * 有效的字母异位词
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 思路：
 *
 */

public class Main {
//最先想到的思路，利用HashMap。通过48ms。
    /*
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        //遍历s字符串
        for(int i=0;i<sArray.length;i++){
            if(map.containsKey(sArray[i])){
                map.put(sArray[i],map.get(sArray[i])+1);
            }else{
                map.put(sArray[i],1);
            }
        }

        //遍历t字符串，经行对比
        for(int i=0;i<tArray.length;i++){
            if(!map.containsKey(tArray[i])){
                return false;
            }else{
                int times = map.get(tArray[i]);
                if (times>1){
                    map.put(tArray[i],times-1);
                }else if(times == 1){
                    map.remove(tArray[i]);
                }else{
                    return false;
                }
            }
        }
    //若map中元素还有剩余，则返回false
        if(map.size()>0){
            return false;
        }
        return true;
    }
    */

    //改进后的思路，用数组替换HashMap
    /*
    public boolean isAnagram(String s, String t) {
        int[] charArray = new int[26];
//        int[] tArray = new int[26];

        //遍历s字符串
        for(int i=0;i<s.length();i++){
            charArray[s.charAt(i)-'a'] += 1;
        }

        //遍历t字符串，经行对比
        for(int i=0;i<t.length();i++){
            int times = charArray[t.charAt(i)-'a'];
            if(times > 0){
                charArray[t.charAt(i)-'a'] -= 1;
            }else{
                return false;
            }
        }
        //若map中元素还有剩余，则返回false
        for (int i = 0; i < 26; i++) {
            if(charArray[i]>0) return false;
        }
        return true;
    }
*/
    //参考别人的思路：先排序在比较
     public boolean isAnagram(String s, String t) {
         if (s.length() != t.length()) {
             return false;
         }
         char[] c1 = s.toCharArray();
         char[] c2 = t.toCharArray();
         Arrays.sort(c1);
         Arrays.sort(c2);
         int len = c1.length;
         for (int i = 0; i < len; i++) {
             if (c1[i] != c2[i]) {
                 return false;
             }
         }
         return true;
     }
    public static void main(String[] args) {

    }


}
