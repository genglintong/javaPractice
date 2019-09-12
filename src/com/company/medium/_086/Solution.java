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

        ListNode maxHead = new ListNode(0), minHead = new ListNode(0);

        while (head != null) {
            ListNode h = head, pre;
            while (head != null && head.val < x) {
                pre = head;
                head = head.next;
            }
            if (head != h) {
                minHead.next = h;

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
