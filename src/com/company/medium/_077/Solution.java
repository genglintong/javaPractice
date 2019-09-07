package com.company.medium._077;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/combinations/
 * </p>
 * DATE 2019/9/7.
 *
 * @author genglintong.
 */
public class Solution {

    /**
     * 此方法 超时
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new LinkedList<>();
        if (k == 1) {
            for (int i = 1 ; i <= n ; i++) {
                LinkedList<Integer> res = new LinkedList<>();
                res.addLast(i);
                list.add(res);
            }
        }else {
            List<List<Integer>> res = combine(n, k-1);
            int num = res.size();
            for (int i = 0 ; i < num ; i++) {
                int top = res.get(i).get(0);
                System.out.println(k + " " + i + " " + top);
                for (int j = top + 1 ; j <= n ; j++) {
                    LinkedList<Integer> nList = new LinkedList<>(res.get(i));
                    nList.addFirst(j);
                    list.add(nList);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> combineOpti(int n , int k) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            res.add(i, i + 1);
        }
        combineOptiHelper(res, list, n , k , 0);
        return list;
    }

    public void combineOptiHelper(List<Integer> res ,List<List<Integer>> list , int n , int k , int pos) {
        if (res.size() == k) {
            list.add(res);
            return;
        }
        for (int i = pos ; i < n ; i++) {
            List<Integer> temp = new ArrayList<>(res);

            res.remove(n - i - 1);
            combineOptiHelper(res, list, n, k, i + 1);
            res = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combineOpti(20,16));
    }
}
