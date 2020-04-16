package chapter1_exercise1to500.section3_exercise101to150;

import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?*/
// 用时36ms 击败36%      内存消耗47.6M 击败100%
//别人用的map
public class Ex146_LRUCache_2 {
    private int cap;
    private final Map<Integer,Integer> map;
    public Ex146_LRUCache_2(int capacity) {
        this.cap = capacity;
        //在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的.根据值的插入先后顺序'保存了一个链表'
        map = new LinkedHashMap<>(capacity+1);
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        //先删除后添加，刷新LinkedHashMap的插入次序
        int value = map.remove(key);
        map.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        map.remove(key);
        if(map.size()==cap){
            //通过map.entrySet().iterator()返回的迭代器  删除获得的第一个元素也就是最久没有使用的元素[map中已保存的最早插入的元素]
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            if(it.hasNext()){
                it.next();
                it.remove();
            }
        }
        map.put(key,value);
    }
}
