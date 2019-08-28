package com.company.easy._100;

import com.company.util.TreeNode;

/**
 * @author genglintong
 * @package com.company.easy._100
 * @desc https://leetcode-cn.com/problems/same-tree/
 * @date 2019/8/28
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.isSameTree(TreeNode.createTestData("[]"), TreeNode.createTestData("[]")));
    }
}
