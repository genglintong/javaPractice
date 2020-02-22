package com.company.easy._637;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * </p>
 * DATE 2020/2/22.
 *
 * @author genglintong.
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Double> res = new ArrayList<>();
        double n = 0, num= 0, t;

        while (!stack.isEmpty()) {
            num = 0;
            t = stack.size();
            n = t;
            while (t-- > 0) {
                TreeNode node = stack.pollFirst();
                num += node.val;

                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }

            res.add(num / n);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageOfLevels(TreeNode.createTestData("[10,5,15,null,null,6,20]")));
    }
}
