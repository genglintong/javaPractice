package com.company.easy._168;

import java.util.HashMap;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/excel-sheet-column-title/
 * </p>
 * DATE 2020/1/20.
 *
 * @author genglintong.
 */
public class Solution {
    private HashMap<Integer, Character> characterHashMap = new HashMap<>(26);

    public Solution() {
        characterHashMap.put(0, 'Z');
        for (int i = 0 ; i < 25 ; i++) {
            characterHashMap.put(i + 1, (char)('A' + i));
        }
    }

    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n != 0) {
            stringBuilder.insert(0, characterHashMap.get(n % 26));

            if (n % 26 == 0) {
                n--;
            }
            n = n / 26;
        }

        return stringBuilder.toString();
    }

    public String convertToTitleOpti(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        while (n != 0) {
            int x = n % 26;
            char c = 'A';
            if (x == 0) {
                n--;
                c = 'Z';
            }else {
                c = (char) (c + x - 1);
            }
            stringBuilder.insert(0, c);

            n = n / 26;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //System.out.println(solution.convertToTitle(1));
        //System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(701));
    }
}
