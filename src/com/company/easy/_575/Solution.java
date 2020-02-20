package com.company.easy._575;

import java.util.HashSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/distribute-candies/
 * </p>
 * DATE 2020/2/20.
 *
 * @author genglintong.
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> hashSet = new HashSet<>(candies.length);

        for (int c : candies) {
            hashSet.add(c);
        }

        return Math.min(hashSet.size(), candies.length / 2);
    }

    public static void main(String[] args) {

    }
}
