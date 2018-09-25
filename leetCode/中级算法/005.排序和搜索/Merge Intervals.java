package com.zhudky;
import java.util.*;

/**
56.合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
                Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        List<Interval> re = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = new Interval(intervals.get(i-1).start,intervals.get(i-1).end);
            int j = i;
            while (j<intervals.size() && intervals.get(j-1).end>=intervals.get(j).start){
                int maxEnd = Math.max(intervals.get(j-1).end,intervals.get(j).end);
                temp.end = Math.max(temp.end,maxEnd);
                j++;
            }
            i = j;
            re.add(temp);            
        }
        if(intervals.get(intervals.size()-1).start > re.get(re.size()-1).end){
            re.add(intervals.get(intervals.size()-1));
        }
        return re;
    }
}