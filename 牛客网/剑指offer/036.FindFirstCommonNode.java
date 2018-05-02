package com.company;
import java.util.*;

/**
 *题目描述
 *输入两个链表，找出它们的第一个公共结点。
 */
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val = " + val;
    }
}

public class Main {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();

        ListNode inversionList1 = null;
        ListNode inversionList2 = null;

        while (pHead1 != null){
            list1.add(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2 != null){
            list2.add(pHead2);
            pHead2 = pHead2.next;
        }
        int i = list1.size();
        int j = list2.size();
        while ((i-->0) && (j-->0)){
            if( list1.get(i) != list2.get(j)){
                break;
            }
        }
        if((i>= list1.size()-1)||(j>= list2.size()-1)){
            return null;
        }
        return list1.get(i+1);
    }

    public static void main(String[] args) {
        Main m = new Main();
        ListNode head1=new ListNode(5);
        ListNode head2 = new ListNode(7);
        ListNode same = new ListNode(6);
        same.next = null;
        for (int i = 0; i < 4; i++) {
            ListNode temp = new ListNode(i);
            temp.next = same;
            same = temp;
        }
        head1.next = new ListNode(9);
        head1.next.next = same;
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = same;
        ListNode result = m.FindFirstCommonNode(head1,head2);
        System.out.println(result);
    }
}
