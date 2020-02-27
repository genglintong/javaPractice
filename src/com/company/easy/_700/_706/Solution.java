package com.company.easy._700._706;

import java.util.ArrayList;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/2/27.
 *
 * @author genglintong.
 */
public class Solution {
}

class MyHashMap {
    int num;
    ArrayList<Info>[] hash;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.num = 64;
        hash = new ArrayList[64];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ArrayList<Info> cur = hash[key % this.num];

        if (cur == null) {
            cur = new ArrayList<>();
            hash[key % this.num] = cur;
        }else {
            for (Info a : cur) {
                if (a.key == key) {
                    a.value = value;
                    return;
                }
            }
        }
        cur.add(new Info(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ArrayList<Info> cur = hash[key % this.num];

        if (cur != null) {
            for (Info info : cur) {
                if (info.key == key) {
                    return info.value;
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ArrayList<Info> cur = hash[key % this.num];
        if (cur != null) {
            for (int i = 0 ; i < cur.size() ; i++) {
                if (cur.get(i).key == key) {
                    cur.remove(i);
                    return;
                }
            }
        }
    }
}

class Info {
    public int key;
    public int value;

    public Info(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
