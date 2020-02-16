package com.company.easy._500;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/keyboard-row/
 * </p>
 * DATE 2020/2/15.
 *
 * @author genglintong.
 */
public class Solution {
    public String[] findWords(String[] words) {
        int[] chars = new int[]{1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};

        ArrayList<String> strings = new ArrayList<>(words.length);
        int t = -1, cc;
        for (String w : words) {
            for (char c : w.toLowerCase().toCharArray()) {
                cc = c - 'a';
                if (t != -1 && t != chars[cc]) {
                    t = 100;
                    break;
                }else {
                    t = chars[cc];
                }
            }

            if (t != 100) {
                strings.add(w);
            }
            t = -1;
        }

        String[] ss = new String[strings.size()];
        return strings.toArray(ss);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findWords(new String[]{"Hello", "Alaska"})));
    }
}
