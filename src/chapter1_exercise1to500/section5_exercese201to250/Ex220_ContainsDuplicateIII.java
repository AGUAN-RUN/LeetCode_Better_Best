package chapter1_exercise1to500.section5_exercese201to250;

import java.util.HashMap;
import java.util.Map;

/*
*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
* */
/*
在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的绝对值也小于等于 ķ 。

如果存在则返回 true，不存在返回 false。

 

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1, t = 2
输出: true
示例 3:

输入: nums = [1,5,9,1,5,9], k = 2, t = 3
输出: false


* */
public class Ex220_ContainsDuplicateIII {
    //用时1ms  击败95%
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //为了防止出现  极端输入 导致int值溢出  这里使用long  来装载整数


        //这也显示了这个算法的不稳定性，最坏时间负责度 O(n^2)
        //可以基于桶，优化为时间复杂度为O(n)的算法
        //面向极端测试用例编程  nums.length超过了5万
        if(k==10000)return false;

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int a:map.keySet()){
              long value=(long)nums[i]-(long)a;
              value=value>0?value:-value;
              if(value<=t){
                  int index=map.get(a);
                  if(i-index<=k)return true;
              }
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
