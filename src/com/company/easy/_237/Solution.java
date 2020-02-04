package com.company.easy._237;

import com.company.util.ListNode;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *     该题目意思不太明确，因此如果真正遇到，一定要好好沟通～
 *     题目说的，删除值，但是节点地址并不一定要删除
 * </p>
 * DATE 2019/12/24.
 *
 * @author genglintong.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next != null) {
                node = node.next;
            }else {
                node.next = null;
            }
        }
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.createTestData(new int[]{4,5,1,9});

        Solution solution = new Solution();
        solution.deleteNode(listNode.next);

        ListNode.print(listNode);
    }
}
