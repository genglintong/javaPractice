package com.company.easy._572;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/subtree-of-another-tree/
 * </p>
 * DATE 2020/2/20.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

//    private String preOrder(TreeNode node, boolean left) {
//        if (node == null) {
//            if (left) return "lnull";
//            else return "rnull";
//        }
//
//        return "#" + node.val + " " + preOrder(node.left, true) + " " + preOrder(node.right, false);
//    }

    private boolean traverse(TreeNode s, TreeNode t) {
        return (s != null) && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }

    private boolean equals(TreeNode t1, TreeNode t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && (equals(t1.left, t2.left) && equals(t1.right, t2.right));
    }

    public static void main(String[] args) {

    }
}
