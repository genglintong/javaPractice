package com.company.util;

/**
 * @author genglintong
 * @package com.company.util
 * @desc
 * @date 2019/8/7
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * 创建测试数据
     *
     * @param testData [XX,XX,XX]
     * @return {@link ListNode}
     */
    public static ListNode createTestData(int[] testData) {
        int len = testData.length;

        if (len <=0) {
            return null;
        }

        ListNode head = new ListNode(testData[0]), next, temp = head;
        for (int i = 1; i < len ; i++) {
            next = new ListNode(testData[i]);
            temp.next = next;
            temp = next;
        }

        return head;
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }
        StringBuilder str = new StringBuilder("[" + String.valueOf(listNode.val));
        ListNode p = listNode.next;
        while (p != null) {
            str.append(",").append(String.valueOf(p.val));
            p = p.next;
        }
        System.out.println(str.append("]"));
    }
}
