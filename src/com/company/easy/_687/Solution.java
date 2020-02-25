package com.company.easy._687;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/longest-univalue-path/
 * </p>
 * DATE 2020/2/24.
 *
 * @author genglintong.
 */
public class Solution {
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        getLong(root);

        return ans;
    }

    public int getLong(TreeNode root) {
        if (root == null) return 0;

        int left = getLong(root.left), right = getLong(root.right);
        int aLeft = 0, aRight = 0;

        if (root.left != null && root.left.val == root.val) {
            aLeft = left + 1;
        }

        if (root.right != null && root.right.val == root.val) {
            aRight = right + 1;
        }

        ans = Math.max(aLeft + aRight , ans);

        return Math.max(aLeft, aRight);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(TreeNode.createTestData("[5,4,5,1,1,null,5]")));
        System.out.println(
                solution.longestUnivaluePath(TreeNode.createTestData("[1,4,5,4,4,null,5]")));
    }
}
