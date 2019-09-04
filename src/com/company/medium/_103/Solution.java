package com.company.medium._103;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * </p>
 * DATE 2019/9/4.
 *
 * @author genglintong.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean d = true;

        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            List<Integer> res = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            for (int i = 0 ; i < len ; i++) {
                TreeNode t;

                if (d) {
                    t = queue.pollFirst();
                    if (t.left != null) {
                        q.addLast(t.left);
                    }
                    if (t.right != null) {
                        q.addLast(t.right);
                    }
                }else {
                    t = queue.pollLast();
                    if (t.right != null) {
                        q.addFirst(t.right);
                    }
                    if (t.left != null) {
                        q.addFirst(t.left);
                    }
                }

                res.add(t.val);
            }
            d = !d;
            list.add(res);
            queue = q;
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder(TreeNode.createTestData("[0,2,4,1,null,3,-1,5,1,null,null,null,6,null,8]")));
        System.out.println(solution.zigzagLevelOrder(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
        System.out.println(solution.zigzagLevelOrder(TreeNode.createTestData("[1,2,3,4,null,null,5]")));
    }
}
