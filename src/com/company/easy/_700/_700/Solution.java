package com.company.easy._700._700;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * </p>
 * DATE 2020/2/25.
 *
 * @author genglintong.
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else if (root.val < val) {
            return searchBST(root.right, val);
        }else {
            return searchBST(root.left, val);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode.print(solution.searchBST(TreeNode.createTestData("[4,2,7,1,3,null,null]"),2));
    }
}
