package com.company.easy._107;

import com.company.util.TreeNode;

import java.util.*;

/**
 * @author genglintong
 * @package com.company.easy._107
 * @desc https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @date 2019/9/3
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeNode t ;
            List<Integer> res = new ArrayList<>();
            while (len-- > 0){
                t = queue.poll();
                res.add(t.val);
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            list.add(0, res);
        }

        return list;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.levelOrderBottom(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}
