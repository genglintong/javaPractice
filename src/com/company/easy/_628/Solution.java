package com.company.easy._628;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * </p>
 * DATE 2020/2/22.
 *
 * @author genglintong.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = 0 , min2 = 0, max1= Integer.MIN_VALUE , max2= Integer.MIN_VALUE, max3= Integer.MIN_VALUE, res;

        if (nums.length < 3) return 0;

        for (int n : nums) {
            if (n < 0 && min1 > n) {
                min1 = Integer.max(min2, n);
                min2 = Integer.min(min2, n);
            }

            if (n > max1) {
                if (n >= max2) {
                    max1 = max2;
                    max2 = Integer.min(max3, n);
                    max3 = Integer.max(max3, n);
                }else{
                    max1 = n;
                }
            }
        }

        res = Math.max(min1 * min2, max1 * max2);

        return res*max3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(new int[]{1,2,3}));
        System.out.println(solution.maximumProduct(new int[]{-1,-2,-3}));
    }
}
