package com.company.medium._039;

import java.util.*;

/**
 * @author genglintong
 * @package com.company.medium._039
 * @desc https://leetcode-cn.com/problems/combination-sum/
 * @date 2019/8/26
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        //对candidates数组进行排序
        Arrays.sort(candidates);
        int len = candidates.length;
        for(int i = 1;i <= target;i++){
            //初始化map
            map.put(i,new HashSet<>());
            //对candidates数组进行循环
            for(int j = 0;j < len&&candidates[j] <= target;j++){
                if(i == candidates[j]){
                    //相等即为相减为0的情况，直接加入set集合即可
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.get(i).add(temp);
                }else if(i > candidates[j]){
                    //i-candidates[j]是map的key
                    int key = i-candidates[j];
                    //使用迭代器对对应key的set集合进行遍历
                    //如果candidates数组不包含这个key值，对应的set集合会为空，故这里不需要做单独判断
                    for(Iterator iterator = map.get(key).iterator();iterator.hasNext();){
                        List list = (List) iterator.next();
                        //set集合里面的每一个list都要加入candidates[j]，然后放入到以i为key的集合中
                        List tempList = new ArrayList<>();
                        tempList.addAll(list);
                        tempList.add(candidates[j]);
                        //排序是为了通过set集合去重
                        Collections.sort(tempList);
                        map.get(i).add(tempList);
                    }
                }
            }
            //System.out.println(map.get(i));
        }
        result.addAll(map.get(target));
        return result;
    }

    public List<List<Integer>> combinationSumOpti(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Set> map = new HashMap<>();
        int len = candidates.length;

        Arrays.sort(candidates);
        for (int i = 1; i <= target ; i++) {
            map.put(i, new HashSet<List>());
            for (int j = 0 ; j < len && candidates[j] <= i ; j++) {
                if (candidates[j] == i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.get(i).add(temp);
                }else {
                    Set<List> set = map.get(i - candidates[j]);
                    //System.out.println(set);
                    for (Iterator iterator = set.iterator(); iterator.hasNext();) {
                        List list = (List) iterator.next();
                        List tempList = new ArrayList();
                        tempList.addAll(list);
                        tempList.add(candidates[j]);
                        Collections.sort(tempList);
                        map.get(i).add(tempList);
                    }
                }
            }
            //System.out.println(i + " " + map.get(i));
        }

        result.addAll(map.get(target));
        return result;
    }

    public List<List<Integer>> combinationSumOpti2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        findCombinationSumOpti2(candidates, 0 , len, target, new Stack<>(), res);
        return res;
    }

    private void findCombinationSumOpti2(int[] candidates, int start, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start ; i < len && residue >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSumOpti2(candidates, i, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.combinationSumOpti(new int[]{2,3,6,7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(solution.combinationSumOpti2(new int[]{2,3,6,7}, 7));
    }
}
