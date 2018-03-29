/**
 *问题：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 *思路: 构建一个节点的队列，现将根节点入队列，然后每次出队列一个节点，将该节点的左节点，右节点 入队列，这样保证了出队列是节点顺序为从上到下，从左到右
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

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        ArrayList<Integer> dataList = new ArrayList<>();
        
        if(root == null){
            return dataList;
        }
        nodeList.add(root);
        
        for(int index = 0;index<nodeList.size();index++){
            dataList.add(nodeList.get(index).val);
            if(nodeList.get(index).left != null){
                nodeList.add(nodeList.get(index).left);
            }
            if(nodeList.get(index).right != null){
                nodeList.add(nodeList.get(index).right);
            }
        }
        return dataList;
    }
}