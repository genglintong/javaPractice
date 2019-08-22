package com.company.hard._188;

/**
 * @author genglintong
 * @package com.company.hard._188
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @date 2019/8/22
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int num = prices.length;
        if (k < 1 || num <= 1) return 0;

        if (k > num/2) {
            k = num/2;
        }

        int[] shell = new int[k];
        int[] buy = new int[k];

        for (int i = 0 ; i < k ; i++) {
            shell[i] = 0;
            buy[i] = -prices[0];
        }

        for (int i = 0 ; i < num ; i++) {
            for (int j = k - 1; j >= 0 ; j--) {
                int t = 0;
                if (j > 0) {
                    t = shell[j-1];
                }
                shell[j] = Math.max(shell[j], buy[j] + prices[i]);
                buy[j]  = Math.max(buy[j], t - prices[i]);
            }
        }

        return shell[k - 1];
    }

    int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(4,new int[]{1,2,4,2,5,7,2,4,9,0}));
        System.out.println(solution.maxProfit_k_any(4,new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}
