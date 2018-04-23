package com.company;
import java.util.*;

/**
 *题目描述
 *在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *输入描述:
 *题目保证输入的数组中没有的相同的数字
 *
 *数据范围：
 *
 *对于%50的数据,size<=10^4
 *
 *对于%75的数据,size<=10^5
 *
 *对于%100的数据,size<=2*10^5
 *
 *示例1
 *输入
 *1,2,3,4,5,6,7,0
 *输出
 *7
 *
 */

public class Main {

    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        int[] helpArray = new int[array.length];
        System.arraycopy(array,0,helpArray,0,array.length);
        long result = 0;
        result = mergeSortModify(array,helpArray,0,array.length-1);
        result = result%1000000007;
        return (int)result;
    }

    //使用了归并排序的思想
    long mergeSortModify(int[] array,int[] helpArray,int start,int end){
        if(start>end){
            return 0;
        }
        if(start == end){
            helpArray[start] = array[start];
            return 0;
        }
        int middle = (start + end)/2;
        // 这里有一个交换array和helpArray的细节需要注意
        long leftNum = mergeSortModify(helpArray,array,start,middle);
        long rigthNum = mergeSortModify(helpArray,array,middle+1,end);
        long sum = leftNum + rigthNum;
        int i = middle;
        int j =  end;
        int index = end;
        while ((i>=start)&&(j>middle)){
            if(array[i]>array[j]){
                helpArray[index--] = array[i--];
                sum += j-middle;
            }else{
                helpArray[index--] = array[j--];
            }
        }
        while (j>middle){
            helpArray[index--] = array[j--];
        }
        while (i>=start){
            helpArray[index--] = array[i--];
        }
        return sum;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] array = new int[]{1,2,3,0};
        int result = m.InversePairs(array);
        System.out.println(result);
    }
}
