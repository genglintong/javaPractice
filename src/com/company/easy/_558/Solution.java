package com.company.easy._558;

import com.company.util.Node;

/**
 * Description
 * <p>
 *     https://leetcode-cn.com/problems/quad-tree-intersection/
 * </p>
 * DATE 2020/2/19.
 *
 * @author genglintong.
 */
public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                return quadTree1;
            }else {
                return quadTree2;
            }
        }
        if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return quadTree2;
            }else {
                return quadTree1;
            }
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {

    }
}
