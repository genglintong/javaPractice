package com.company.medium._309;

/**
 * @author genglintong
 * @package com.company.medium._309
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @date 2019/8/22
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int num = prices.length;
        if (num <= 0) return 0;

        int[] sell = new int[num];
        int[] buy = new int[num];
        int[] cool = new int[num];

        buy[0] = -prices[0];

        for (int i = 1 ; i < num ; i++) {
            sell[i] =  Math.max(sell[i-1], buy[i-1] + prices[i]);
            buy[i] = Math.max(buy[i-1], cool[i-1] - prices[i]);
            cool[i] =  Math.max(cool[i-1], Math.max(buy[i-1], sell[i-1]));

            //System.out.println(sell[i] + " " + buy[i] + " " + cool[i]);
        }
        return sell[num - 1];
    }

    public int maxProfitOpti(int[] prices) {
        int num = prices.length;
        if (num <= 0) return 0;

        int sell = 0;
        int buy = Integer.MIN_VALUE;
        int sellPre = 0;

        for (int i = 0; i < num ; i++) {
            int tempSell = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy , sellPre - prices[i]);
            sellPre = tempSell;
        }

        return sell;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfitOpti(new int[]{1,2,4}));
        System.out.println(solution.maxProfitOpti(new int[]{1,2,3,0,2}));
    }
}
