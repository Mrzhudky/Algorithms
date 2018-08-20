package com.zhudky;
import java.util.*;

/**
 *  两数相加
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1.val + l2.val)%10;
        int C = (l1.val + l2.val)/10;
        ListNode list = new ListNode(sum);
        ListNode head = list;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + C;
            sum = temp%10;
            C = temp/10;
            
            list.next = new ListNode(sum);
            list = list.next;
            list.next = null;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int temp = l1.val + C;
            sum = temp%10;
            C = temp/10;
            
            list.next = new ListNode(sum);
            list = list.next;
            list.next = null;
            
            l1 = l1.next;
            
        }
        while(l2 != null){
            int temp = l2.val + C;
            sum = temp%10;
            C = temp/10;
            
            list.next = new ListNode(sum);
            list = list.next;
            list.next = null;
            
            l2 = l2.next;
        }
        if(C>0){
                        
            list.next = new ListNode(C);
            list = list.next;
            list.next = null;
        }
        return head;
    }
}