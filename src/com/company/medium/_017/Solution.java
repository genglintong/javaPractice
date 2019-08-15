package com.company.medium._017;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author genglintong
 * @package com.company.medium._017
 * @desc https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @date 2019/8/15
 */
public class Solution {
    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();

        LinkedList<String> list = new LinkedList<>();
        list.add("");
        char[] chars = digits.toCharArray();
        int len = chars.length;
        for (int i = 0 ; i < len ; i++) {
            char c = chars[i];
            while (list.getFirst().length() == i) {
                String s = list.pop();
                for (char v : map[c - '2'].toCharArray()) {
                    list.addLast(s + v);
                }
            }
        }

        return list;
    }

    public List<String> letterCombinationsOpti(String digits) {
        if (digits.length() == 0) return Collections.emptyList();

        List<String> list = this.letterCombinationsOpti(digits.substring(1));
        LinkedList<String> newList = new LinkedList<>();

        for (char v : map[digits.charAt(0) - '2'].toCharArray()) {
            if (list.isEmpty()) {
                newList.addLast(v + "");
                continue;
            }
            for (String value:list) {
                newList.addLast(v + value);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinationsOpti("23"));
    }
}
