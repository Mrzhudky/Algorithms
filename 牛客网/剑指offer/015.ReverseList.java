package com.company;

/**
 * 问题：输入一个链表，反转链表后，输出链表的所有元素
 *
 * 思路：三个指针，一个指向当前要反转的节点，一个指向原链表下一个节点，一个指向反转后链表头结点
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode thisNode = head;
        if(thisNode == null){
            return null;
        }
        if(thisNode.next == null){
            return thisNode;
        }
        ListNode revHead = null;
        ListNode preNode = thisNode.next;
        while (preNode.next != null){
            thisNode.next = revHead;
            revHead = thisNode;
            thisNode = preNode;
            preNode = preNode.next;
        }
        thisNode.next = revHead;
        revHead = thisNode;
        preNode.next = revHead;
        revHead = preNode;
        return revHead;
    }
}

