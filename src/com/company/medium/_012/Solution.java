package com.company.medium._012;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author genglintong
 * @package com.company.medium._012
 * @desc https://leetcode-cn.com/problems/integer-to-roman/
 * @date 2019/8/14
 */
public class Solution {
    public String intToRoman(int num)
    {
        int[] rom = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        HashMap<Integer, String> hash = new HashMap<>();

        hash.put(1000, "M");
        hash.put(900, "CM");
        hash.put(500, "D");
        hash.put(400, "CD");
        hash.put(100, "C");
        hash.put(90, "XC");
        hash.put(50, "L");
        hash.put(40, "XL");
        hash.put(10, "X");
        hash.put(9, "IX");
        hash.put(5, "V");
        hash.put(4, "IV");
        hash.put(1, "I");

        int n = rom.length, i = 0;
        StringBuilder str = new StringBuilder();
        while (i < n) {
            if (num >= rom[i]) {
                num -= rom[i];
                str.append(hash.get(rom[i]));
            }else {
                i++;
            }
        }

        return str.toString();
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();

        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(1994));
    }
}
