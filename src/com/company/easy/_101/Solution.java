package com.company.easy._101;

import com.company.util.TreeNode;

/**
 * @author genglintong
 * @package com.company.easy._101
 * @desc https://leetcode-cn.com/problems/symmetric-tree/
 * @date 2019/8/28
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelp(root.right, root.left);
    }

    public boolean isSymmetricHelp(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetricHelp(root1.left , root2.right) && isSymmetricHelp(root1.right, root2.left);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
    }
}
