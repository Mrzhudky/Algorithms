package com.company;

import java.util.*;


/**
 *  删除链表的倒数第N个节点
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 *
 * 思路：
 * 利用两个相隔n的指针扫描一趟链表，当前面的指针指向尾节点时，后面的指针指向待删除节点的上一个节点。
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        ListNode back = headNode;
        for(int i=1;i<n;i++){
            head = head.next;
        }
        while(head !=null && head.next != null){
            head = head.next;
            back = back.next;
        }
        if(n==1){
            back.next = null;
        }else{
            back.next = back.next.next;
        }

        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        new Main().removeNthFromEnd(list,1);

    }


}
