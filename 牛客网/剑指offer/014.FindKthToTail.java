package com.company;

/**
 * 问题：输出链表中倒数第k个节点
 *
 * 思路：两个指针相差k个节点，当快的那个指向最后一个节点是，慢的那个指向倒数第k个节点
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k==0){
            return null;
        }
        ListNode fastNode = head;
        for(int i=1;i<k;i++){
            if(fastNode.next != null){
                fastNode = fastNode.next;
            }else{
                return null;
            }
        }
        ListNode slowNode = head;
        while(fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }
}


