package com.company.easy._205;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/2.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        /**
        Map<Character , Character> characterMap = new HashMap<>();

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int sNum = ss.length, tNum = tt.length;

        if (sNum != tNum) {
            return false;
        }

        for (int i = 0 ; i < sNum ; i++) {
            if (!characterMap.containsKey(ss[i])) {
                if (characterMap.containsKey(tt[i])) {
                    return false;
                }
                characterMap.put(ss[i], tt[i]);
            }else {
                if (characterMap.get(ss[i]) != tt[i]) {
                    return false;
                }
            }
        }

        return true;
         */

        /**
         * 同一个字符 第一次出现的位置相同 即可
         */
        Map<Character , Integer> charS = new HashMap<>();
        Map<Character , Integer> charT = new HashMap<>();

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int sNum = ss.length, tNum = tt.length;

        if (sNum != tNum) {
            return false;
        }

        for (int i = sNum - 1 ; i >= 0 ; i--) {
            charS.put(ss[i], i);
            charT.put(tt[i], i);
        }

        for (int i = 0 ; i < sNum ; i++) {
            if (!charS.get(ss[i]).equals(charT.get(tt[i]))) {
                return false;
            }
        }

        return true;
    }

    public void test(int n) {
        System.out.println(n);
        return;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";

        Solution solution = new Solution();

        System.out.println(solution.isIsomorphic(s, t));
//
//
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1,2);
//
//        solution.test(map.get(2));
    }
}
