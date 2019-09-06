package com.company.easy._111;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * </p>
 * DATE 2019/9/6.
 *
 * @author genglintong.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return minDepth(root.left) + minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDepth(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}
