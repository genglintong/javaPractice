package com.company.easy._001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * hashMap VS hashTable
 * 均使用 hash表来存储键值对
 * 扩容 hashMap 使用2^n 寻址方便  hashTable 使用素数 取模hash更加均匀
 */

/**
 * @author genglintong
 * @package com.company.easy._001
 * @desc    计算两数之和 https://leetcode-cn.com/problems/two-sum/
 * @date 2019/8/7
 */
public class Solution {

    // 计算两数之和 https://leetcode-cn.com/problems/two-sum/
    public int[] twoSum(int[] nums, int integer) {
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i= 0 ; i < len ; i ++) {
            final Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[] { value, i};
            }
            map.put(integer - nums[i] , i);
        }

        return null;
    }

    // 主程序 入口
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(solution.twoSum(nums, target)));

    }
}
