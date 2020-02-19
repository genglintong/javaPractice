package com.company.easy._543;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * </p>
 * DATE 2020/2/19.
 *
 * @author genglintong.
 */
public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getTreeHeight(root);

        return max;
    }

    public int getTreeHeight(TreeNode root) {
        if (root == null) return 0;

        int leftH = getTreeHeight(root.left), rightH = getTreeHeight(root.right);

        max = Math.max(leftH + rightH, max);

        return Math.max(leftH, rightH) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createTestData("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]")));
    }
}
