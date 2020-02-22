package com.company.easy._606;

import com.company.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * </p>
 * DATE 2020/2/22.
 *
 * @author genglintong.
 */
public class Solution {
    public String tree2str(TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        Set<TreeNode> visit = new HashSet<>();

        if (t == null) return res.toString();

        stack.add(t);

        while (!stack.isEmpty()) {
            TreeNode n = stack.peek();
            if (visit.contains(n)) {
                stack.pop();
                res.append(')');
            }else {
                visit.add(n);
                res.append('(').append(n.val);

                if (n.right != null) {
                    stack.push(n.right);
                }

                if (n.left != null) {
                    stack.push(n.left);
                }
                if (n.right != null && n.left == null){
                    res.append("()");
                }
            }

        }

        return res.substring(1, res.length()-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tree2str(TreeNode.createTestData("[1,2,3,null,4,null,null,null]")));
    }
}
