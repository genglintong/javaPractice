package com.company.medium._022;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author genglintong
 * @package com.company.medium._022
 * @desc https://leetcode-cn.com/problems/generate-parentheses/
 * @date 2019/8/16
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.emptyList();

        List<String> list = new LinkedList<>();

        if ( n == 1) {
            list.add("()");
            return list;
        }

        List<String> temp = generateParenthesis(n-1);
        for (String s : temp) {
            char[] arrC = s.toCharArray();
            int len = arrC.length;
            for (int i = 0 ; i < len ; i++) {
                if (arrC[i] == '(') {
                    for (int j = i+1 ; j < len ; j++) {
                        if (j == ')') {
                            list.add(s.substring(0,i+1) + "(" + s.substring(i+1, j) + ")" + s.substring(j,len));
                        }
                    }
                }
            }
        }

        return list;
    }

    public List<String> generateParenthesisOpti(int n) {
        HashMap<Integer, List<String>> map = new HashMap<>();

        map.put(0, Collections.singletonList(""));
        for (int i = 1 ; i <= n ; i++) {
            List<String> list = new LinkedList<>();
            for (int j = 0 ; j < i ; j++) {
                for (String sj : map.get(j)) {
                    for (String sij : map.get(i - j - 1)) {
                        list.add("(" + sj + ")" + sij);
                    }
                }
            }
            //System.out.println(list);
            map.put(i,list);
        }

        return map.get(n);
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.generateParenthesisOpti(3));
    }
}
