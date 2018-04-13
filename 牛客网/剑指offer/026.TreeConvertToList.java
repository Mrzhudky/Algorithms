package com.company;
/**
 * 题目：
 *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pNodeList = null;

        pNodeList = ConvertNode(pRootOfTree,pNodeList);
        while ((pNodeList != null)&&(pNodeList.left != null)){
            pNodeList = pNodeList.left;
        }
        return pNodeList;
    }

    private TreeNode ConvertNode(TreeNode root,TreeNode pLastNode){
        if(root == null){
            return pLastNode;
        }
        TreeNode pCurrent = root;
        if(pCurrent.left != null){
            pLastNode = ConvertNode(pCurrent.left,pLastNode);
        }
        pCurrent.left = pLastNode;
        if(pLastNode != null){
            pLastNode.right = pCurrent;
        }
        pLastNode = pCurrent;

        if(pCurrent.right != null){
            pLastNode =ConvertNode(pCurrent.right,pLastNode);
        }
        return pLastNode;
    }
}


