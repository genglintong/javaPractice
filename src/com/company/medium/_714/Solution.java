package com.company.medium._714;

/**
 * @author genglintong
 * @package com.company.medium._714
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @date 2019/8/22
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 0) return 0;

        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE + fee;

        for (int i = 0 ; i < len ; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0 , dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1 , temp - prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
