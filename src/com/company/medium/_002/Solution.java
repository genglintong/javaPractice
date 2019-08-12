package com.company.medium._002;

import com.company.util.ListNode;

/**
 * @author genglintong
 * @package com.company.medium._002
 * @desc  https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * @date 2019/8/8
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = this.rev(l1);
        l2 = this.rev(l2);

        //ListNode.print(l1);
        //ListNode.print(l2);

        ListNode head = new ListNode(0), newNode, temp = head;
        // 表示进位
        int n = 0 , t;

        while (l1 != null && l2 != null) {
            t = l1.val + l2.val + n;

            newNode = new ListNode(t%10);
            temp.next = newNode;
            temp = newNode;

            n = t / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            t = l1.val + n;
            l1 = l1.next;

            newNode = new ListNode(t/10);
            temp.next = newNode;
            temp = newNode;

            n = t / 10;
        }

        //ListNode.print(head);

        if (n > 0) {
            newNode = new ListNode(n);
            temp.next = newNode;
        }

        return head.next;
    }

    public ListNode addTwoNumbersOpti(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode n1 = l1, n2 = l2, t = head;
        int sum = 0;

        while (n1 != null || n2 != null) {

            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }

            t.next = new ListNode(sum % 10);
            t = t.next;
        }
        if (sum / 10 != 0) {
            t.next = new ListNode(1);
        }

        return head.next;
    }

    /**
     * 链表 逆序
     * @param l
     * @return
     */
    public ListNode rev(ListNode l) {
        ListNode head = new ListNode(0), temp = l;

        head.next = null;
        while (l != null) {
            l = l.next;

            temp.next = head.next;
            head.next = temp;

            temp = l;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.addTwoNumbersOpti(ListNode.createTestData(new int[]{5}), ListNode.createTestData(new int[]{5})));
    }
}
