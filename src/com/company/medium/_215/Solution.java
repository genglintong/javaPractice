package com.company.medium._215;

import com.company.util.Util;

import java.util.Arrays;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/11.
 *
 * @author genglintong.
 */
public class Solution {

    /**
     * 第K个最大数字
     *
     * 1. 快排思路
     * 2. 堆排序 - 使用此方法 为了联系堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        crateMinHeap(nums, k);

        System.out.println(Arrays.toString(nums));

        for (int i = k; i < nums.length; i++) {
            MinHeapHelper(nums, k, i);
            System.out.println(Arrays.toString(nums));
        }

        return nums[0];
    }

    private void crateMinHeap(int[] nums, int k) {
        for (int i = 0 ; i < k ; i++) {
            int cur = i;
            int p;
            while (cur > 0) {
                p = getParent(k, cur);
                if (nums[p] > nums[cur]) {
                    swap(nums, p, cur);
                    System.out.println(p + "  " + cur);
                }else {
                    break;
                }
                cur = p;
            }
        }
    }

    private void MinHeapHelper(int[] nums, int k, int n) {
        int min = nums[0];
        /**
         * 值小于最小堆最小值
         */
        if (min >= nums[n]) {
            return;
        }

        swap(nums, 0, n);
        int cur = 0;
        while (cur < k) {
            int right = getRight(k, cur);
            int left = getLeft(k ,cur);

            int rightNum = Integer.MAX_VALUE, leftNum = Integer.MAX_VALUE;
            if (right >= k && left >= k) {
                break;
            }
            if (right < k) {
                rightNum = nums[right];
            }
            if (left < k) {
                leftNum = nums[left];
            }

            // 小于 孩子节点
            if (nums[cur] <= Math.min(rightNum, leftNum)) {
                break;
            }

            if (rightNum < leftNum) {
                swap(nums, right, cur);
                cur = right;
            }else {
                swap(nums, left, cur);
                cur = left;
            }
        }
    }

    private int getParent(int size , int n) {
        return (n - 1) / 2;
    }

    private int getRight(int size, int n) {
        return 2 * n + 2;
    }

    private int getLeft(int size, int n) {
        return 2 * n + 1;
    }

    private void swap(int[] nums, int a , int b) {
        Util.swap(nums, a, b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findKthLargest(new int[] {-1,2,0}, 2));
    }
}
