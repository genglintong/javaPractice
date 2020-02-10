package com.company.easy._412;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/fizz-buzz/
 * </p>
 * DATE 2020/2/10.
 *
 * @author genglintong.
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++){
            StringBuilder stringBuilder = new StringBuilder();
            if (i % 3 == 0) {
                stringBuilder.append("Fizz");
            }
            if (i % 5 == 0) {
                stringBuilder.append("Buzz");
            }

            if (stringBuilder.length() == 0) {
                stringBuilder.append(i);
            }
            strings.add(stringBuilder.toString());
        }

        return strings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fizzBuzz(15));
    }
}
