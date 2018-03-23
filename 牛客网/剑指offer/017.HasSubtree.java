package com.company;

/**
 * 问题：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 == null || root2== null){
            return false;
        }
        if(root1.val == root2.val){
            result = IsSameNode(root1,root2);
        }
        if(result == false){
            result = HasSubtree(root1.left,root2);
        }
        if(result == false){
            result = HasSubtree(root1.right,root2);
        }
        return result;

    }
    public boolean IsSameNode(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1  == null){
            return false;
        }
        if(root1.val == root2.val){
            return (IsSameNode(root1.left,root2.left) && IsSameNode(root1.right,root2.right));
        }
        return false;
    }



}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
