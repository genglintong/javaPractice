package com.company.easy._700._709;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/to-lower-case/
 * </p>
 * DATE 2020/2/27.
 *
 * @author genglintong.
 */
public class Solution {
    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c <= 'Z' && c >= 'A') {
                c = (char) (c + ('a' - 'A'));
            }
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
