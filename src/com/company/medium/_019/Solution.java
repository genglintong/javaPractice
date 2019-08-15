package com.company.medium._019;

import com.company.util.ListNode;

/**
 * @author genglintong
 * @package com.company.medium._019
 * @desc https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @date 2019/8/15
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPreN = head;
        while (n-- != 0) {
            afterPreN = afterPreN.next;
        }
        if (afterPreN != null) {
            while (afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData(new int[]{1,2,3,4,5}), 2));
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData(new int[]{1}), 1));
    }
}
