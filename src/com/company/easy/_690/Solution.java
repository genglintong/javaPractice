package com.company.easy._690;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/employee-importance/
 * </p>
 * DATE 2020/2/24.
 *
 * @author genglintong.
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hashMap = new HashMap<>(employees.size());
        Stack<Integer> stack = new Stack<>();

        for (Employee e : employees) {
            hashMap.put(e.id, e);
        }

        stack.push(id);
        int res = 0, curId;

        while (!stack.isEmpty()) {
            curId = stack.pop();
            res += hashMap.get(curId).importance;

            stack.addAll(hashMap.get(curId).subordinates);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Employee> list = new ArrayList<>();
        list.add(new Employee());
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
