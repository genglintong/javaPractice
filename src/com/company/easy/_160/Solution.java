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
//    /**
//     * 有问题～
//     * @param headA
//     * @param headB
//     * @return
//     */
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        if (headA == headB) {
//            return headA;
//        }else {
//            ListNode hA = getIntersectionNode(headA.next, headB);
//            if (hA != null) {
//                return hA;
//            }
//            ListNode hB = getIntersectionNode(headA , headB.next);
//            if (hB != null) {
//                return hB;
//            }
//        }
//
//        return null;
//    }
//
//    /**
//     * 双指针法
//     * @param headA
//     * @param headB
//     * @return
//     */
//    public ListNode getIntersectionNodeOpti(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        ListNode tailA = null, tailB = null , hA = headA , hB = headB;
//        boolean a = true , b = true;
//
//        while (headA != headB) {
//            if (headA.next == null && tailA == null) {
//                tailA = headA;
//            }
//            if (headB.next == null && tailB == null) {
//                tailB = headB;
//            }
//            headA = headA.next;
//            headB = headB.next;
//
//            if (headA == null) {
//                if (a) {
//                    headA = hB;
//                }else {
//                    headA = hA;
//                }
//                a = !a;
//            }else {
//                if (b) {
//                    headB = hA;
//                }else {
//                    headB = hB;
//                }
//
//                b = !b;
//            }
//
//            if (tailA != null && tailB != null && tailA != tailB) {
//                return null;
//            }
//        }
//        return headA;
//    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA, lenB, len;
        ListNode hA = headA, hB = headB;

        lenA = getLen(hA);
        lenB = getLen(hB);

        if (lenA > lenB) {
            int z = lenA - lenB;
            len = lenB;
            while (z-- > 0) {
                headA = headA.next;
            }
        }else {
            int z = lenB - lenA;
            len = lenA;
            while (z-- > 0) {
                headB = headB.next;
            }
        }

        while (len-- > 0) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLen(ListNode node) {
        int n = 0;
        while (node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        ListNode listNodeA = ListNode.createTestData(new int[]{1,2,3,4,5,6,7});
        ListNode listNodeB = ListNode.createTestData(new int[]{5,6,7});

        listNodeB.next.next.next = listNodeA.next.next.next;

        Solution solution = new Solution();
        ListNode cur = solution.getIntersectionNode(listNodeA, listNodeB);

        ListNode.print(cur);
    }
}
