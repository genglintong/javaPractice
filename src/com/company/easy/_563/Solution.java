package com.company.easy._563;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-tree-tilt/
 * </p>
 * DATE 2020/2/20.
 *
 * @author genglintong.
 */
public class Solution {
    private int num = 0;

    public int findTilt(TreeNode root) {
        inNode(root);

        return num;
    }

    public int inNode(TreeNode root) {
        if (root == null) return 0;

        int left = inNode(root.left);
        int right = inNode(root.right);

        num+= Math.abs(left - right);

        return left + right + root.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTilt(TreeNode.createTestData("[1,2,3]")));
    }
}
