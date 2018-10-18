package com.zhudky;

import java.util.*;

/*
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = null;
        for (int i = 0; i < lists.length ; i++) {
            head.next = mergeTwoLists(lists[i],head.next);
        }
        return head.next;
    }

    private ListNode mergeTwoLists(ListNode root1,ListNode root2){
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        if(root1.val > root2.val){
            root2.next = mergeTwoLists(root1,root2.next);
            return root2;
        }
        root1.next = mergeTwoLists(root1.next,root2);
        return root1;
    }
}