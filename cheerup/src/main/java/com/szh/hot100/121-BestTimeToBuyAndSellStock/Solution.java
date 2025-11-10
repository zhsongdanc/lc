package com.szh.hot100;

/**
 * 121. Best Time to Buy and Sell Stock (买卖股票的最佳时机)
 * 
 * 题目链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 
 * 解法：一次遍历
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class Solution {
    
    /**
     * 最优解：一次遍历
     * 记录最低价格，计算每天卖出能获得的最大利润
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}

