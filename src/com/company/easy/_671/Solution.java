package com.company.easy._671;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * </p>
 * DATE 2020/2/23.
 *
 * @author genglintong.
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return findMin(root, root.val);
    }

    public int findMin(TreeNode root, int k) {
        if (root == null) return -1;

        if (root.val != k) return root.val;

        int l = findMin(root.left, k), r = findMin(root.right, k), res = -1;

        if (l != -1) res = l;
        if (r != -1) {
            if (res != -1) {
                res = Integer.min(res, r);
            }else {
                res = r;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSecondMinimumValue(TreeNode.createTestData("[2,2,5,null,null,5,7]")));
    }
}
