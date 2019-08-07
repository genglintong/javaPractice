package com.company.easy._020;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author genglintong
 * @package com.company.easy._020
 * @desc
 * @date 2019/8/7
 */
public class Solution {

    // 栈使用 empty pop push peek
    public boolean isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', 1);
        map.put(')', -1);
        map.put('[', 2);
        map.put(']', -2);
        map.put('{', 3);
        map.put('}', -3);

        Stack<Integer> stack = new Stack<>();
        int len = s.length();

        for (int i = 0 ; i < len ; i++) {
            if (!stack.empty() && (stack.peek() + map.get(s.charAt(i)) == 0)) {
                stack.pop();
            }else {
                stack.push(map.get(s.charAt(i)));
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[{}"));
    }
}
