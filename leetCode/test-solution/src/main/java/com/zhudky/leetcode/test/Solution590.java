package com.zhudky.leetcode.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};



public class Solution590 {

    List<Integer> cacheList = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return cacheList;

    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }


        if (root.children != null && !root.children.isEmpty()) {
            for (Node node : root.children) {
                dfs(node);
            }
        }

        cacheList.add(root.val);

    }
}
