package com.company.easy._345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * </p>
 * DATE 2020/2/5.
 *
 * @author genglintong.
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0 , end = chars.length - 1;
        HashSet<Character> characters = new HashSet<>(10);
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');
        characters.add('A');
        characters.add('E');
        characters.add('I');
        characters.add('O');
        characters.add('U');

        while (start < end) {
            while ((start < end) && !characters.contains(chars[start])) start++;
            while ((start < end) && !characters.contains(chars[end])) end--;

            if (start >= end) {
                break;
            }
            chars[start] += chars[end];
            chars[end] = (char) (chars[start] - chars[end]);
            chars[start] = (char) (chars[start] - chars[end]);
            start++;
            end--;
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leetcode"));
    }
}
