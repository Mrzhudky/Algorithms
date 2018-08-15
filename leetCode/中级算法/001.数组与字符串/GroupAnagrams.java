package com.zhudky;
import java.util.*;

/**
 *  字谜分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */

public class Solution {
    // you need to treat n as an unsigned value
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str:strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }else{
                map.get(key).add(str);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}