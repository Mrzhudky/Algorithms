package com.company;

import java.util.*;


/***
 * 题目：
 * 在一个排序的链表中，存在重复结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如：链表：1->2->3->3->4->4->5 处理后为：1->2->5
 */
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "->" + val;
    }
}
public class Main {

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null){
            return null;
        }

        ListNode holdNode = new ListNode(0);
        holdNode.next = new ListNode(0);
        ListNode result = holdNode;
        ListNode lastNode = pHead;
        ListNode node = pHead.next;
        while (node != null){
            if(node.val == lastNode.val){
                while((node != null)&&( node.val == lastNode.val)){
                    node = node.next;
                }
                lastNode = node;
                if (node != null)
                node = node.next;
            }else{
                holdNode.next = lastNode;
                holdNode = lastNode;
                lastNode = node;
                node = node.next;
            }
        }
        holdNode.next = lastNode;
        return result.next;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        ListNode[] nodes = new ListNode[7];
        int[] values = new int[]{1,1,1,1,1,1,2};
        for (int i = 0; i < 7; i++) {
            nodes[i] = new ListNode(values[i]);
        }
        for (int i = 0; i < 6; i++) {
            nodes[i].next = nodes[i+1];
        }
        nodes[6].next = null;
        ListNode r = m.deleteDuplication(nodes[0]);
        while (r != null){
            System.out.print(r);
            r = r.next;
        }
    }
}
