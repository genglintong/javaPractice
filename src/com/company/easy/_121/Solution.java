package com.company.easy._121;

/**
 * @author genglintong
 * @package com.company.easy._121
 * @desc https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @date 2019/8/21
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE, num = prices.length;

        for (int i = 0 ; i < num ; i++) {
            min = (min < prices[i]) ? min : prices[i];
            max = (max > (prices[i] - min)) ? max : (prices[i] - min);
            //System.out.println(min + " " + max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{1,4,2}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}
