package com.company;

import java.util.*;


/***
 * 题目：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
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

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null){
            return result;
        }
        ArrayList<Integer> line = new ArrayList<>(1);
        ArrayList<Integer> oneLine;
        line.add(pRoot.val);
        oneLine = line;

        Queue<TreeNode> oneNodeQueue = new LinkedList<>();
        Queue<TreeNode> otherNodeQueue = new LinkedList<>();
        if(pRoot.left != null) oneNodeQueue.add(pRoot.left);
        if(pRoot.right != null) oneNodeQueue.add(pRoot.right);


        while (oneLine.size() != 0){
            result.add(oneLine);
            oneLine = GetNodeStrack(otherNodeQueue,oneNodeQueue);
            Queue<TreeNode> temp = oneNodeQueue;
            oneNodeQueue = otherNodeQueue;
            otherNodeQueue = temp;
        }

        return result;


    }

    ArrayList<Integer> GetNodeStrack(Queue<TreeNode> nodeQueue,Queue<TreeNode> lastNodeQueue){

        ArrayList<Integer> line = new ArrayList<>();
        if(lastNodeQueue == null || lastNodeQueue.isEmpty()) return line;

        while (!lastNodeQueue.isEmpty()){
            TreeNode temp = lastNodeQueue.poll();
            if(temp.left != null)  nodeQueue.add(temp.left);
            if(temp.right != null)  nodeQueue.add(temp.right);
            line.add(temp.val);
        }
        return line;
    }







    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println( m.Print(root));
    }
}
