package com.company.easy._482;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/license-key-formatting/
 * </p>
 * DATE 2020/2/14.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 显然使用倒序
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = S.toUpperCase().toCharArray();
        int len = chars.length, index = 0;

        for (int i = len - 1; i >= 0 ; i--) {
            if (chars[i] != '-') {
                if (index == K) {
                    stringBuilder.insert(0, '-');
                    index = 0;
                }
                index++;
                stringBuilder.insert(0, chars[i]);
            }
        }

        return stringBuilder.toString();
    }

    public String licenseKeyFormattingOpti(String S, int K) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = S.toUpperCase().split("-");
        int len = strings.length;

        for (int i = len - 1; i >= 0 ; i--) {
            stringBuilder.insert(0, strings[i]);
            if (i !=0 ) {
                stringBuilder.insert(0, "-");
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormattingOpti("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormattingOpti("--a---a---a-a-a-a-a--a", 2));
        System.out.println(solution.licenseKeyFormattingOpti("a-a-a-a-", 1));

        System.out.println(solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(solution.licenseKeyFormatting("--a---a---a-a-a-a-a--a", 2));
        System.out.println(solution.licenseKeyFormatting("a-a-a-a-", 1));
    }
}
