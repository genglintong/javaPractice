package com.company.medium._056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/merge-intervals/
 * </p>
 * DATE 2019/9/3.
 *
 * @author genglintong.
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                }else if (o1[0] < o2[0]) {
                    return -1;
                }else if (o1[1] > o2[1]) {
                    return 1;
                }else if (o1[1] < o2[1]) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        List<int[]> list = new ArrayList<>();
        int j = 0;
        for (int i = 1; i < len ; i++) {
            //  可以合并
            if (intervals[i][0] <= intervals[j][1]) {
                intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
            }else {
                list.add(intervals[j]);
                j = i;
            }
        }
        list.add(intervals[j]);

        int ll = list.size();
        int[][] merge = new int[ll][2];
        for (int i = 0 ; i < ll ; i++) {
            merge[i] = list.get(i);
        }
        return merge;
    }

    public static void main(String[] args){
        Solution solution = new Solution();

        int[][] merge = solution.merge(new int[][]{{1,5},{2,6},{8,10}});
        for (int i = 0 ; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
