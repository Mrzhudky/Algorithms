package com.company;
import java.util.*;

/**
 *题目描述
 *统计一个数字在排序数组中出现的次数。
 *
 * 思路;
 * 一开始的想法是二分法找到k然后向前向后找k，提交后发现超时
 * 改进: 用二分法的思想直接找最左和左右的k的位置，然后根据差值计算k的个数
 * 另外，题目中说排序数组，没说升序还是降序，所有考虑了两种情况，但是答案好像只考虑了升序的情况，可能是想多了吧
 */

public class Main {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int lower = 0;
        int high = array.length -1;
        int upFlag = 1;
        int middle = (lower + high)>>1;

        if(array[lower]>array[high]){
            lower = high;
            high = 0;
            upFlag = -1;
        }
        int startIndex =-1;

        while ((high-lower)*upFlag >=0 ){
            if(array[middle]>k){
                high = middle - upFlag;
            }else if(array[middle] <k){
                lower = middle + upFlag;
            }else if(middle == 0 || middle == (array.length -1)){
                startIndex = middle;
                break;
            }else if(array[middle-upFlag] != k){
                startIndex = middle;
                break;
            }else{
                high =middle - upFlag;
            }
            middle = (lower + high)>>1;
        }

        if(startIndex < 0){
            return 0;
        }

        lower = startIndex;
        if(upFlag == 1){
            high = array.length -1;
        }else{
            high = 0;
        }
        middle = (lower+ high)>>1;
        int endIndex =-1;
        while ((high-lower)*upFlag >=0){
            if(array[middle]>k){
                high = middle - upFlag;
            }else if(array[middle] <k){
                lower = middle + upFlag;
            }else if(middle == 0 || middle == (array.length -1)){
                endIndex = middle;
                break;
            }else if(array[middle+upFlag] != k){
                endIndex = middle;
                break;
            }else{
                lower = middle + upFlag;
            }
            middle = (lower + high)>>1;
        }

        int sum = (endIndex - startIndex)*upFlag +1;

        return sum;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] array = new int[]{5,4,3,3,3,3};
        int[] array2 = new int[]{1,3,3,3,3,4,5};
        int result = m.GetNumberOfK(array2,2);
        System.out.println(result);
    }
}
