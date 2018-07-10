package com.company;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2]
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：
 * 使用i，j两个指针，一个记录读取原数组的位置，一个记录新数组的位置，
 */


public class Main {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int j=0;
        for(int i=1;i<len;i++){
            if(nums[i]==nums[j]){ //与前一个数相同
                continue;
            }else{
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = main.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] +" ");
        }

    }


}
