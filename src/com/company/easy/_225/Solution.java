package com.company.easy._225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/3.
 *
 * @author genglintong.
 */
class MyStack {
    private LinkedList<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (this.empty()) {
            return 0;
        }
        return queue.pop();
    }

    /** Get the top element. */
    public int top() {
        if (this.empty()) {
            return 0;
        }
        return queue.getFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (queue.size() == 0);
    }
}

public class Solution {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }
}


