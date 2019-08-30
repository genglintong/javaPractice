package com.company.medium._050;

/**
 * @author genglintong
 * @package com.company.medium._050
 * @desc https://leetcode-cn.com/problems/powx-n/
 * @date 2019/8/30
 */
public class Solution {
    private double myPowHelper(double x , long n) {
        double res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res *= x;
            }

            n = n >> 1;
            x *= x;
            //System.out.println(n);
        }

        //System.out.println(res);
        return res;
    }

    public double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }else if (n > 0) {
            return myPowHelper(x,n);
        }else {
            return 1/myPowHelper(x,-n);
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        // 测试用例 异常
        System.out.println(solution.myPow(2, -2147483648));
        System.out.println(solution.myPow(2.1,3));
        System.out.println(solution.myPow(2,-2));
        System.out.println(solution.myPow(2,0));
    }

}
