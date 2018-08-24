package com.zhudky;
import java.util.*;

/**
 *  二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {                
        List<List<Integer>> re = new ArrayList<>();
        if(root == null){
            return re;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(root);
        while(!leftStack.isEmpty() || !rightStack.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            while(!leftStack.isEmpty()){
                root = leftStack.pop();
                if(root.left != null) {
                    rightStack.push(root.left);
                }
                if(root.right != null) {
                    rightStack.push(root.right);
                }
                list.add(root.val);
            }
            if(list.size()>0){
                re.add(list);
                list = null;
                list = new ArrayList<>();
            }
            while(!rightStack.isEmpty()){
                root = rightStack.pop();
                
                if(root.right != null){
                    leftStack.push(root.right);
                }
                if(root.left != null){
                    leftStack.push(root.left);
                }
                list.add(root.val);
            }
            if(list.size()>0){
                re.add(list);
            }
        }
        return re;
    }
}