package com.company;

import java.util.*;


/***
 * 题目：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Main {

    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        if(pRoot.left == null){
            return (pRoot.right == null);
        }
        if(pRoot.right == null){
            return false;
        }
        if(pRoot.left.val != pRoot.right.val){
            return false;
        }
        return isSame(pRoot.left,pRoot.right);
    }

    boolean isSame(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot == null){
            return (rightRoot == null);
        }
        if(rightRoot == null){
            return false;
        }
        if(leftRoot.val != rightRoot.val){
            return false;
        }
        return (isSame(leftRoot.left,rightRoot.right))&&(isSame(leftRoot.right,rightRoot.left));
    }






    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println( m.isSymmetrical(root));
    }
}
