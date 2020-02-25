package com.company.easy._682;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/baseball-game/
 * </p>
 * DATE 2020/2/24.
 *
 * @author genglintong.
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, cur;

        for (String s : ops) {
            if ("+".equals(s)) {
                int pre = stack.pop();
                cur = pre + stack.peek();
                stack.push(pre);
                num += cur;
                stack.push(cur);
            }else if ("C".equals(s)) {
                int pre = stack.pop();
                num -= pre;
            }else if ("D".equals(s)) {
                cur = stack.peek() * 2;
                num += cur;
                stack.push(cur);
            }else {
                cur = Integer.parseInt(s);
                num += cur;
                stack.push(cur);
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"}));
    }
}
