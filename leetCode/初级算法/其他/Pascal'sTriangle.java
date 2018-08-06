package com.zhudky;
import java.util.*;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class Solution {
    // you need to treat n as an unsigned value
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(numRows<1){
            return list;
        }
        
        List<Integer> line = new ArrayList<>();
        line.add(1);
        list.add(line);
        for(int i=1;i<numRows;i++){
            List<Integer> lineTwo = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                int left = 0;
                int right = 0;
                if(j-1<0){
                    left = 0;
                }else{
                    left = line.get(j-1);
                }
                if(j>=i){
                    right = 0;
                }else{
                    right = line.get(j);
                }
                lineTwo.add(left+right);
            }
            list.add(lineTwo);
            line = lineTwo;
            
        }
        return list;
    }
}