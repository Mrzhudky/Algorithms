package com.company;

import java.util.*;


/**
 *  回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 思路：
 * 先用快慢指针找到中点，然后反转前半段，遍历对比
 */

/**
 * Definition for singly-linked list.
 * */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


public class Main {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode reserve = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = reserve;
            reserve = temp;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null && reserve != null){
            if(slow.val != reserve.val){
                return false;
            }
            slow = slow.next;
            reserve = reserve.next;
        }
        // if(slow == null && reserve==null){
        //     return true;
        // }
        return true;
    }
   
    public static void main(String[] args) {

    }


}
