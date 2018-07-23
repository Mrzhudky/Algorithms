package com.company;

import java.util.*;


/**
 *  反转链表
 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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

     //递归方法
    /*
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
*/
    //迭代方法
     public ListNode reverseList(ListNode head) {
         if (head == null || head.next == null) {
             return head;
         }
         ListNode back = head;
         ListNode middle = head.next;
         ListNode front = head.next.next;
         back.next = null;
         while(front != null){
             middle.next = back;
             back = middle;
             middle = front;
             front = front.next;
         }
         middle.next = back;
         return middle;
     }
    public static void main(String[] args) {

    }


}
