package com.company.easy._232;

import java.util.Queue;
import java.util.Stack;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/3.
 *
 * @author genglintong.
 */
class MyQueue {
    private Stack<Integer> stackA;
    private Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stackA.empty()) {
            stackA.push(x);
        }else {
            while (stackA.empty()) {
                stackB.push(stackA.pop());
            }
            stackA.push(x);
            while (stackB.empty()) {
                stackA.push(stackB.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            return 0;
        }
       return stackA.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            return 0;
        }
        return stackA.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackA.empty();
    }
}

public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
    }
}
