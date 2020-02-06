package com.company.easy._367;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/valid-perfect-square/
 * </p>
 * DATE 2020/2/6.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 超时了
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        for (int i = 1 ; i <= num ; i++) {
            int z = i * i;
            if (z == num) {
                return true;
            }else if (z > num) {
                return false;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        if (num < 2) {
            return true;
        }
        int start = 1 , end = num/2;
        while (start <= end) {
            int mid = start + (end - start)/2;
            // int * int 为long
            long z = (long) mid * (long) mid;
            if (z == num) {
                return true;
            }else if (z < num) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }

    /**
     * 牛顿迭代法
     * 获取下一个近似解
     * x = (x + num/x) / 2
     * @param num
     * @return
     */
    public boolean isPerfectSquare3(int num) {
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }

        return (x * x == num);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare3(808201));
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(-1));
    }
}
