package com.company;
/**
 * 问题：
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 *
 * Solution:
 *
 * @author zhudky
 * @version v1.0.0 2018/4/1
 *
 */

import java.util.ArrayList;

  class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
         this.val = val;
     }
 }

class Solution {
    private ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    private ArrayList<Integer> onePath = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return allPath;
        }
        if(root.val > target){
            return allPath;
        }
        if(root.val == target){
            onePath.add(root.val);
            allPath.add(onePath);
        }else{
            FindPath(root,target,0);
        }
        return allPath;
    }

    public void FindPath(TreeNode root,int target,int currentSum){
        if(root == null) return;
        onePath.add(root.val);

        currentSum += root.val;

        if(currentSum == target && root.left == null && root.right == null){
            allPath.add(new ArrayList<Integer>(onePath));
        }
        FindPath(root.left,target,currentSum);
        FindPath(root.right,target,currentSum);

        onePath.remove(onePath.size()-1);
    }
}
public class Main {
    public static void main(String[] args) {
		
    }
}
