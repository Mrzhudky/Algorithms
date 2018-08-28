package com.zhudky;
import java.util.*;

/**
 *  从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,inorder,0,inorder.length);
    }
    
    private TreeNode build(int[] preOrder,int preLeft,int[] inOrder,int inLeft,int inRight){
        if(preLeft>= preOrder.length || inLeft>inRight){
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preLeft]);
        int rootIndex = inLeft;
        while( (rootIndex<inRight) && (inOrder[rootIndex] != preOrder[preLeft]) ){
            rootIndex++;
        }
        node.left = build(preOrder,preLeft+1,inOrder,inLeft,rootIndex-1);
        node.right = build(preOrder,preLeft + rootIndex-inLeft+1,inOrder,rootIndex+1,inRight);
        return node;
    }
}