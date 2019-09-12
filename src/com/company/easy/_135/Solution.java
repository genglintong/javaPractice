package com.company.easy._135;

import java.util.Stack;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/min-stack/
 * </p>
 * DATE 2019/9/12.
 *
 * @author genglintong.
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (min.size() == 0 || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.size() != 0) {
            if (stack.pop().equals(min.peek())) {
                min.pop();
            }
        }
    }

    public int top() {
        if (stack.size() != 0) {
            return stack.peek();
        }
        return 0;
    }

    public int getMin() {
        if (min.size() != 0) {
            return min.peek();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
