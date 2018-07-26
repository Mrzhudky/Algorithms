package com.company;

import java.util.*;


/**
 *  对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 思路：
 * 递归
 */

public class Main {

    public boolean isSymmetric(TreeNode root) {
    if(root == null){
        return true;
    }
    return isSame(root.left,root.right);
    }
    private boolean isSame(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        if(!isSame(left.left,right.right)){
            return false;
        }
        if(!isSame(left.right,right.left)){
            return false;
        }
        return true;
        
    }
	
	
    public static void main(String[] args) {


    }


}
