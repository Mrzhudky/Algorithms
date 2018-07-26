package com.company;

import java.util.*;


/**
 *  二叉树的层次遍历
 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

   3
  / \
 9  20
   /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]
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

      //用队列来做，通过，2ms
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int headNum = 1;
        int leafNum = 0;
        while (!queue.isEmpty()){

            root = queue.poll();
            headNum--;
            list.add(root.val);
            if(root.left != null){
                queue.offer(root.left);
                leafNum++;
            }
            if(root.right != null){
                queue.offer(root.right);
                leafNum++;
            }
            if(headNum == 0){
                headNum = leafNum;
                leafNum = 0;
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }

    //递归的思路，很巧妙,通过，1ms
    /*
        public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        set(root, 0, result);
        return result;
    }

    public void set(TreeNode treeNode, int level, List<List<Integer>> result) {
        if(treeNode==null){
            return;
        }
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(treeNode.val);
        set(treeNode.left,level+1,result);
        set(treeNode.right,level+1,result);
    }
     */

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        List<List<Integer>> result  = new Main().levelOrder(root);
        System.out.println(result);
    }


}
