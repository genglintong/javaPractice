package com.company.easy._669;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 * </p>
 * DATE 2020/2/23.
 *
 * @author genglintong.
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, root.val);
        root.right = trimBST(root.right, root.val, R);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode.print(solution.trimBST(TreeNode.createTestData("[1,0,2]"), 1,2));
    }
}
