package com.company;

import java.util.*;


/**
 *  合并两个有序链表
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 *
 * 思路：
 *
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        if(l1 == null){
            return l2;
        }else if(l2==null){
            return l1;
        }

        ListNode p = null;
        if(l1.val<l2.val){
            p = l1;
            l1 = l1.next;
            // p.next = null;
        }else{
            p = l2;
            l2 = l2.next;
            // p.next = null;
        }
        head.next = p;
        while(l1 != null && l2!= null){
            if(l1.val<l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            p.next = l2;
        }
        if(l2 == null){
            p.next = l1;
        }
        return head.next;
    }
    public static void main(String[] args) {

    }


}
