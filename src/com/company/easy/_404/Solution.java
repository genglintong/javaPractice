package com.company.easy._404;

import com.company.util.TreeNode;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/sum-of-left-leaves/
 * </p>
 * DATE 2020/2/9.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 遍历 然后判断
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) return res;

        Stack<NodeDetail> stack = new Stack<>();
        stack.push(new NodeDetail(root, false));

        while (!stack.empty()) {
            NodeDetail nodeDetail = stack.pop();
            if (nodeDetail.node.left != null) {
                stack.push(new NodeDetail(nodeDetail.node.left, true));
            }
            if (nodeDetail.node.right != null) {
                stack.push(new NodeDetail(nodeDetail.node.right, false));
            }

            if (nodeDetail.isLeft && nodeDetail.node.right == null && nodeDetail.node.left == null) {
                res += nodeDetail.node.val;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}

class NodeDetail {
    public TreeNode node;
    public boolean isLeft;

    public NodeDetail(TreeNode node, boolean isLeft) {
        this.node = node;
        this.isLeft = isLeft;
    }
}
