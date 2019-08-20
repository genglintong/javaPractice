package com.company.medium._031;

import com.company.util.Util;

import java.util.Arrays;

/**
 * @author genglintong
 * @package com.company.medium._031
 * @desc https://leetcode-cn.com/problems/next-permutation/
 * 算法：STL https://blog.csdn.net/c18219227162/article/details/50301513
 * @date 2019/8/19
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;
        int i = len - 2;
        boolean judge = false;

        /**
         * 尾部 查找 第一个非升 的位置
         */
        for ( ; i >= 0 ; i--) {
            if (nums[i] < nums[i+1]) {
                judge = true;
                break;
            }
        }

        if (judge) {
            // 找到位置 - 逆序找到 大于改位置的 最小元素位置 (上述已经确定有序，即倒序查找即可)
            int j = len - 1;
            while (nums[j] <= nums[i]) j--;

            // 找到位置 交换元素
            Util.swap(nums, i++ , j);
        }else {
            // 未找到位置 全部逆序 找最小
            i = 0;
        }

        // 首尾交换 逆序
        int j = len - 1;
        while (i < j) {
            Util.swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
