package com.company.easy._160;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * </p>
 * DATE 2019/9/15.
 *
 * @author genglintong.
 */
public class Solution {

    /**
     * 有问题～
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }else {
            ListNode hA = getIntersectionNode(headA.next, headB);
            if (hA != null) {
                return hA;
            }
            ListNode hB = getIntersectionNode(headA , headB.next);
            if (hB != null) {
                return hB;
            }
        }

        return null;
    }

    /**
     * 双指针法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeOpti(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tailA = null, tailB = null , hA = headA , hB = headB;
        boolean a = true , b = true;

        while (headA != headB) {
            if (headA.next == null && tailA == null) {
                tailA = headA;
            }
            if (headB.next == null && tailB == null) {
                tailB = headB;
            }
            headA = headA.next;
            headB = headB.next;

            if (headA == null) {
                if (a) {
                    headA = hB;
                }else {
                    headA = hA;
                }
                a = !a;
            }else {
                if (b) {
                    headB = hA;
                }else {
                    headB = hB;
                }

                b = !b;
            }

            if (tailA != null && tailB != null && tailA != tailB) {
                return null;
            }
        }
        return headA;
    }

    public static void main(String[] args) {

    }
}
