package com.company;

import java.util.*;


/**
 * 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 

注意事项：您可以假定该字符串只包含小写字母。

 *
 * 思路：
 * 创建一个大小为256的char型数组记录各字符出现的，遍历字符串得到各个字符的出现次数，
 * 再遍历一次字符串，找到第一个次数为1 的字符时返回
 */

public class Main {

//我的答案，通过，11ms
    public int firstUniqChar(String s) {
        int[] charTable = new int[256];
        char[] str = s.toCharArray();
        for(int i=0;i<str.length;i++){
            charTable[str[i]] += 1;
        }
        for(int i=0;i<str.length;i++){
            if(charTable[str[i]]==1){
                return i;
            }
        }
        return -1;
    }

//排名靠前的答案，通过，7ms
//结果上看此思路更优，看来需要了解一下indexOf的源码
/*
	class Solution {
		public int firstUniqChar(String s) {
		 int result = -1;
				for(char c = 'a';c<='z';c++){
					int index = s.indexOf(c);
					if(index != -1 && index == s.lastIndexOf(c)){
						result = result != -1?Math.min(result,index):index;
					}
				}
				return result;
		}
	}
	*/
    public static void main(String[] args) {

    }


}
