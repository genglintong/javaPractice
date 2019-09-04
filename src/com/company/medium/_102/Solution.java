package com.company.medium._102;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * </p>
 * DATE 2019/9/4.
 *
 * @author genglintong.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0 ; i < len ; i++) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                res.add(t.val);
            }
            list.add(res);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}
