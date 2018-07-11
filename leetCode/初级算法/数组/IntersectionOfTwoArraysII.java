package com.company;

import java.util.*;

/**
 * 两个数组的交集 II
 给定两个数组，写一个方法来计算它们的交集。

 例如:
 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

 注意：

 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。

 跟进:
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 思路：
 * 利用HashMap<key=数值，value=出现的次数>,将nums1加入map中，在遍历nums2，通过查询map找出交集
 * -> 如果给定的数组已经排好序呢？你将如何优化你的算法？
 *    =》用两个指针，分别从nums1和nums2的开头开始扫描，相等则为交集，不相等则较小的指针+1；
 * ->  如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *    =》 用HashMap，将nums2加入map，再遍历nums1
 * -> 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *    =》 用HashMap，将nums1加入map，再分段加载nums2，进行查询
 */

public class Main {

    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                    map.put(nums2[i],map.get(nums2[i])-1);
                    list.add(nums2[i]);
            }
        }
        int[] intersection = new int[list.size()];
        for (int i = 0; i < intersection.length; i++) {
            intersection[i] = list.get(i);
        }
        return intersection;
    }


    public static void main(String[] args) {


    }


}
