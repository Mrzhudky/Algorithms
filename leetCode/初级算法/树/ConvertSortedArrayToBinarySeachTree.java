package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.*;


/**
 *  将有序数组转换为二叉搜索树
 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

        0
      / \
    -3   9
   /   /
 -10  5
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }
        int len = nums.length-1;
        return setValue(nums,0,len);
    }
    private TreeNode setValue(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        int middle = (start+end)%2 + (start+end)>>1 ;
        TreeNode root =  new TreeNode(nums[middle]);
        root.left = setValue(nums,start,middle-1);
        root.right = setValue(nums,middle+1,end);
        return root;
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        int[] nums = new int[]{0,1,2,3,4,5};
        TreeNode root = new Main().sortedArrayToBST(nums);
        System.out.println(root.val);
    }


}
