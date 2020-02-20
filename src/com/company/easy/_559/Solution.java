package com.company.easy._559;

import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * </p>
 * DATE 2020/2/20.
 *
 * @author genglintong.
 */
public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int max = 1;

        if (root.children != null) {
            for (Node node : root.children) {
                max = Math.max(maxDepth(node) + 1, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
