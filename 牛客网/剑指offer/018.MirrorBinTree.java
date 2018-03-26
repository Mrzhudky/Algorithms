package com.company;

/**
 * 问题：操作给定的二叉树，将其变换为源二叉树的镜像
 * 二叉树的镜像定义：
 * 源二叉树  8          镜像二叉树  8
 *         /  \                   /  \
 *        6   10                 10  6
 *      / \  / \               / \  / \
 *     5  7 9 11              11 9 7  5
 *
 * 思路：考虑空节点的情况
 */



 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }
 }
  class Solution {
      public void Mirror(TreeNode root) {
          if(root == null){
              return;
          }
          TreeNode temp;
          temp = root.left;
          root.left = root.right;
          root.right = temp;

          Mirror(root.left);
          Mirror(root.right);

      }




}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
