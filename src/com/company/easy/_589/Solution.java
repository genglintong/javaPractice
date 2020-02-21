package com.company.easy._589;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * </p>
 * DATE 2020/2/21.
 *
 * @author genglintong.
 */
public class Solution {
    public List<Integer> preOrder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            list.add(cur.val);

            if (cur.children != null) {
                Collections.reverse(cur.children);
                stack.addAll(cur.children);
            }
        }

        return list;
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
