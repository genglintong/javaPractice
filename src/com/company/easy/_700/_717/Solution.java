package com.company.easy._700._717;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * </p>
 * DATE 2020/2/27.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int num = bits.length;
        boolean pre = false;

        for (int i = 0; i < num - 1 ; i++) {
            if (pre) {
                pre = false;
            }else {
                if (bits[i] == 1) pre = true;
            }
        }

        return !pre;
    }

    public static void main(String[] args) {

    }
}
