package com.company.medium._086;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/partition-list/
 * </p>
 * DATE 2019/9/11.
 *
 * @author genglintong.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);
        ListNode before = before_head, after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.partition(ListNode.createTestData(new int[]{1,4,3,2,5,2}),3));
    }
}
