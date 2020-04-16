package chapter1_exercise1to500.section3_exercise101to150;

import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?*/
// 用时336ms 击败5%      内存消耗47.6M 击败100%
public class Ex146_LRUCache {
    private int capacity;
    private Map<Integer,Integer>map=new HashMap<>();
    private List<Integer> arrayList=new ArrayList<>();

    public Ex146_LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        Integer result=this.map.get(key);
        if(result==null){
            return -1;
        }
        arrayList.remove((Integer)key);
        arrayList.add((Integer)key);
        return result;
    }
    public void put(int key, int value) {
        if(arrayList.size()==capacity&&!map.containsKey(key)){
            Integer rm=arrayList.remove(0);
            arrayList.add(key);
            map.remove(rm);
        }else if(!map.containsKey(key)){
            arrayList.add(key);
        }else {
            arrayList.remove((Integer)key);
            arrayList.add((Integer)key);
        }
        map.put(key,value);
    }
}
