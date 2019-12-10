package com.company.easy._234;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/10.
 *
 * @author genglintong.
 */
public class Solution {

    /**
     * 1. 快慢指针 找到中间节点
     * 2. 反转字符串
     * 3. 比较
     *
     * 仍有优化空间
     * 可以在快慢指针时 对前半段进行反转
     * 减少遍历
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        /**
         * 特殊情况过滤
         */
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = reserve(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private ListNode reserve(ListNode head) {
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

        System.out.println(solution.isPalindrome(ListNode.createTestData(new int[]{})));
        System.out.println(solution.isPalindrome(ListNode.createTestData(new int[]{1,2})));
        System.out.println(solution.isPalindrome(ListNode.createTestData(new int[]{1,2,1})));
        System.out.println(solution.isPalindrome(ListNode.createTestData(new int[]{1,2,2,1})));
    }
}
