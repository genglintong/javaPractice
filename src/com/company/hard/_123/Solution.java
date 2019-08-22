package com.company.hard._123;

/**
 * @author genglintong
 * @package com.company.hard._123
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * @date 2019/8/22
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int num = prices.length;
        int[] shell = {0,0};
        int[] buy = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int k = 2;

        for (int i = 0 ; i < num ; i++) {
            for (int j = 0; j < k ; j++) {
                int t = 0;
                if (j == 1) {
                    t = shell[0];
                }
                shell[j] = Math.max(shell[j], buy[j] + prices[i]);
                buy[j]  = Math.max(buy[j], t - prices[i]);
            }
        }

        return shell[1];
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
