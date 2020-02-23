package com.company.easy._653;

import com.company.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * </p>
 * DATE 2020/2/23.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        HashSet<Integer> hashSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (hashSet.contains(cur.val)) return true;

            hashSet.add(k - cur.val);

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTarget(TreeNode.createTestData("[5,3,6,2,4,7]"), 9));
    }
}
