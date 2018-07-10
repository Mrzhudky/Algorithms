package com.company;

/**
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 示例 2:

 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 示例 3:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 思路：
 * 找出连续递增的子序列，将每个子序列的最大差值求和，
 * 如7,1,5,3,6,4 中有【1，5】【3，6】两个递增子序列，
 * 所以其收益为 （5-1）+(6-3）=7
 */


public class Main {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <2){
            return 0;
        }
        int buyPrice = 0;
        int profit = 0;
        int i=1;
        while(i<prices.length){
            if(prices[i]>prices[i-1]){
                buyPrice = prices[i-1];
                while((++i<prices.length)&&(prices[i]>prices[i-1]));
                profit += prices[i-1]-buyPrice;
            }
            i++;
        }
        return profit;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{7};
        int len = main.maxProfit(nums);
        System.out.println(len);

    }


}
