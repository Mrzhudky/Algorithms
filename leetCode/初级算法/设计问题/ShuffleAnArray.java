package com.zhudky;
import java.util.*;

public class ShuffleAnArray {

    private int[] nums =null;
    private Random random = null;
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = Arrays.copyOf(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(+1);
            swap(temp,i,j);
        }
        return temp;
    }

    private void swap(int[] a,int i,int j){
        if(a == null || i==j){
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */