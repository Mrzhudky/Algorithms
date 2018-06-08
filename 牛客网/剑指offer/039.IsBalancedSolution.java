package com.company;
import java.util.*;

/**
 *题目描述
 *输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 */

public class Main {
	public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        if(Math.abs(leftDepth-rightDepth) > 1){
            return false;
        }
        return true;
    }
       public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        
        return leftDepth>rightDepth ? (leftDepth+1) : (rightDepth+1);
    }

    public static void main(String[] args) {
		
    }
}
