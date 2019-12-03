package com.company.easy._206;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/3.
 *
 * @author genglintong.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0);

        while (head != null) {
            ListNode cur = head;
            head = head.next;

            cur.next = h.next;
            h.next = cur;
        }
        return h.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode h = ListNode.createTestData(new int[]{1,2,3,4,5});
        ListNode.print(solution.reverseList(h));
    }
}
