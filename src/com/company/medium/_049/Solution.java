package com.company.medium._049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author genglintong
 * @package com.company.medium._049
 * @desc https://leetcode-cn.com/problems/group-anagrams/
 * @date 2019/8/29
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        int n = strs.length;

        for (int i = 0 ; i < n ; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String ss = Arrays.toString(s);
            if (map.get(ss) == null) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(ss, list);
            }else {
                map.get(ss).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tae", "bat"}));
    }
}
