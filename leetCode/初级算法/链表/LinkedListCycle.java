package com.company;

import java.util.*;


/**
 *  环形链表
给定一个链表，判断链表中是否有环。

进阶：
你能否不使用额外空间解决此题？
 *
 * 思路：
 * 快慢两个指针，相遇则有环，否则无环
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


    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }            
        }
        return false;
    }

    public static void main(String[] args) {

    }


}
