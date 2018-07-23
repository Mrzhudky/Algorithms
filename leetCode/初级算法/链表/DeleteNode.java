package com.company;

import java.util.*;


/**
 *  删除链表中的节点
 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 4 -> 5 -> 1 -> 9
 示例 1:

 输入: head = [4,5,1,9], node = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:

 输入: head = [4,5,1,9], node = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 说明:

 链表至少包含两个节点。
 链表中所有节点的值都是唯一的。
 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 不要从你的函数中返回任何结果。
 *
 * 思路：
 * 这个题乍一看给的题头，立马呆住了，这玩意怎么做啊。就给个节点，没有前驱，那我怎么连？没有链表，我怎么查？？？
 但是巧妙的地方也在这里。
 可以把要删除的节点，用该节点的后面节点进行覆盖，然后删掉后面那个节点就好了。
 举个栗子：ABCDE，删除C，我们就先用D占C的位置，变成ABDDE，然后把后面那个D删除，就可以得到ABDE~
 思路很巧妙。值得借鉴！
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

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }


}
