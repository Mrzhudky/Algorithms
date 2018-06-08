package com.company;

import java.util.*;


/***
 * 题目：
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Main {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        if(pNode.right == null){
            TreeLinkNode fatherNode = pNode.next;
            if(fatherNode == null){
                return null;
            }
            if(pNode == fatherNode.right){
                return FindRightFirst(fatherNode);
            }else {
                return fatherNode;
            }
        }else {
            TreeLinkNode rightFirst = pNode.right;
            while (rightFirst.left != null){
                rightFirst = rightFirst.left;
            }
            return rightFirst;
        }
    }

    TreeLinkNode FindRightFirst(TreeLinkNode root){
        TreeLinkNode fatherNode = root.next;
        if(fatherNode == null){
            return null;
        }
        if(root == fatherNode.right){
            return FindRightFirst(fatherNode);
        }else {
            return fatherNode;
        }
    }







    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
    }
}
