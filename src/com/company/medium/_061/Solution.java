package com.company.medium._061;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/rotate-list/
 * </p>
 * DATE 2019/9/4.
 *
 * @author genglintong.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) {
            return head;
        }

        ListNode node = head, preNode = new ListNode(0);
        int len = 0;
        while (node != null) {
            len++;
            preNode = node;
            node = node.next;
        }

        preNode.next = head;

        k = len - k % len;

        node = head;
        while (--k > 0) {
            node = node.next;
        }
        System.out.print(node.val);
        head = node.next;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.rotateRight(ListNode.createTestData(new int[]{1,2,3,4,5}), 2));
        ListNode.print(solution.rotateRight(ListNode.createTestData(new int[]{1,2}), 1));
    }
}
