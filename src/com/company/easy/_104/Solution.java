package com.company.easy._104;

import com.company.util.TreeNode;

/**
 * @author genglintong
 * @package com.company.easy._104
 * @desc https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
 * @date 2019/8/29
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
    }
}
