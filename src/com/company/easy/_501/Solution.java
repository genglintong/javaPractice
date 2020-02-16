package com.company.easy._501;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * </p>
 * DATE 2020/2/15.
 *
 * @author genglintong.
 */
public class Solution {

    private int maxTimes;
    private int curMaxTimes;
    private TreeNode pre;
    private ArrayList<Integer> res;

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        maxTimes = 0;
        curMaxTimes = 1;
        res = new ArrayList<>();

        inOrder(root);

        int length = res.size();
        int[] rr = new int[length];
        for(int i = 0; i < length; i++) {
            rr[i] = res.get(i);
        }
        return rr;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (pre != null) {
            curMaxTimes = (pre.val == root.val) ? curMaxTimes + 1 : 1;
        }
        if (maxTimes < curMaxTimes) {
            res.clear();
            res.add(root.val);
            maxTimes = curMaxTimes;
        }else if (maxTimes == curMaxTimes) {
            res.add(root.val);
        }

        pre = root;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMode(TreeNode.createTestData("[1,1,2]"))));
        System.out.println(Arrays.toString(solution.findMode(TreeNode.createTestData("[1,null,2,null,null,2,null]"))));
    }
}
