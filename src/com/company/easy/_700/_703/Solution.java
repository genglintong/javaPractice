package com.company.easy._700._703;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * </p>
 * DATE 2020/2/25.
 *
 * @author genglintong.
 */
public class Solution {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));// returns 4
        System.out.println(kthLargest.add(5));// returns 5
        System.out.println(kthLargest.add(10));// returns 5
        System.out.println(kthLargest.add(9));// returns 8
        System.out.println(kthLargest.add(4));// returns 8
    }
}

class KthLargest {
    Stack<Integer> stack= new Stack<>(), temp = new Stack<>();
    int k;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        int n = nums.length;

        for (int i = 0 ; i < k ; i++) {
            if (i == nums.length) return;
            stack.push(nums[n - i -1]);
        }
    }

    public int add(int val) {
        while (!stack.isEmpty()) {
            int cur = stack.peek();

            if (cur >= val) {
                temp.push(val);
                break;
            }else {
                temp.push(stack.pop());
            }
        }

        if (stack.isEmpty()) temp.push(val);

        while (stack.size() < this.k && !temp.isEmpty()) {
            stack.push(temp.pop());
        }

        temp.clear();
        return stack.peek();
    }
}
