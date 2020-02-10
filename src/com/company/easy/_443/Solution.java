package com.company.easy._443;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/string-compression/
 * </p>
 * DATE 2020/2/10.
 *
 * @author genglintong.
 */
public class Solution {
    public int compress(char[] chars) {
        int len = chars.length, zipL = 0, n, start;

        if (len <= 1) {
            return len;
        }

        for (int i = 0 ; i < len ; i++) {
            n = 1;
            start = i;
            while (i > 0 && i < len && chars[i] == chars[i-1]) {
                n++;
                i++;
            }
            chars[zipL] = chars[start];
            if (n > 1) {
                char[] t = String.valueOf(n).toCharArray();
                for (char c : t) {
                    chars[zipL++] = c;
                }
            }else {
                zipL++;
            }
        }

        return zipL;
    }

    public int compressOpti(char[] chars) {
        int anchor = 0, write = 0, len = chars.length;
        for (int read = 0 ; read < len ; read++) {
            if (read == len - 1 || chars[read+1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }

        return write;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressOpti(new char[]{'a','a','b','b','c','c','c'}));
    }
}
