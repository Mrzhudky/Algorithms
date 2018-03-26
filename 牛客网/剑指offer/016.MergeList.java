package com.company;

/**
 * 问题：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：考虑空节点的情况
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;
        ListNode thisNode = null;
        while ((list1 != null)&&(list2 != null)){
            if(list1.val < list2.val){
                if(head== null){
                    head = list1;
                    thisNode = list1;
                }else{
                    thisNode.next = list1;
                    thisNode = thisNode.next;
                }
                list1 = list1.next;
                thisNode.next = null;
            }
            if(head == null){
                head = list2;
                thisNode = list2;
            }else {
                thisNode.next = list2;
                thisNode = thisNode.next;
            }
            list2 = list2.next;
            thisNode.next = null;
        }
        while (list1 != null){
            if(head== null){
                head = list1;
                thisNode = list1;
            }else{
                thisNode.next = list1;
                thisNode = thisNode.next;
            }
            list1 = list1.next;
            thisNode.next = null;
        }
        while (list2 != null){
            if(head == null){
                head = list2;
                thisNode = list2;
            }else {
                thisNode.next = list2;
                thisNode = thisNode.next;
            }
            list2 = list2.next;
            thisNode.next = null;
        }
        return head;
    }
}

