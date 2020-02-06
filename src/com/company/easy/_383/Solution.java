package com.company.easy._383;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/ransom-note/
 * </p>
 * DATE 2020/2/6.
 *
 * @author genglintong.
 */
public class Solution {
    /**
     * 复杂度 m+n
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        char[] charNote = ransomNote.toCharArray(), charMagazine = magazine.toCharArray();
        int len1 = charNote.length, len2 = charMagazine.length;

        if (len1 > len2) {
            return false;
        }

        for (char c : charNote) {
            ints[c-'a']++;
        }

        for (char c : charMagazine) {
            if (ints[c - 'a'] > 0) {
                ints[c - 'a']--;
                if (--len1 <= 0)
                    return true;
            }
        }

        return (len1 == 0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("", "aab"));
        System.out.println(solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
