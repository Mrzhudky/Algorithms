package com.company;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along
 * the shortest path from the root node down
 * to the nearest leaf node.
 *
 * 思路：
 * 递归，节点为空则返回0，若左右节点有一个为空则返回另一个节点的深度。
 */

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main {
    public int run(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftNum = run(root.left);
        int rightNum = run(root.right);
        if((leftNum == 0)&&(rightNum==0)){
            return 1;
        }else if(leftNum==0){
            return rightNum+1;
        }else if(rightNum == 0){
            return leftNum+1;
        }else {
            return Math.min(leftNum+1,rightNum+1);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        int depth = main.run(node);
        System.out.println(depth);
    }


}
