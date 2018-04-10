package com.company;
/**
 * 给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
 举例！假设原始字符串为：
 eeefgghhh
 则每种字符出现的次数分别是：
 (1).eee        3次
 (2).f          1次
 (3).gg         2次
 (4).hhh        3次
 重排输出后的字符串如下：
 efghegheh
 编写程序，实现上述功能。
 【温馨提示】
 (1).原始字符串中仅可能出现“数字”和“字母”；
 (2).请注意区分字母大小写。

 输入描述:
 eeefgghhh
 输出描述:
 efghegheh
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        String string = sc.nextLine();
        char[] characters = string.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if(treeMap.containsKey(characters[i])){
                int tempValue = treeMap.get(characters[i]);
                treeMap.put(characters[i],tempValue+1);
            }else{
                treeMap.put(characters[i],1);
            }
        }

        boolean isAllZero = false;
        while (! isAllZero){
            isAllZero = true;
            for (char key:treeMap.keySet()) {
                int tempValue = treeMap.get(key);
                if(tempValue > 0) {
                    System.out.print(key);
                    treeMap.put(key, tempValue - 1);
                    if (tempValue > 1) {
                        isAllZero = false;
                    }
                }

            }
        }
        System.out.println();
    }
}
