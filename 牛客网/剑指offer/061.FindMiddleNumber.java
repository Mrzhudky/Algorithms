package com.company;


import java.util.ArrayList;
import java.util.Arrays;

/***
 * 题目：
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */

public class Main {

    private int elementNum = 0;
    private int[] numbers = new int[16];

    public void Insert(Integer num) {
        elementNum += 1;
        if(elementNum>numbers.length){
            grow();
        }
        int i = elementNum-2;
        for (; i >= 0; i--) {
            if(numbers[i]>num){
                numbers[i+1] = numbers[i];
            }else {
                numbers[i+1] = num;
                break;
            }
        }
        if(i == -1){
            numbers[0] = num;
        }
    }

    public Double GetMedian() {
        if(elementNum == 0){
            return 0.0d;
        }
        if(elementNum%2 == 1){
            int index = elementNum >> 1;
            double r = numbers[index];
            return r;
        }else{
            int index = elementNum >> 1;
            double r = (numbers[index-1]+numbers[index])/2.0d;
            return r;
        }
    }

    /***
     * 参考ArrayList的源码实现数组扩容
     */
    void grow(){
        int oldCapacity  = numbers.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        numbers = Arrays.copyOf(numbers,newCapacity);
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        for (int i = 0; i < 20; i++) {
            m.Insert(20-i);
            System.out.print(m.GetMedian() + " ");
        }
    }
}
