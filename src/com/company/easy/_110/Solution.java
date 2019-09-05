package com.company.easy._110;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/balanced-binary-tree/
 * </p>
 * DATE 2019/9/5.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        //System.out.print(isBalanceHelper(root));
        return isBalanceHelper(root) >= 0;
    }

    public int isBalanceHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left , right, diff;

        left = isBalanceHelper(root.left);

        if (left < 0) {
            return left;
        }

        right = isBalanceHelper(root.right);
        if (right < 0) {
            return right;
        }
        diff = Math.abs(left - right);
        return (diff <= 1) ? Math.max(left ,right) + 1 : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.isBalanced(TreeNode.createTestData("[3,9,20]")));
        System.out.print(solution.isBalanced(TreeNode.createTestData("[1,2,2,3,3,null,null,4,4]")));
    }
}
