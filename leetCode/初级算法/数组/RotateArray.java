package com.company;

/**
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

 示例 1:

 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]
 示例 2:

 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]
 说明:

 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * 思路：
 * 以示例1为例，将数组分为左右两半，[1,2,3][4,5,6,7]
 * 分别旋转:[3,2,1][7,6,5,4]
 * 在整体旋转数组：[4,5,6,7,1,2,3]
 */


public class Main {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<1){
            return;
        }
        int middle =nums.length - k%nums.length-1;
        reverse(nums,0,middle);
        reverse(nums,middle+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    private void reverse(int[] nums,int left,int right){
        while (left<right){
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--]=temp;
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1,2,3,4,5,6};
        main.rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }


}
