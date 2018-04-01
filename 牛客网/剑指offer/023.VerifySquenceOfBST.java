/**
 *问题：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *思路: 递归，从左边起至第一个不小于根节点的数为止皆为左子树，若右子树不为空，判断其是否全大于根节点
 */

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null){
            return false;
        }
        int len = sequence.length;
        if(len == 0){
            return false;
        }
        int leftLen = 0;
        while((leftLen<len)&&(sequence[leftLen]<sequence[len-1])){
            leftLen++;
        }
        for(int i=leftLen;i<len-1;i++){
            if(sequence[i]<sequence[len-1]){
                return false;
            }
        }
        boolean leftVerify = true;
        if(leftLen>0){
            int[] left = new int[leftLen];
            System.arraycopy(sequence,0,left,0,leftLen);
            leftVerify = VerifySquenceOfBST(left);
        }
        boolean rightVerify = true;
        if(leftLen < len-1){
            int[] right = new int[len-leftLen-1];
            System.arraycopy(sequence,leftLen,right,0,len-leftLen-1);
            rightVerify = VerifySquenceOfBST(right);
        }
        return leftVerify&&rightVerify;
    }
}