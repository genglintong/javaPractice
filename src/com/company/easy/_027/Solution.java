package com.company.easy._027;

/**
 * @author genglintong
 * @package com.company.easy._027
 * @desc
 * @date 2019/8/7
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int target = 0;

        for (int i = 0 ; i < len; i++) {
            if (nums[i] != val ) {
                nums[target++] = nums[i];
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeElement(new int[]{3,2,2,3}, 3));
    }
}
