package com.company.easy._021;

import com.company.util.ListNode;

/**
 * @author genglintong
 * @package com.company.easy._021
 * @desc   https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @date 2019/8/7
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //ListNode.print(l1);
        ListNode head = new ListNode(0);
        ListNode temp = head, ll;

        while(l1 != null && l2 != null) {
            //System.out.println(l1.val + "  "+ l2.val);
            if (l1.val > l2.val) {
                ll = l2;
                l2 = l2.next;
            }else {
                ll = l1;
                l1 = l1.next;
            }
            //System.out.println(ll.val);

            temp.next = ll;
            ll.next = null;
            temp = ll;
        }

        if (l1 == null) {
            l1 = l2;
        }
        temp.next = l1;

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode.print(solution.mergeTwoLists(ListNode.createTestData(new int[]{1,2,4}), ListNode.createTestData(new int[]{1,3,4})));
    }
}
