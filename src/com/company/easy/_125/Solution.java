package com.company.easy._125;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/valid-palindrome/
 * </p>
 * DATE 2019/9/9.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int num = sArray.length, cnt = 0;
        for (int i = 0 ; i < num ; i++) {
            if ((sArray[i] >= '0' && sArray[i] <= '9') || (sArray[i] >= 'a' && sArray[i] <= 'z')) {
                sArray[cnt++] = sArray[i];
            }else if (sArray[i] >= 'A' && sArray[i] <= 'Z') {
                sArray[cnt++] = (char) (sArray[i] - 'A' + 'a');
            }
        }
        cnt--;
        int i = 0 ;
        while (i < cnt) {
            if (sArray[i++] != sArray[cnt--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(""));
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
