package com.company.util;

/**
 * @author genglintong
 * @package com.company.util
 * @desc
 * @date 2019/8/7
 */
public class Util {
    // 交换数组中 元素
    public static void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
