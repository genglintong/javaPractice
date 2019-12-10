package com.company.easy._235;

import com.company.util.TreeNode;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/10.
 *
 * @author genglintong.
 */
public class Solution {
    class Result{
        private TreeNode treeNode = null;
        /**
         * 0 啥都没有
         * 1 只有p 或 q
         * 2 全都有
         */
        private int target = 0;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p , q).treeNode;
    }

    /**
     * 返回值
     * 公共祖先 返回 公共祖先
     * 只有 p 返回p
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Result lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result();
        }
        Boolean isTarget = (root.val == p.val) || (root.val == q.val);

        Result rightResult = lowestCommonAncestorHelper(root.right, p, q);
        getResult(rightResult, isTarget, root);

        if (rightResult.target >= 2) {
            return rightResult;
        }

        Result leftResult = lowestCommonAncestorHelper(root.left, p , q);
        getResult(leftResult, isTarget, root);
        if (leftResult.target >= 2) {
            return leftResult;
        }

        rightResult.target = rightResult.target + leftResult.target - (isTarget ? 1 : 0);
        System.out.println(root.val + "   " + rightResult.target + "   " + rightResult.treeNode.val);
        return rightResult;
    }

    private Result getResult(Result result , Boolean isTarget, TreeNode root) {
        if (result.target == 2) {
            return result;
        }else if (isTarget) {
            result.target ++;
        }

        result.treeNode = root;
        return result;
    }

    public TreeNode lowestCommonAncestorOpti(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (rootVal > pVal && rootVal > qVal) {
            return lowestCommonAncestorOpti(root.left, p, q);
        }else if (rootVal < pVal && rootVal < qVal) {
            return lowestCommonAncestorOpti(root.right, p , q);
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node = TreeNode.createTestData("[5,3,6,2,4,null,null,1]");
        TreeNode.print(node);

        System.out.println(solution.lowestCommonAncestor(node, new TreeNode(1), new TreeNode(4)));
    }
}
