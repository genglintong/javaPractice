package com.company.easy._530;

import com.company.util.TreeNode;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * </p>
 * DATE 2020/2/17.
 *
 * @author genglintong.
 */
public class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre;
    /**
     * 要注意审题
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
//        int min = Integer.MAX_VALUE;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur;
//
//        stack.add(root);
//
//        while (!stack.empty()) {
//            cur = stack.pop();
//            if (cur.left != null) {
//                stack.add(cur.left);
//                min = Math.min(min, Math.abs(cur.left.val -  cur.val));
//            }
//
//            if (cur.right != null) {
//                stack.add(cur.right);
//                min = Math.min(min, Math.abs(cur.right.val -  cur.val));
//            }
//        }
//        return min;
        inNodeNoRec(root);
        return min;
    }

    public void inNode(TreeNode node) {
        if (node == null) return;

        inNode(node.left);

        if (pre != null) {
            min = Math.min(min, Math.abs(pre.val - node.val));
        }
        pre = node;
        inNode(node.right);
    }

    public void inNodeNoRec(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node, pre = null;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            if (pre != null) {
                min = Math.min(min, Math.abs(pre.val - cur.val));
            }
            pre = cur;
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(TreeNode.createTestData("[1,null,3,null,null,2,null]")));
    }
}
