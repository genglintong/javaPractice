package com.company.medium._071;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/simplify-path/
 * </p>
 * DATE 2019/9/5.
 *
 * @author genglintong.
 */
public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] ss = path.split("/");
        int n = ss.length;

        for (int i = 0 ; i < n ; i++) {
            if ("".equals(ss[i]) || ".".equals(ss[i])) {
                continue;
            }
            if ("..".equals(ss[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(ss[i]);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.pollLast());
        }
        String sss = res.toString();
        if ("".equals(sss)) {
            sss = "/";
        }
        return sss;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));

    }
}
