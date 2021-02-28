package com.yanhuan.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode146  LRU缓存机制
 * 解法1：利用HashMap
 *
 * @author YanHuan
 * @date 2021-02-28 13:52
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //缓存策略
        return size() > capacity;
    }
}
