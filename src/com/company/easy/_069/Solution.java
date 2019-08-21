package com.company.easy._069;

/**
 * @author genglintong
 * @package com.company.easy._069
 * @desc https://leetcode-cn.com/problems/sqrtx/
 * @date 2019/8/21
 */
public class Solution {
    public int mySqrt(int x) {
        long i = 1;
        while (i * i <= x) {
            i++;
        }
        return (int) i - 1;
    }

    public int mySqrtOpti1(int x) {
        long i = 1, j = x/2 + 1;

        while (i <= j) {
            long mid = (i + j)/2;
            long target = mid * mid;
            if (target == x) {
                return (int) mid;
            }else if (target > x) {
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }

        return (int)j;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(0));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrtOpti1(2147395600));
    }
}
