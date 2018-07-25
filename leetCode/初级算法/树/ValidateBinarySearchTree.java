package com.company;

import java.util.*;


/**
 *  验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 思路：
 *
 */


/**
 * Definition for a binary tree node.
 */
  class TreeNode {
      int val;
      TreeNode left = null;
      TreeNode right = null;
      TreeNode(int x) { val = x; }
  }



public class Main {

//参考左神的《程序员代码面试指南》，使用Morris中序遍历方法，空间上O(1);通过4ms，战胜31.44%的提交
    /*
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean res = true;
        TreeNode lastNode = null;
        TreeNode cur1 = root,cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right!=cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }

            }
            if(lastNode != null && lastNode.val>=cur1.val){
                res = false;
            }
            lastNode = cur1;
            cur1 = cur1.right;
        }
        return res;
    }
*/
    //非递归中序遍历思路，用空间换时间 ，通过3ms，战胜42.73%的提交
/*
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root!=null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.print(root.val + " ");
                if(lastNode != null && lastNode.val >= root.val){
                    return false;
                }
                lastNode = root;
                root = root.right;
            }

        }
        return true;
    }
*/
//递归中序遍历,通过，1ms，战胜了74.62%的提交
    private TreeNode lastNode = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if((lastNode != null) && (lastNode.val>=root.val)){
            return false;
        }else{
            lastNode = root;
        }
        System.out.print(root.val + " ");
        if(! isValidBST(root.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        boolean re = new Main().isValidBST(root);
        System.out.println(re);
    }


}
