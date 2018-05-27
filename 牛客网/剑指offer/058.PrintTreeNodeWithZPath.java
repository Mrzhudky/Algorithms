package com.company;

import java.util.*;


/***
 * 题目：
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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

        Stack<TreeNode> oneNodeStack = new Stack<>();
        Stack<TreeNode> otherNodeStack = new Stack<>();
        if(pRoot.left != null) oneNodeStack.push(pRoot.left);
        if(pRoot.right != null) oneNodeStack.push(pRoot.right);


        boolean startFromLeft = true;
        while (oneLine.size() != 0){
            result.add(oneLine);
            if(startFromLeft){
                oneLine = GetNodeStrack(otherNodeStack,oneNodeStack,false);
                startFromLeft = false;
            }else {
                oneLine = GetNodeStrack(oneNodeStack,otherNodeStack,true);
                startFromLeft = true;
            }
        }

        return result;


    }

    ArrayList<Integer> GetNodeStrack(Stack<TreeNode> nodeStack,Stack<TreeNode> lastNodeStack,boolean startFromLeft){

        ArrayList<Integer> line = new ArrayList<>();
        if(lastNodeStack == null || lastNodeStack.empty()) return line;

        while (!lastNodeStack.isEmpty()){
            TreeNode temp = lastNodeStack.pop();
            if(startFromLeft){
                if(temp.left != null)  nodeStack.push(temp.left);
                if(temp.right != null)  nodeStack.push(temp.right);
            }else {
                if(temp.right != null)  nodeStack.push(temp.right);
                if(temp.left != null)  nodeStack.push(temp.left);
            }
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
