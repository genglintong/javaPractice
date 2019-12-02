package com.company.easy._189;

import com.company.util.Util;
import com.sun.tools.javac.file.SymbolArchive;

import java.util.Arrays;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/29.
 *
 * @author genglintong.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        int count = 0;
        for (int start = 0 ; count < size ; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % size;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;
                count++;
            }while (start != current);
        }
    }

    public void rotateOpti(int[] nums, int k) {
        int size = nums.length;
        k = k % size;

        reserve(nums, 0 , size - 1);
        reserve(nums , 0 , k-1);
        reserve(nums, k, size - 1);
    }

    private void reserve(int[] nums , int start, int end) {
        while (start < end) {
            Util.swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        solution.rotateOpti(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
