package com.company.easy._108;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * </p>
 * DATE 2019/9/4.
 *
 * @author genglintong.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return sortedArrayToBSTHelp(nums, 0 , len-1);
    }

    public TreeNode sortedArrayToBSTHelp(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelp(nums, start, mid-1);
        root.right = sortedArrayToBSTHelp(nums, mid+1 , end);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode.print(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
