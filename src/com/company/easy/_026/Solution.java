package com.company.easy._026;

import com.sun.tools.javac.file.SymbolArchive;

/**
 * @author genglintong
 * @package com.company.easy._026
 * @desc
 * @date 2019/8/7
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int t = 0, len = nums.length, n = 1;

        if (len <= 0 ) {
            return 0;
        }
        t = nums[0];
        for (int i = 1 ; i < len ; i++) {
            // 和上一个 非重复元素重复
            if (nums[i] != t) {
                t = nums[i];
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
