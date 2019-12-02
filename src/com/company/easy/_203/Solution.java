package com.company.easy._203;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/30.
 *
 * @author genglintong.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0), pre = h;
        h.next = head;

        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            }else {
                pre = head;
            }
            head = head.next;
        }

        return h.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode h = ListNode.createTestData(new int[]{1,2,3,4,3,4,3,2,3});
        h = solution.removeElements(h, 3);

        ListNode.print(h);
    }
}
