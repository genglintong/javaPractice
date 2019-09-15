package com.company.medium._092;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * </p>
 * DATE 2019/9/15.
 *
 * @author genglintong.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h= new ListNode(0), mNode = head, nNode = head;
        int index = -1;

        h.next = head;
        head = h;


        while (head != null && ++index <= n) {
            if (index < m) {
                if (index == m - 1) {
                    mNode = head;
                    nNode = head.next;
                    mNode.next = null;
                    head = nNode;
                }else {
                    head = head.next;
                }
            }else {
                ListNode hh = head.next;
                head.next = mNode.next;
                mNode.next = head;
                head = hh;
            }
            //ListNode.print(h);
            //System.out.println(mNode.val + " " +index);
        }

        nNode.next = head;
        return h.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.reverseBetween(ListNode.createTestData(new int[]{1,2,3,4,5}),1,4));
    }
}
