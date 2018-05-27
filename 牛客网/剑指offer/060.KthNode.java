package com.company;



/***
 * 题目：
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5
 *       /\
 *      3 7
 *    /\ /\
 *  2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
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

    private int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null){
            return null;
        }
         TreeNode node = KthNode(pRoot.left,k);
        if(node != null){
            return node;
        }
        index++;
        if(index == k){
            return pRoot;
        }
        node = KthNode(pRoot.right,k);
        if(node != null){
            return node;
        }
        return null;
    }


    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode node =  m.KthNode(root,4);

        System.out.println(node.val);
    }
}
