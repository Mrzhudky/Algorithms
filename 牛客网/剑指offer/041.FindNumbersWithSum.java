package com.company;
import java.util.ArrayList;
/***
 * 题目：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

public class Main {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0){
            return result;
        }
        int product = sum*sum;
        int high = array.length -1;
        int low = 0;
        while (low<=high){
            int temp = array[low] + array[high];
            if(temp > sum){
                high--;
            }else if(temp < sum){
                low++;
            }else{
                int tempPro = array[low]*array[high];
                if(product > tempPro){
                    if(result.size()>0){
                        result.set(0,array[low]);
                        result.set(1,array[high]);
                    }else {
                        result.add(array[low]);
                        result.add(array[high]);
                    }
                    product = tempPro;
                }
                high--;low++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> result = m.FindNumbersWithSum(array,9);
        System.out.println(result.get(0));
        System.out.println(result.get(1));

    }
}
