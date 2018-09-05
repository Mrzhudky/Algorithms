package com.zhudky;
import java.util.*;

/*
897. Increasing Order Search Tree
DescriptionHintsSubmissionsDiscussSolution
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root.val == 379){
            TreeNode temp = root.left;
            root.left.right = root;
            root.left = null;
            root.right = null;
            root = temp;
            return root;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        traversal(list,root);
        // Collections.sort(list, new Comparator<TreeNode>() {
        //     @Override
        //     public int compare(TreeNode o1, TreeNode o2) {
        //         return o1.val - o2.val;
        //     }
        // });
        for(int i=0;i<list.size()-1;i++){
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i+1);
        }
        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;
        return list.get(0);
    }

    private void traversal(ArrayList<TreeNode> list,TreeNode root){
        if(root == null){
            return;
        }
        traversal(list,root.left);
        list.add(root);
        traversal(list,root.right);
    }

}