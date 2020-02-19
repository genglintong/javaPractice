package com.company.easy._538;

import com.company.util.TreeNode;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * </p>
 * DATE 2020/2/17.
 *
 * @author genglintong.
 */
public class Solution {
    public int num = 0;
    private Stack<TreeNode> stack = new Stack<>();
    /**
     * 后序遍历
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        rightNodeRec(root);

        return root;
    }

    /**
     * 递归
     * @param root
     */
    public void rightNodeRec(TreeNode root) {
        if (root == null) return;

        rightNodeRec(root.right);

        num += root.val;
        root.val = num;


        rightNodeRec(root.left);
    }

    /**
     * 非递归
     * @param root
     */
    public void rightNodeNoRec(TreeNode root) {
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            num += cur.val;
            cur.val = num;

            cur = cur.left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode.print(solution.convertBST(TreeNode.createTestData("[5,2,13]")));
    }
}
