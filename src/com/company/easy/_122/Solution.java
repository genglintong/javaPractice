package com.company.easy._122;

/**
 * @author genglintong
 * @package com.company.easy._122
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @date 2019/8/22
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0) return 0;

        int[] dp = new int[len];

        dp[0] = 0;

        for (int i = 1 ; i < len ; i++) {
            int j = i, d;
            while (j > 0 && prices[i] < prices[--j]) ;

            d = prices[i] - prices[j];
            d = (d > 0) ? d : 0;

            dp[i] = Math.max(dp[i-1] , dp[j] + d);

            //System.out.println(i + " " + j + " " + d + " " + dp[i]);
        }
        return dp[len-1];
    }

    public int maxProfitOpti(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0 ; i < len - 1 ; i++) {
            if (prices[i] < prices[i+1]) {
                max += prices[i+1] - prices[i];
            }
        }

        return max;
    }

    public int maxProfitOpti2(int[] prices)
    {
        int num = prices.length;
        if (num <= 0) return 0;

        int sell = 0 , buy = Integer.MIN_VALUE;
        for (int i = 0 ; i < num ; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }

        return sell;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfitOpti2(new int[]{7,6,4,3,1}));
    }
}
