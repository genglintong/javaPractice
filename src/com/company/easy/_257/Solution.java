package com.company.easy._257;

import com.company.util.ListNode;
import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/binary-tree-paths/
 * </p>
 * DATE 2020/2/4.
 *
 * @author genglintong.
 */

public class Solution {
    /**
     * 显然使用队列 queue
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Path> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        queue.addLast(new Path(root));

        while (!queue.isEmpty()) {
            Path path = queue.pop();
            //System.out.println(path.path.toString());

            if (path.node.left == null && path.node.right == null) {
                res.add(path.path.toString());
            }
            if (path.node.left != null) {
                queue.addLast(new Path(path.node.left, path));
            }
            if (path.node.right != null) {
                queue.addLast(new Path(path.node.right, path));
            }
        }


        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[1,2,3,null,5,null,null]");
        Solution solution = new Solution();
        List<String> list = solution.binaryTreePaths(treeNode);

        for (int i = 0 ; i< list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Path {
    public TreeNode node;
    public StringBuilder path;

    public Path(TreeNode node) {
        this.node = node;
        this.path = new StringBuilder().append(node.val);
    }

    public Path(TreeNode node, Path path) {
        this.node = node;
        this.path = new StringBuilder().append(path.path).append("->").append(node.val);
    }
}
