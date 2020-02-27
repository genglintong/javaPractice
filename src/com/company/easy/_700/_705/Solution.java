package com.company.easy._700._705;

import java.util.ArrayList;

/**
 * Description
 * <p>
 *
 * </p>
 * DATE 2020/2/27.
 *
 * @author genglintong.
 */
public class Solution {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);

        hashSet.contains(1); // 返回 true
        hashSet.contains(3); // 返回 false (未找到)
        hashSet.add(2);
        hashSet.contains(2); // 返回 true
        hashSet.remove(2);
        hashSet.contains(2);// 返回  false (已经被删除)
    }
}

class MyHashSet {
    int num;
    ArrayList<Integer>[] hash;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.num = 64;
        hash = new ArrayList[64];
    }

    public void add(int key) {
        ArrayList<Integer> cur = hash[key % this.num];

        if (cur == null) {
            cur = new ArrayList<>();
            hash[key % this.num] = cur;
        }else {
            for (Integer a : cur) {
                if (a == key) {
                    return;
                }
            }
        }
        cur.add(key);
    }

    public void remove(int key) {
        ArrayList<Integer> cur = hash[key % this.num];

        if (cur != null) {
            cur.remove((Integer)key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        ArrayList<Integer> cur = hash[key % this.num];

        if (cur != null) {
            return cur.contains(key);
        }else {
            return false;
        }
    }
}
