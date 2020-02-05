package com.company.easy._342;

/**
 * Description
 * <p>
 *     递归和遍历方案与 326一致
 *     整数不适用于 此题
 *     4为2的n次方
 *     https://leetcode-cn.com/problems/power-of-four/
 * </p>
 * DATE 2020/2/5.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 1431655765
     * @return
     */
    public static int getNum() {
        int num = 2, t = 2;
        for (int i = 1 ; i < 16 ; i++) {
            t = t * 4;
            num += t;
        }

        return num;
    }
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0)&& ((num & 0xaaaaaaaa) == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(1));
        System.out.println((int)(0xaaaaaaaa));
    }
}
