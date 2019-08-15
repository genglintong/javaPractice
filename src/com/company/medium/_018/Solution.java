package com.company.medium._018;

import java.util.*;

/**
 * @author genglintong
 * @package com.company.medium._018
 * @desc https://leetcode-cn.com/problems/4sum/
 * @date 2019/8/15
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;

        if (len < 4) return Collections.emptyList();

        Arrays.sort(nums);
        int max = nums[len - 1];
        if (target > max * 4) return Collections.emptyList();

        return kSum(nums, target, 4, 0);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int k , int start) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int left = start , right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> twoSum = new LinkedList<>();
                    twoSum.add(nums[left]);
                    twoSum.add(nums[right]);
                    res.add(twoSum);
                    while (nums[left] == nums[++left] && left < right) ;
                    while (nums[right] == nums[--right] && left < right) ;
                }else if (sum > target) right--;
                else left++;
            }
        }else {
            int left = start , right = nums.length - k + 1 , max = nums[nums.length - 1];
            while (left < right) {
                if (nums[left] * k > target) break;
                if (nums[left] + max * (k - 1) < target) {
                    while (nums[left] == nums[++left] && left < right) ;
                    continue;
                }
                List<List<Integer>> temp = kSum(nums, target - nums[left], k - 1 , left + 1);
                for (List<Integer> t : temp) {
                    t.add(nums[left]);
                }
                res.addAll(temp);
                while (nums[left] == nums[++left] && left < right) ;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
