package com.company.easy._141;

import com.company.util.ListNode;

import java.util.SortedSet;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/linked-list-cycle/
 * </p>
 * DATE 2019/9/11.
 *
 * @author genglintong.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        if (head == null) {
            return false;
        }
        if (fast.next != null) {
            fast = fast.next;
        }else {
            return false;
        }

        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(ListNode.createTestData(new int[]{})));
    }
}
