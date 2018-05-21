package com.company;

import java.util.*;


/***
 * 题目：
 * 一个链表中包含环，请找出该链表的环的入口结点
 */
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}
public class Main {

    public ListNode EntryNodeOfLoop(ListNode pHead){
        HashSet<ListNode> list = new HashSet<>();
        if(pHead == null) {
            return null;
        }
        while (pHead != null){
            if(list.contains(pHead)){
                return pHead;
            }
            list.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        ListNode[] nodes = new ListNode[8];
        for (int i = 0; i < 8; i++) {
            nodes[i] = new ListNode(i);
        }
        for (int i = 0; i < 7; i++) {
            nodes[i].next = nodes[i+1];
        }
        nodes[7].next = nodes[4];
        ListNode r = m.EntryNodeOfLoop(nodes[0]);
        System.out.println(r.val);
    }
}
