package com.company.easy._013;

import com.sun.tools.javac.file.SymbolArchive;

import java.util.HashMap;

/**
 * @author genglintong
 * @package com.company.easy._013
 * @desc
 * @date 2019/8/7
 */
public class Solution {
    // 字符串遍历
    public int romanToInt(String s) {
        HashMap<Character, Integer> map =  new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // 由于罗马数字 规则 该逻辑可以去掉
        HashMap<Integer, Integer> left = new HashMap<>();
        left.put(5,1);
        left.put(10,1);
        left.put(50,10);
        left.put(100,10);
        left.put(1000,100);
        left.put(500,100);


        int len = s.length();
        int sum = map.get(s.charAt(len-1));
        //System.out.println(sum);
        for (int i = len - 2; i >= 0; i--) {
            int min = map.get(s.charAt(i));
            int max = map.get(s.charAt(i+1));

            if (left.get(max) != null && left.get(max) == min) {
                sum -= min;
            }else {
                sum += min;
            }
            //System.out.println(sum);
        }

        return sum;
    }

    // 罗马数字 无越级 eg IXC 这种情况
    public int romanToIntOpti(String s) {
        HashMap<Character, Integer> map =  new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int len = s.length();
        int sum = map.get(s.charAt(len-1));
        //System.out.println(sum);
        for (int i = len - 2; i >= 0; i--) {
            int min = map.get(s.charAt(i));
            int max = map.get(s.charAt(i+1));

            if (max > min) {
                sum -= min;
            }else {
                sum += min;
            }
            //System.out.println(sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToIntOpti("LVIII"));
    }
}
