package com.company.easy._279;

import netscape.security.UserTarget;

import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/word-pattern/
 * </p>
 * DATE 2020/2/4.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int len = pattern.length();
        String[] strings = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (strings.length != len) {
            return false;
        }

        if (len <= 1) {
            return true;
        }

        HashMap<Character, String> characterStringHashMap = new HashMap<>(len);
        HashMap<String, Character> stringCharacterHashMap = new HashMap<>(len);

        for (int i = 0 ; i < len ; i++) {
            Character c = chars[i];
            String s = strings[i];

            if (characterStringHashMap.containsKey(c)) {
                if (!(s.equals(characterStringHashMap.get(c)) && c.equals(stringCharacterHashMap.get(s)))) {
                    return false;
                }
            }else {
                if (stringCharacterHashMap.containsKey(s)) {
                    return false;
                }
                stringCharacterHashMap.put(s, c);
                characterStringHashMap.put(c, s);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
}
