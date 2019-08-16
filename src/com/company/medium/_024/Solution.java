package com.company.medium._024;

import com.company.util.ListNode;

/**
 * @author genglintong
 * @package com.company.medium._024
 * @desc https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @date 2019/8/16
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = null;

        if (head != null && head.next != null) {
            temp = swapPairs(head.next.next);
            head.next.next = head;
            head = head.next;
            head.next.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.swapPairs(ListNode.createTestData(new int[]{1,2,3,4})));
    }
}
