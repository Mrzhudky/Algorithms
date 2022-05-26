package com.zhudky.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {

    private String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    int[][] encode = {
            { 0b01, 2 }, { 0b1000, 4 }, { 0b1010, 4 }, { 0b100, 3 },
            { 0b0, 1 }, { 0b0010, 4 }, { 0b110, 3 }, { 0b0000, 4 },
            { 0b00, 2 }, { 0b0111, 4 }, { 0b101, 3 }, { 0b0100, 4 },
            { 0b11, 2 }, { 0b10, 2 }, { 0b111, 3 }, { 0b0110, 4 },
            { 0b1101, 4 }, { 0b010, 3 }, { 0b000, 3 }, { 0b1, 1 },
            { 0b001, 3 }, { 0b0001, 4 }, { 0b011, 3 }, { 0b1001, 4 },
            { 0b1011, 4 }, { 0b1100, 4 }
    };
    public int uniqueMorseRepresentations(String[] words) {
        Set<Long> codeSet = new HashSet<>();
        for(String word : words) {
            long code = 0L;
            for(char c : word.toCharArray()) {
                int[] morse = encode[c - 'a'];
                code = (code << morse[1]) | morse[0];
            }
            codeSet.add(code);
        }
        return codeSet.size();

    }
}
