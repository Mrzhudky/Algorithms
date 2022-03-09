package com.zhudky.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solution884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordMap = new HashMap<>();
        String[] wordArray1 = s1.split(" ");
        Stream.of(wordArray1).forEach(e -> wordMap.put(e, wordMap.getOrDefault(e, 0) + 1));

        String[] wordArray2 = s2.split(" ");
        Stream.of(wordArray2).forEach(e -> wordMap.put(e, wordMap.getOrDefault(e, 0) + 1));

        List<String> resultList = new ArrayList<>();
        wordMap.forEach((k,v) -> {
            if(v == 1) {
                resultList.add(k);
            }
        });
        return  resultList.toArray(new String[0]);
    }

}
